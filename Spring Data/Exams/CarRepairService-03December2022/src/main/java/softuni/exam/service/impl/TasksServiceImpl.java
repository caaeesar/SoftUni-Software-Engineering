package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskDto;
import softuni.exam.models.dto.TaskRootSeedDto;
import softuni.exam.models.dto.TaskSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.models.entity.enums.CarType;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported task %s";
    private static final String INVALID_MESSAGE = "Invalid task";
    private final TasksRepository tasksRepository;
    private final MechanicsRepository mechanicsRepository;
    private final CarsRepository carsRepository;
    private final PartsRepository partsRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository, MechanicsRepository mechanicsRepository, CarsRepository carsRepository, PartsRepository partsRepository, ModelMapper mapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.tasksRepository = tasksRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.carsRepository = carsRepository;
        this.partsRepository = partsRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        Converter<String, LocalDateTime> stringToLocalDateTimeConverter
                = context -> LocalDateTime.parse(context.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        mapper.typeMap(TaskSeedDto.class, Task.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateTimeConverter)
                        .map(TaskSeedDto::getDate, Task::setDate));

        StringBuilder message = new StringBuilder();
        List<TaskSeedDto> taskSeedDtos = xmlParser.deserialize(TaskRootSeedDto.class, Path.of(TASKS_FILE_PATH).toFile())
                .getTasks().stream()
               .collect(Collectors.toList());


        for (TaskSeedDto taskDto : taskSeedDtos) {

            if (isExistMechanicWithName(taskDto.getMechanic().getFirstName())
            && isExistCarWithId(taskDto.getCar().getId())
            && validationUtil.isValid(taskDto)) {


                Task task = mapper.map(taskDto, Task.class);
                Part part = partsRepository.getById(taskDto.getPart().getId());
                Car car = carsRepository.getById(taskDto.getCar().getId());
                Mechanic mechanic = mechanicsRepository.findMechanicByFirstName(taskDto.getMechanic().getFirstName()).get();
                task.setPart(part);
                task.setCar(car);
                task.setMechanic(mechanic);

                tasksRepository.save(task);
                message.append(String.format(SUCCESSFUL_MESSAGE, task.getPrice().setScale(2)));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistMechanicWithName(String firstName) {
        return mechanicsRepository.findMechanicByFirstName(firstName).isPresent();
    }
    private boolean isExistCarWithId(Long id) {
        return carsRepository.findById(id).isPresent();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
       return tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe)
                .stream()
                .map(task -> mapper.map(task, TaskDto.class))
                .map(TaskDto::toString)
                .collect(Collectors.joining(System.lineSeparator()))
                .trim();
    }
}
