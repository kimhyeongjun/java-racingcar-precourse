package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.GameResult;
import racinggame.domain.MoveResult;
import racinggame.domain.RacingGame;
import racinggame.util.Convertor;
import racinggame.util.Printer;
import racinggame.util.Validator;
import racinggame.view.GameViewer;
import racinggame.view.InputHandler;

import java.util.ArrayList;
import java.util.List;

import static racinggame.core.GameOption.*;
import static racinggame.enums.Message.*;

public class GameController {

  public static void startGame() {
    String[] carNames = getCarNames();
    List<Car> cars;
    try {
      cars = createCars(carNames);
    } catch (IllegalArgumentException e) {
      GameViewer.printErrorMessageInvalidNameInput(e);
      startGame();
      return;
    }
    GameResult gameResult = playGame(cars, inputMoveCount());
    GameViewer.printRacingResult(gameResult);
  }

  private static String[] getCarNames() {
    return Convertor.convertStringToArray(InputHandler.inputCarNames(), CAR_NAME_REGEX);
  }

  private static GameResult playGame(List<Car> cars, int moveCount) {
    RacingGame racingGame = new RacingGame(cars);
    Printer.info(END_GAME);
    for (int i = 0; i < moveCount; i++) {
      MoveResult moveResult = racingGame.play();
      GameViewer.printMoveResult(moveResult);
      GameViewer.ln();
    }
    return new GameResult(racingGame.getWinners());
  }

  private static int inputMoveCount() {
    String moveCount = InputHandler.inputMoveCount();
    if (!Validator.isNumberFormat(moveCount)) {
      Printer.error(ERROR_MESSAGE_INVALID_NUMBER_FORMAT);
      inputMoveCount();
    }
    return Integer.parseInt(moveCount);
  }

  private static List<Car> createCars(String[] carNames) throws IllegalArgumentException{
    List<Car> carList = new ArrayList<>();
    for (String carName : carNames) {
      carList.add(new Car(carName));
    }
    return carList;
  }

}
