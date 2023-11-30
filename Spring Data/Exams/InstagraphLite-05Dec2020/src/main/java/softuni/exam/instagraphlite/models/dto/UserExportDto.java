package softuni.exam.instagraphlite.models.dto;

import java.util.ArrayList;
import java.util.List;

public class UserExportDto {

    private String username;
    private List<PostWithCaptionDto> posts = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostWithCaptionDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostWithCaptionDto> posts) {
        this.posts = posts;
    }
}
