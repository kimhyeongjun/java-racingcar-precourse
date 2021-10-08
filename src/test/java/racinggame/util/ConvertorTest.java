package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorTest {

  @Test
  @DisplayName("문자열 나누기 테스트")
  void convertStringToArray() {
    assertArrayEquals(new String[] {"1", "2", "3"}, Convertor.convertStringToArray("1,2,3", ","));
  }
}