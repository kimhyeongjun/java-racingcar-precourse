package racinggame.util;

public final class StringUtil {

  private StringUtil() {}

  public static String removeLastComma(String str) {
    return str.replaceAll(",$", "");
  }
}
