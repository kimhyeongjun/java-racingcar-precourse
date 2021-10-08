package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

  @ParameterizedTest
  @DisplayName("문자 배열내 항목의 길이 체크 테스트.")
  @MethodSource("generateData")
  void checkLengthPerItemOfArray(String[] strings, int maxLength, boolean expectResult) {
    assertEquals(expectResult, Validator.checkLengthPerItemOfArray(strings, maxLength));
  }

  @ParameterizedTest
  @DisplayName("문자가 숫자 형태인지 체크 테스트.")
  @CsvSource(value = {"3:true", "a:false", "13a:false"}, delimiter = ':')
  void isNumberFormat(String str, String expectResult) {
    assertEquals(Boolean.valueOf(expectResult), Validator.isNumberFormat(str));
  }

  static Stream<Arguments> generateData() {
    return Stream.of(
      Arguments.of(new String[] {"asdf", "aqwf"}, 5, Boolean.TRUE),
      Arguments.of(new String[] {"asdf", "asdfasdf"}, 5, Boolean.FALSE)
    );
  }

}