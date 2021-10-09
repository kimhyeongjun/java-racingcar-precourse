package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

  private final List<Car> carList;

  public MoveResult(List<Car> carList) {
    this.carList = carList;
  }

  public List<String> get() {
    List<String> carMoveResultList = new ArrayList<>();
    for (Car car : carList) {
      carMoveResultList.add(car.toString());
    }
    return carMoveResultList;
  }
}
