package softuni.exam.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "team")
public class TeamSeedDto {

    @XmlElement
    @NotNull
    @Length(min = 3, max = 20)
    private String name;

    @XmlElement
    @NotNull
    private PictureWithUrlDto picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureWithUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureWithUrlDto picture) {
        this.picture = picture;
    }
}
