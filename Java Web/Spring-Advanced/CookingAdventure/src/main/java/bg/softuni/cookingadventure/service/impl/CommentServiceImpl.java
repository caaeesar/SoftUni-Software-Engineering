package bg.softuni.cookingadventure.service.impl;

import bg.softuni.cookingadventure.model.entity.CommentEntity;
import bg.softuni.cookingadventure.model.service.CommentCreateServiceModel;
import bg.softuni.cookingadventure.model.view.CommentViewModel;
import bg.softuni.cookingadventure.repository.CommentRepository;
import bg.softuni.cookingadventure.repository.RecipeRepository;
import bg.softuni.cookingadventure.repository.UserRepository;
import bg.softuni.cookingadventure.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, RecipeRepository recipeRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentViewModel> getCommentsByRecipe(Long id) {
        return commentRepository.findAllByRecipe_Id(id)
                .stream()
                .map(commentEntity -> modelMapper.map(commentEntity, CommentViewModel.class))
                .toList();
    }

    @Override
    public CommentViewModel createComment(CommentCreateServiceModel commentCreateServiceModel, Long recipeId, String username) {
        CommentEntity comment = modelMapper.map(commentCreateServiceModel, CommentEntity.class);
        comment.setDateTimePost(LocalDateTime.now());
        comment.setAuthor(userRepository.findUserByUsername(username).get());
        comment.setRecipe(recipeRepository.findById(recipeId).get());

        commentRepository.save(comment);
        return modelMapper.map(comment, CommentViewModel.class);
    }
}
