package bg.softuni.plannerapp.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HomeTasksViewModel {

    private List<MyTaskViewModel> myTasks;

    private List<OtherTaskViewModel> otherTasks;

    public HomeTasksViewModel(List<MyTaskViewModel> myTasks, List<OtherTaskViewModel> otherTasks) {
        this.myTasks = myTasks;
        this.otherTasks = otherTasks;
    }
}
