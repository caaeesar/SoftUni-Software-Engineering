package bg.softuni.plannerapp.web;

import bg.softuni.plannerapp.model.view.HomeTasksViewModel;
import bg.softuni.plannerapp.service.TaskService;
import bg.softuni.plannerapp.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SessionUser sessionUser;
    private final TaskService taskService;

    @Autowired
    public HomeController(SessionUser sessionUser, TaskService taskService) {
        this.sessionUser = sessionUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        if (sessionUser.isLogged()) {
            HomeTasksViewModel homeTasks = taskService.findAllTasksForHomePage();
            model.addAttribute("homeTasks", homeTasks);
            return "home";
        }
        return "index";
    }

}
