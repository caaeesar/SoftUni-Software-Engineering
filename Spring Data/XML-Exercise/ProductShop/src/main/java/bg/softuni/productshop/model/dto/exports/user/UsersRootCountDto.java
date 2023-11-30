package bg.softuni.productshop.model.dto.exports.user;

import bg.softuni.productshop.model.dto.exports.user.UserSoldProductsDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UsersRootCountDto {

    @XmlAttribute(name = "count")
    private Integer count;
    @XmlElement(name = "user")
    private List<UserSoldProductsDto> users;

    public UsersRootCountDto() {
    }

    public UsersRootCountDto(List<UserSoldProductsDto> users) {
        this.users = users;
        this.count = users.size();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductsDto> users) {
        this.users = users;
    }
}
