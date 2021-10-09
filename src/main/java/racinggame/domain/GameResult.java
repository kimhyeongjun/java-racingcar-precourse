package racinggame.domain;

import racinggame.util.StringUtil;

import java.util.List;

public class GameResult {

  private final List<Car> winners;

  public GameResult(List<Car> winners) {
    this.winners = winners;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Car winner : winners) {
      result.append(winner.getName()).append(",");
    }
    return StringUtil.removeLastComma(result.toString());
  }

}
