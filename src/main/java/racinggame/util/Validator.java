package racinggame.util;

import java.util.function.Function;

public final class Validator {

  private Validator() {}

  public static boolean checkLengthPerItemOfArray(final String[] strArr, final int maxLength) {
    if (strArr.length <= 0) {
      return Boolean.FALSE;
    }
    return doRecursiveProcess(0, strArr, s -> s.length() < maxLength && s.length() > 0);
  }

  private static boolean doRecursiveProcess(int index, String[] strArr, Function<String, Boolean> maxLengthCheckFunc) {
    if (index >= strArr.length) {
      return Boolean.TRUE;
    }

    return maxLengthCheckFunc.apply(strArr[index]) ? doRecursiveProcess(index + 1, strArr,
      maxLengthCheckFunc) : Boolean.FALSE;
  }

  public static boolean isNumberFormat(String str) {
    return str.matches("^[0-9]$");
  }

}
