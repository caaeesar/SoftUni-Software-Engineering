package bg.softuni.cookingadventure.service.impl;

import bg.softuni.cookingadventure.model.entity.RecipeEntity;
import bg.softuni.cookingadventure.model.entity.RoleEntity;
import bg.softuni.cookingadventure.model.entity.UserEntity;
import bg.softuni.cookingadventure.model.entity.enums.RoleName;
import bg.softuni.cookingadventure.model.service.UserServiceModel;
import bg.softuni.cookingadventure.model.view.FavoriteRecipesViewModel;
import bg.softuni.cookingadventure.model.view.MyRecipesViewModel;
import bg.softuni.cookingadventure.model.view.UserViewModel;
import bg.softuni.cookingadventure.repository.RecipeRepository;
import bg.softuni.cookingadventure.repository.RoleRepository;
import bg.softuni.cookingadventure.repository.UserRepository;
import bg.softuni.cookingadventure.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, RecipeRepository recipeRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        Optional<UserEntity> userByUsername = userRepository.findUserByUsername(userServiceModel.getUsername());
        Optional<UserEntity> userByEmail = userRepository.findUserByEmail(userServiceModel.getEmail());
        if (userByUsername.isPresent() || userByEmail.isPresent()) {
            return false;
        }

        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        if (userRepository.count() == 0) {
            userEntity.getRoles().add(roleRepository.getRoleByName(RoleName.ADMINISTRATOR));
        } else {
            userEntity.getRoles().add(roleRepository.getRoleByName(RoleName.USER));
        }

        userRepository.save(userEntity);
        return true;
    }

    @Override
    public List<MyRecipesViewModel> findCreatedRecipes(String username) {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .filter(recipeEntity -> recipeEntity.getAuthor().getUsername().equals(username))
                .map(recipeEntity -> modelMapper.map(recipeEntity, MyRecipesViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Set<FavoriteRecipesViewModel> findFavoriteRecipes(String username) {
        UserEntity user = userRepository.findUserByUsername(username).get();
        Set<RecipeEntity> favoriteRecipes = user.getFavoriteRecipes();
        return favoriteRecipes.stream()
                .map(recipeEntity -> modelMapper.map(recipeEntity, FavoriteRecipesViewModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public void addToFavorite(Long id, String username) {
        UserEntity user = userRepository.findUserByUsername(username).get();
        RecipeEntity recipe = recipeRepository.findById(id).get();
        Set<RecipeEntity> favoriteRecipes = user.getFavoriteRecipes();

        favoriteRecipes.add(recipe);
        user.setFavoriteRecipes(favoriteRecipes);

        userRepository.saveAndFlush(user);
    }

    @Override
    public void removeFromFavorite(Long id, String username) {
        UserEntity user = userRepository.findUserByUsername(username).get();
        RecipeEntity recipe = recipeRepository.findById(id).get();

        user.getFavoriteRecipes().remove(recipe);
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).get();
    }

    @Override
    public List<UserViewModel> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(userEntity -> modelMapper.map(userEntity, UserViewModel.class)).toList();
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        List<RecipeEntity> recipes = user.getCreatedRecipes();

        for (int i = 0; i < recipes.size(); i++) {
            RecipeEntity recipe = recipes.get(i);
            recipe.setAuthor(null);
        }
        user.setRoles(null);
        user.setFavoriteRecipes(null);
        user.setCreatedRecipes(null);

        userRepository.deleteById(id);
    }

    @Override
    public void manageUserRoles(Long id, List<Long> roleIds) {
        UserEntity user = userRepository.findById(id).get();
        List<RoleEntity> roles = roleRepository.findAllById(roleIds);

        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);
    }
}
