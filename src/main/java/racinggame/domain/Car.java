package racinggame.domain;

public class Car {

  private final CarName name;
  private Distance distance;

  public Car(final String name) {
    this.name = new CarName(name);
    this.distance = new Distance();
  }

  public void move() {
    this.distance = this.distance.increase();
  }

  public String getName() {
    return name.getName();
  }

  public int getDistance() {
    return distance.getValue();
  }

  @Override
  public String toString() {
    return name.getName() + " : " + distance.toString();
  }

}
