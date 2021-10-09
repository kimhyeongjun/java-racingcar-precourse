package racinggame.domain;

public class Distance {

  private final int value;

  public Distance() {
    this.value = 0;
  }

  public Distance(int value) {
    this.value = value;
  }

  public Distance increase() {
    return new Distance(this.value + 1);
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return createStringOfDistance();
  }

  private String createStringOfDistance() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < value; i++) {
      str.append("-");
    }

    return str.toString();
  }
}
