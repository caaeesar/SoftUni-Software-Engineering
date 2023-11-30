package bg.softuni.productsshop.service.impl;

import bg.softuni.productsshop.dao.UserRepository;
import bg.softuni.productsshop.model.dto.userDtos.*;
import bg.softuni.productsshop.model.entity.User;
import bg.softuni.productsshop.service.UserService;
import bg.softuni.productsshop.utils.JsonWriterUtil;
import bg.softuni.productsshop.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.productsshop.constants.FilePaths.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private Gson gson;
    private ModelMapper mapper;
    private ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepo = userRepo;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepo.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(ROOT_IN_FILE_PATH + USERS_FILE_NAME));

        UserSeedDto[] dtos = gson.fromJson(fileContent, UserSeedDto[].class);

        Arrays.stream(dtos)
                .filter(this.validationUtil::isValid) // get only valid data
                .map(userSeedDto -> this.mapper.map(userSeedDto, User.class)) // mapping dtos to entities
                .forEach(this.userRepo::save); // sava dtos to database
    }

    @Override
    public void findUsersWithSuccessfullySoldProducts() throws IOException {
        List<User> users = this.userRepo.findUsersBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastName();
        List<UserSoldDto> dtos = users.stream()
                .map(user -> this.mapper.map(user, UserSoldDto.class)).toList();
        String jsonContent = this.gson.toJson(dtos);

        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + SOLD_PRODUCTS_FILE_NAME));
    }

    @Override
    public void findUsersAndProductsInfo() throws IOException {
        List<UserWithSoldProductsDto> userWithSoldProductsDto = this.userRepo.findUsersBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastName()
                .stream().map(user -> this.mapper.map(user, UsersInfoDto.class))
                .map(UsersInfoDto::createUserWithSoldProductsDto)
                .collect(Collectors.toList());

        UsersCountWrapperDto usersCountWrapperDto = new UsersCountWrapperDto(userWithSoldProductsDto);

         FileWriter fileWriter = new FileWriter(Path.of(ROOT_OUT_FILE_PATH + USERS_PRODUCTS_FILE_NAME).toFile());
         gson.toJson(usersCountWrapperDto,fileWriter);
         fileWriter.flush();
         fileWriter.close();
    }
}
