package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketRootDto;
import softuni.exam.models.dto.TicketSeedDto;
import softuni.exam.models.dto.TownFromDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final static String TICKET_FILE_PATH = "src/main/resources/files/xml/tickets.xml";
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Ticket %s - %s";
    private final static String INVALID_MESSAGE = "Invalid Ticket";
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, PassengerRepository passengerRepository, PlaneRepository planeRepository, TownRepository townRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        Converter<String, LocalDateTime> stringToLocalDateTimeConverter
                = context -> LocalDateTime.parse(context.getSource(), DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));

        mapper.typeMap(TicketSeedDto.class, Ticket.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateTimeConverter)
                        .map(TicketSeedDto::getTakeOff, Ticket::setTakeoff));

        StringBuilder message = new StringBuilder();

        List<TicketSeedDto> ticketSeedDtos = xmlParser.deserialize(TicketRootDto.class, Path.of(TICKET_FILE_PATH).toFile()).getTickets().stream().collect(Collectors.toList());
        for (TicketSeedDto ticketSeedDto : ticketSeedDtos) {

            if (!isExistTicketWithSerialNumber(ticketSeedDto.getSerialNumber())
                    && isExistTownWithName(ticketSeedDto.getFromTown().getName())
                    && isExistTownWithName(ticketSeedDto.getToTown().getName())
                    && isExistPassengerWithEmail(ticketSeedDto.getPassenger().getEmail())
                    && isExistPlaneWithRegisterNumber(ticketSeedDto.getPlane().getRegisterNumber())
                    && validationUtil.isValid(ticketSeedDto)
            ) {
                Ticket ticket = mapper.map(ticketSeedDto, Ticket.class);
                Town fromTown = townRepository.getTownByName(ticketSeedDto.getFromTown().getName());
                ticket.setFromTown(fromTown);
                Town toTown = townRepository.getTownByName(ticketSeedDto.getToTown().getName());
                ticket.setToTown(toTown);
                Passenger passenger = passengerRepository.getPassengerByEmail(ticketSeedDto.getPassenger().getEmail());
                ticket.setPassenger(passenger);
                Plane plane = planeRepository.getPlaneByRegisterNumber(ticketSeedDto.getPlane().getRegisterNumber());
                ticket.setPlane(plane);
                ticketRepository.save(ticket);
                message.append(String.format(SUCCESSFUL_MESSAGE, ticket.getFromTown().getName(), ticket.getToTown().getName()))
                        .append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistPlaneWithRegisterNumber(String registerNumber) {
        return planeRepository.findPlaneByRegisterNumber(registerNumber).isPresent();
    }

    private boolean isExistPassengerWithEmail(String email) {
        return passengerRepository.findPassengerByEmail(email).isPresent();
    }

    private boolean isExistTownWithName(String name) {
        return townRepository.findTownByName(name).isPresent();
    }

    private boolean isExistTicketWithSerialNumber(String serialNumber) {
        return ticketRepository.findTicketBySerialNumber(serialNumber).isPresent();
    }
}
