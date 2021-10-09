package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

  @Test
  @DisplayName("자동차 생성 테스트")
  void createCar() {
    final String name = "good";
    Car car = new Car(name);
    assertEquals(name, car.getName());
  }

  @Test
  @DisplayName("자동차 이동 테스트")
  void move() {
    final String name = "good";
    Car car = new Car(name);
    car.move();
    assertEquals(1, car.getDistance());
  }

}