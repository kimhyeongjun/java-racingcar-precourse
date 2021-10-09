package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

  @Test
  void testToString() {
    final String expectResult = "-----";
    Distance distance = new Distance(5);
    assertEquals(expectResult, distance.toString());
  }
}