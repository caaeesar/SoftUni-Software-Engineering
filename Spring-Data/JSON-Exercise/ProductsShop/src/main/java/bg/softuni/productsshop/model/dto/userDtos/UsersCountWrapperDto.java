package bg.softuni.productsshop.model.dto.userDtos;

import java.util.List;

public class UsersCountWrapperDto {

    private int usersCount;
    private List<UserWithSoldProductsDto> users;

    public UsersCountWrapperDto() {
    }

    public UsersCountWrapperDto(List<UserWithSoldProductsDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserWithSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductsDto> users) {
        this.users = users;
    }
}
