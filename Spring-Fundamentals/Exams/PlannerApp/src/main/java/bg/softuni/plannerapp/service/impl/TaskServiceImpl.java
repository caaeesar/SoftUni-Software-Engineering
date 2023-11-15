package bg.softuni.plannerapp.service.impl;

import bg.softuni.plannerapp.model.entity.Task;
import bg.softuni.plannerapp.model.entity.User;
import bg.softuni.plannerapp.model.service.TaskServiceModel;
import bg.softuni.plannerapp.model.view.HomeTasksViewModel;
import bg.softuni.plannerapp.model.view.MyTaskViewModel;
import bg.softuni.plannerapp.model.view.OtherTaskViewModel;
import bg.softuni.plannerapp.repository.PriorityRepository;
import bg.softuni.plannerapp.repository.TaskRepository;
import bg.softuni.plannerapp.repository.UserRepository;
import bg.softuni.plannerapp.service.TaskService;
import bg.softuni.plannerapp.session.SessionUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final SessionUser sessionUser;
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;

    @Autowired
    public TaskServiceImpl(SessionUser sessionUser, TaskRepository taskRepository, ModelMapper modelMapper, UserRepository userRepository, PriorityRepository priorityRepository) {
        this.sessionUser = sessionUser;
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void createTask(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setUser(userRepository.findUserByUsername(sessionUser.getUsername()).get());
        task.setPriority(priorityRepository.findPriorityByPriorityName(taskServiceModel.getPriority()));
        taskRepository.save(task);
    }

    @Override
    public HomeTasksViewModel findAllTasksForHomePage() {
        List<Task> allTasks = taskRepository.findAll();
        List<MyTaskViewModel> myTasks = new ArrayList<>();
        List<OtherTaskViewModel> otherTasks = new ArrayList<>();

        for (int i = 0; i < allTasks.size(); i++) {
            Task task = allTasks.get(i);

            if (task.getUser() != null && task.getUser().getUsername().equals(sessionUser.getUsername())) {
                myTasks.add(modelMapper.map(task, MyTaskViewModel.class));
            } else {
                otherTasks.add(modelMapper.map(task, OtherTaskViewModel.class));
            }
        }

        return new HomeTasksViewModel(myTasks, otherTasks);
    }

    @Override
    public void removeTask(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void returnTask(String id) {
        Task task = taskRepository.findById(id).get();
        User user = userRepository.findUserByUsername(sessionUser.getUsername()).get();
        user.getAssignedTasks().remove(task);
        userRepository.save(user);
        task.setUser(null);
        taskRepository.save(task);
    }

    @Override
    public void assignTask(String id) {
        Task task = taskRepository.findById(id).get();
        User user = userRepository.findUserByUsername(sessionUser.getUsername()).get();
        task.setUser(user);
        taskRepository.save(task);
        user.getAssignedTasks().add(task);
        userRepository.save(user);
    }
}
