package bg.softuni.productshop.service.impl;

import bg.softuni.productshop.dao.UserRepository;
import bg.softuni.productshop.model.dto.exports.user.*;
import bg.softuni.productshop.model.dto.imports.UserRootSeedDto;
import bg.softuni.productshop.model.entity.User;
import bg.softuni.productshop.service.UserService;
import bg.softuni.productshop.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.productshop.constants.FilePaths.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedUsers() throws JAXBException, FileNotFoundException {
        if (userRepository.count() > 0) {
            return;
        }
        UserRootSeedDto rootSeedDto = xmlParser.deserialize(UserRootSeedDto.class, ROOT_IN_FILE_PATH + USERS_FILE_NAME);
        rootSeedDto.getUsers().stream()
                .map(userSeedDto -> mapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public void findUsersWithSuccessfullySoldProducts() throws JAXBException {
        List<User> users = this.userRepository.findUsersBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastName();
        List<UserWithSoldProductsDto> userWithSoldProductsDtos =
                users.stream()
                .map(user -> mapper.map(user, UserWithSoldProductsDto.class))
                .toList();

        UserRootWithSoldProductsDto rootWithSoldProductsDto = new UserRootWithSoldProductsDto();
        rootWithSoldProductsDto.setUsers(userWithSoldProductsDtos);
        xmlParser.serialize(rootWithSoldProductsDto, ROOT_OUT_FILE_PATH + SOLD_PRODUCTS_FILE_NAME);
    }

    @Override
    public void findUsersAndProductsInfo() throws JAXBException {
        List<UserSoldProductsDto> UserSoldProductsDto = this.userRepository.findUsersBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastName()
                .stream()
                .map(user -> this.mapper.map(user, UserWrapperDto.class))
                .map(UserWrapperDto::createUserWithSoldProductsDto)
                .collect(Collectors.toList());
        UsersRootCountDto usersCountWrapperDto = new UsersRootCountDto(UserSoldProductsDto);

        xmlParser.serialize(usersCountWrapperDto, ROOT_OUT_FILE_PATH + USERS_PRODUCTS_FILE_NAME);
    }
}
