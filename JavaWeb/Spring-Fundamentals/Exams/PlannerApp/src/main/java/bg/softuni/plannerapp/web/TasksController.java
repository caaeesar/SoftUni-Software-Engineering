package bg.softuni.plannerapp.web;

import bg.softuni.plannerapp.model.binding.TaskAddBindingModel;
import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import bg.softuni.plannerapp.model.service.TaskServiceModel;
import bg.softuni.plannerapp.service.TaskService;
import bg.softuni.plannerapp.session.SessionUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final SessionUser sessionUser;
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public TasksController(SessionUser sessionUser, TaskService taskService, ModelMapper modelMapper) {
        this.sessionUser = sessionUser;
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public void populatePriorities(Model model) {
        model.addAttribute("priorities", PriorityName.values());
    }

    @ModelAttribute
    public TaskAddBindingModel taskAddBindingModel() {
        return new TaskAddBindingModel();
    }

    @GetMapping("/add")
    private String addTask() {
        if (sessionUser.isLogged()) {
            return "task-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    private String addTaskPost(@Valid TaskAddBindingModel taskAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:add";
        }

        TaskServiceModel taskServiceModel = modelMapper.map(taskAddBindingModel, TaskServiceModel.class);
        taskService.createTask(taskServiceModel);
        return "redirect:/";
    }

    @DeleteMapping("/done/{id}")
    public String doneTask(@PathVariable String id) {
        taskService.removeTask(id);
        return "redirect:/";
    }

    @PostMapping("/return/{id}")
    public String returnTask(@PathVariable String id) {
        taskService.returnTask(id);
        return "redirect:/";
    }

    @PostMapping("/assign/{id}")
    public String assignTask(@PathVariable String id) {
        taskService.assignTask(id);
        return "redirect:/";
    }

}
