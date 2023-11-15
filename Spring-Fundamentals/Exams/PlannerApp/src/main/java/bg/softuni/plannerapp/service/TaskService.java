package bg.softuni.plannerapp.service;

import bg.softuni.plannerapp.model.service.TaskServiceModel;
import bg.softuni.plannerapp.model.view.HomeTasksViewModel;

public interface TaskService {
    void createTask(TaskServiceModel taskServiceModel);

    HomeTasksViewModel findAllTasksForHomePage();

    void removeTask(String id);

    void returnTask(String id);

    void assignTask(String id);
}
