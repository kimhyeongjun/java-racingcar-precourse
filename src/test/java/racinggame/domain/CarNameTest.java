package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racinggame.enums.Message.*;

class CarNameTest {

  @Test
  void createCarNameException() {
    final String name = "dafasdfsd";

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> new CarName(name)
    );

    String expectedMessage = ERROR_MESSAGE_INVALID_NAME_INPUT.value();
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

}