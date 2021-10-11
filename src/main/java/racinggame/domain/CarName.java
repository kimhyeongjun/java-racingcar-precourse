package racinggame.domain;

import static racinggame.enums.Message.*;

public class CarName {

  private final String name;
  private static final int CAR_NAME_MAX_LENGTH = 5;

  public CarName(String name) {
    validateNameLength(name);
    this.name = name;
  }

  private void validateNameLength(String name) {
    if (name.length() > CAR_NAME_MAX_LENGTH) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE_INVALID_NAME_INPUT.value(), CAR_NAME_MAX_LENGTH));
    }
  }

  public String getName() {
    return this.name;
  }

}
