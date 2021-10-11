package racinggame.view;

import racinggame.domain.GameResult;
import racinggame.domain.MoveResult;
import racinggame.util.Printer;

import java.util.List;

import static racinggame.enums.Message.*;

public final class GameViewer {

  private GameViewer() {}

  public static void printErrorMessageInvalidNameInput(Exception e) {
    Printer.error(e.getMessage());
  }

  public static void printRacingResult(GameResult gameResult) {
    Printer.info(String.format(WINNER.value(), gameResult.toString()));
  }

  public static void printMoveResult(MoveResult moveResult) {
    List<String> resultList = moveResult.get();
    for (String result : resultList) {
      Printer.info(result);
    }
  }

  public static void ln() {
    Printer.ln();
  }

}
