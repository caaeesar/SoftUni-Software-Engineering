package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tasks")
public class TaskRootSeedDto {

    @XmlElement(name = "task")
    private List<TaskSeedDto> tasks;

    public List<TaskSeedDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskSeedDto> tasks) {
        this.tasks = tasks;
    }
}
