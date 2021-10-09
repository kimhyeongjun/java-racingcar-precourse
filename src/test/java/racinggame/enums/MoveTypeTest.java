package racinggame.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class MoveTypeTest {

  @ParameterizedTest
  @DisplayName("자동차 이동타입별 테스트.")
  @CsvSource(value = {"GO:1", "STOP:0"}, delimiter = ':')
  void move(String type, int expectResult) {
    MoveType moveType = MoveType.valueOf(type);
    Car car = new Car("A");
    moveType.apply(car);
    assertEquals(expectResult, car.getDistance());
  }

}