package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveResultTest {

  static Stream<Arguments> generateTestData() {
    return Stream.of(
      Arguments.of(createCars(), new int[]{1, 2}, Arrays.asList("A:-", "B:--")),
      Arguments.of(createCars(), new int[]{1, 3}, Arrays.asList("A:-", "B:---"))
    );
  }

  private static List<Car> createCars() {
    return Arrays.asList(new Car("A"), new Car("B"));
  }

  @ParameterizedTest
  @DisplayName("경주 결과 생성 테스트.")
  @MethodSource("generateTestData")
  void getResult(List<Car> cars, int[] moveCountArr, List<String> expectResult) {
    for (int i = 0; i < cars.size(); i++) {
      Car car = cars.get(i);
      moveCar(car, moveCountArr[i]);
    }
    MoveResult moveResult = new MoveResult(cars);
    assertIterableEquals(expectResult, moveResult.get());
  }

  private void moveCar(Car car, int moveCount) {
    for (int i = 0; i < moveCount; i++) {
      car.move();
    }
  }

}