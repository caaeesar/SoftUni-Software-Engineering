package bg.softuni.automappingobjectsexercise.service;

import bg.softuni.automappingobjectsexercise.model.dto.game.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.dto.game.GameViewDto;

import java.util.List;

public interface GameService {
    String addGame(GameAddDto gameDto);
    String editGame(String[] info);

    String deleteGame(long id);

    List<GameViewDto> getAllGames();

    String getGameInfo(String title);

}
