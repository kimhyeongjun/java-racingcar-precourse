package racinggame.view;

import nextstep.utils.Console;
import racinggame.util.Printer;

import static racinggame.enums.Message.*;

public final class InputHandler {

  private InputHandler() {}

  public static String inputCarNames() {
    Printer.info(START_GAME);
    return Console.readLine();
  }

  public static String inputMoveCount() {
    Printer.info(ASK_INPUT_MOVE_COUNT);
    return Console.readLine();
  }
}
