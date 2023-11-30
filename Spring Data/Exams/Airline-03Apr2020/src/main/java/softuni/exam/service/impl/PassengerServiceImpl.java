package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerExportDto;
import softuni.exam.models.dto.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PassengerServiceImpl implements PassengerService {

    private final static String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Passenger %s - %s";
    private final static String INVALID_MESSAGE = "Invalid Passenger";
    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, TownRepository townRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder message = new StringBuilder();

        List<PassengerSeedDto> passengerSeedDtos = Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class)).collect(Collectors.toList());
        for (PassengerSeedDto passengerSeedDto : passengerSeedDtos) {

            if (!isExistPassengerWithEmail(passengerSeedDto.getEmail())
                    && isExistTownWithName(passengerSeedDto.getTown())
                    && validationUtil.isValid(passengerSeedDto)) {

                Passenger passenger = mapper.map(passengerSeedDto, Passenger.class);
                Town town = townRepository.getTownByName(passengerSeedDto.getTown());
                passenger.setTown(town);
                passengerRepository.save(passenger);
                message.append(String.format(SUCCESSFUL_MESSAGE,passenger.getLastName(), passenger.getEmail())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistTownWithName(String name) {
        return townRepository.findTownByName(name).isPresent();
    }

    private boolean isExistPassengerWithEmail(String email) {
        return passengerRepository.findPassengerByEmail(email).isPresent();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        return passengerRepository.getPassengerWithNumberOfTickets()
                .stream()
                .map(passenger -> mapper.map(passenger, PassengerExportDto.class))
                .map(PassengerExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
