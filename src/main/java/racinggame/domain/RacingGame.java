package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.enums.MoveType;

import java.util.ArrayList;
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

  public List<Car> getWinners() {
    List<Car> winners = new ArrayList<>();
    int maxDistance = getMaxDistance();
    for (Car car : cars) {
      addWinner(winners, car, maxDistance);
    }

    return winners;
  }

  private int getMaxDistance() {
    int max = 0;
    for (Car car : cars) {
      max = Math.max(max, car.getDistance());
    }

    return max;
  }

  private void addWinner(List<Car> winners, Car car, final int maxDistance) {
    if (isWinner(car, maxDistance)) {
      winners.add(car);
    }
  }

  private boolean isWinner(final Car car, final int maxDistance) {
    return car.getDistance() == maxDistance;
  }

}
