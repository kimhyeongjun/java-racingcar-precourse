package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.enums.MoveType;

import java.util.List;

import static racinggame.core.GameOption.*;

public class RacingGame {

  private final List<Car> cars;

  public RacingGame(List<Car> cars) {
    this.cars = cars;
  }

  public MoveResult play() {
    moveCars();
    return new MoveResult(cars);
  }

  private void moveCars() {
    for (Car car : cars) {
      MoveType moveType = MoveType.of(Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE[0], RANDOM_NUMBER_RANGE[1]));
      moveType.apply(car);
    }
  }

}
