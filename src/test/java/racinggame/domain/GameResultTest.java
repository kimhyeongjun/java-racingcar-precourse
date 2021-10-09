package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

  static Stream<Arguments> generateTestDataForCreateGameResult() {
    return Stream.of(
      Arguments.of(createCars(), new int[]{1, 2, 3}, "C"),
      Arguments.of(createCars(), new int[]{1, 3, 3}, "B,C")
    );
  }

  private static List<Car> createCars() {
    return Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
  }

  @ParameterizedTest
  @DisplayName("게임 결과 생성 테스트.")
  @MethodSource("generateTestDataForCreateGameResult")
  void createResult(List<Car> cars, int[] moveCountArr, String expectResult) {
    for (int i = 0; i < cars.size(); i++) {
      Car car = cars.get(i);
      moveCar(car, moveCountArr[i]);
    }
    GameResult gameResult = new GameResult(cars);
    assertEquals(expectResult, gameResult.toString());
  }

  private void moveCar(Car car, int moveCount) {
    for (int i = 0; i < moveCount; i++) {
      car.move();
    }
  }

}