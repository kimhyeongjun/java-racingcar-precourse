package racinggame.enums;

import racinggame.domain.Car;

import java.util.function.Function;

public enum MoveType {

  GO(1),
  STOP(0);

  private static Function<Integer, Boolean> getStatus = num -> num >= 4;

  private final int num;

  MoveType(int num) {
    this.num = num;
  }

  public static MoveType of(final int command) {
    return getStatus.apply(command) ? GO : STOP;
  }

  public void apply(Car car) {
    if (this.num != 0) {
      car.move();
    }
  }
}
