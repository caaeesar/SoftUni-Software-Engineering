package bg.softuni.automappingobjectsexercise.service.impl;

import bg.softuni.automappingobjectsexercise.dao.GameRepository;
import bg.softuni.automappingobjectsexercise.exception.IncorrectURLException;
import bg.softuni.automappingobjectsexercise.exception.NonNegativeValueException;
import bg.softuni.automappingobjectsexercise.exception.IncorrectStringFormatException;
import bg.softuni.automappingobjectsexercise.model.dto.game.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.dto.game.GameDetailsDto;
import bg.softuni.automappingobjectsexercise.model.dto.game.GameViewDto;
import bg.softuni.automappingobjectsexercise.model.entity.Game;
import bg.softuni.automappingobjectsexercise.model.entity.User;
import bg.softuni.automappingobjectsexercise.service.GameService;
import bg.softuni.automappingobjectsexercise.service.UserService;
import bg.softuni.automappingobjectsexercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static bg.softuni.automappingobjectsexercise.constant.ErrorMessages.*;
import static bg.softuni.automappingobjectsexercise.constant.InformMessages.*;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepo;
    private final UserService userService;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public GameServiceImpl(GameRepository gameRepo, UserService userService, ModelMapper mapper, ValidationUtil validationUtil) {
        this.gameRepo = gameRepo;
        this.userService = userService;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public String addGame(GameAddDto gameDto) {
        if (!this.validationUtil.isValid(gameDto)) {
            return this.validationUtil.violations(gameDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(System.lineSeparator()));
        } else {
            Game game = this.mapper.map(gameDto, Game.class);

            if (this.userService.isLoggedInUserAdmin()) {
                this.gameRepo.save(game);
                return String.format(SUCCESSFULLY_GAME_ADDED, game.getTitle());
            } else {
                return NOT_ADMIN;
            }
        }
    }

    @Override
    public String editGame(String[] info) {
        // skip command info[0]
        Long id = Long.parseLong(info[1]);
        Map<String, String> fieldsValuesForUpdate = new HashMap<>();
        // skip id -> start from 2 index
        for (int i = 2; i < info.length; i++) {
            String pair = info[i];
            String field = pair.split("=")[0];
            String value = pair.split("=")[1];
            fieldsValuesForUpdate.put(field, value);
        }

        Optional<Game> game = this.gameRepo.findById(id);
        if (game.isPresent()) {
            if (this.userService.isLoggedInUserAdmin()) {
                updateField(fieldsValuesForUpdate, game.get());
                this.gameRepo.save(game.get());
                return String.format(SUCCESSFULLY_EDITED_GAMES, game.get().getTitle());
            } else {
                return NOT_ADMIN;
            }
        } else {
            return String.format(NOT_EXIST_GAME_WITH_ID, id);
        }
    }

    @Override
    public String deleteGame(long id) {
        if (this.userService.isLoggedInUserAdmin()) {
            Optional<Game> game = this.gameRepo.findById(id);
            if (game.isPresent()) {
                this.gameRepo.delete(game.get());
                return String.format(SUCCESSFULLY_DELETED_GAME, game.get().getTitle());
            } else {
                return NOT_EXIST_GAME_WITH_ID;
            }
        } else {
            return NOT_ADMIN;
        }
    }

    @Override
    public List<GameViewDto> getAllGames() {
        return this.gameRepo.findAll().stream().map(game -> this.mapper.map(game, GameViewDto.class)).collect(Collectors.toList());
    }

    @Override
    public String getGameInfo(String title) {
        Optional<Game> game = this.gameRepo.findGameByTitle(title);
        if (game.isPresent()) {
            return this.mapper.map(game, GameDetailsDto.class).toString();
        } else {
            return String.format(NOT_EXIST_GAME_WITH_TITLE, title);
        }
    }

    private void updateField(Map<String, String> fieldsValuesForUpdate, Game game) {
        for (Map.Entry<String, String> pair : fieldsValuesForUpdate.entrySet()) {
            String field = pair.getKey();
            String value = pair.getValue();

            switch (field) {
                case "title" -> game.setTitle(validateTitle(value));
                case "price" -> game.setPrice(BigDecimal.valueOf(validatePrice(value)));
                case "size" -> game.setSize(validateSize(value));
                case "trailer" -> game.setTrailer(validateTrailer(value));
                case "thumbnailURL" -> game.setImageThumbnail(validateThumbnail(value));
                case "description" -> game.setDescription(validateDescription(value));
                case "releaseDate" ->
                        game.setReleaseDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyy")));
            }
        }
    }

    private String validateDescription(String value) {
        if (value.length() < 20) {
            throw new IncorrectStringFormatException(INCORRECT_DESCRIPTION);
        }
        return value;
    }

    private String validateThumbnail(String value) {
        if (!value.startsWith("http://") || !value.startsWith("https://")) {
            throw new IncorrectURLException(INCORRECT_URL);
        }
        return value;
    }

    private String validateTrailer(String value) {
        if (value.length() != 11) {
            throw new IncorrectStringFormatException(INCORRECT_TRAILER);
        }
        return value;
    }

    private double validateSize(String value) {
        double size = Double.parseDouble(value);
        if (size < 0) {
            throw new NonNegativeValueException(INCORRECT_SIZE);
        }
        return size;
    }

    private double validatePrice(String value) {
        double price = Double.parseDouble(value);
        if (price < 0) {
            throw new NonNegativeValueException(INCORRECT_PRICE);
        }
        return price;
    }

    private String validateTitle(String value) {
        if (!Character.isUpperCase(value.charAt(0)) || value.length() < 3 || value.length() > 100) {
            throw new IncorrectStringFormatException(INCORRECT_TITLE);
        }
        return value;
    }
}
