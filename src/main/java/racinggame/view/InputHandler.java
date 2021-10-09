package racinggame.view;

import nextstep.utils.Console;
import racinggame.util.Convertor;
import racinggame.util.Printer;

import static racinggame.core.GameOption.*;
import static racinggame.enums.Message.*;

public final class InputHandler {

  private InputHandler() {}

  public static String[] inputCarNames() {
    Printer.info(START_GAME);
    String carListStr = Console.readLine();
    return Convertor.convertStringToArray(carListStr, CAR_NAME_REGEX);
  }

  public static String inputMoveCount() {
    Printer.info(ASK_INPUT_MOVE_COUNT);
    return Console.readLine();
  }
}
