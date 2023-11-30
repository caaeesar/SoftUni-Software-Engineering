package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "post")
public class PostSeedDto {

    @XmlElement
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement
    @NotNull
    private UserWithUsernameDto user;

    @XmlElement
    @NotNull
    private PictureWithPathDto picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserWithUsernameDto getUser() {
        return user;
    }

    public void setUser(UserWithUsernameDto user) {
        this.user = user;
    }

    public PictureWithPathDto getPicture() {
        return picture;
    }

    public void setPicture(PictureWithPathDto picture) {
        this.picture = picture;
    }
}
