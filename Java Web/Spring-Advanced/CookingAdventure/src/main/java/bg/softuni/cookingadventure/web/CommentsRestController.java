package bg.softuni.cookingadventure.web;

import bg.softuni.cookingadventure.model.binding.CommentCreateBindingModel;
import bg.softuni.cookingadventure.model.service.CommentCreateServiceModel;
import bg.softuni.cookingadventure.model.view.CommentViewModel;
import bg.softuni.cookingadventure.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentsRestController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentsRestController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/api/{recipeId}/comments", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommentViewModel> createComment(@RequestBody CommentCreateBindingModel commentCreateBindingModel,
                                                          @PathVariable Long recipeId,
                                                          Principal principal) {

        CommentCreateServiceModel commentCreateServiceModel = modelMapper.map(commentCreateBindingModel, CommentCreateServiceModel.class);
        CommentViewModel commentViewModel = commentService.createComment(commentCreateServiceModel, recipeId, principal.getName());
        return ResponseEntity.created(URI.create(String.format("/api/%s/comments/%d", recipeId, commentCreateServiceModel.getId()))).body(commentViewModel);
    }

    @GetMapping("/api/{recipeId}/comments")
    public ResponseEntity<List<CommentViewModel>> getCommentsRecipe(@PathVariable Long recipeId) {
        List<CommentViewModel> comments = commentService.getCommentsByRecipe(recipeId);
        return ResponseEntity.ok(comments);
    }

}
