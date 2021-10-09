package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RacingGameTest {

  public static Stream<Arguments> generateTestDataForPlay() {
    return Stream.of(
      Arguments.of(4, new int[]{4, 3}, Arrays.asList("A : -", "B : -", "C : ")),
      Arguments.of(4, new int[]{4, 4}, Arrays.asList("A : -", "B : -", "C : -")),
      Arguments.of(4, new int[]{3, 3}, Arrays.asList("A : -", "B : ", "C : "))
    );
  }

  private static List<Car> createCars() {
    return Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
  }

  @ParameterizedTest
  @DisplayName("자동차 레이싱 테스트")
  @MethodSource("generateTestDataForPlay")
  void play(int value, int[] values, List<String> expectResult) {
    try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
      mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
        .thenReturn(value,  Arrays.stream(values).boxed().toArray());
      RacingGame racingGame = new RacingGame(createCars());

      MoveResult moveResult = racingGame.play();
      assertIterableEquals(expectResult, moveResult.get());
    }
  }

}