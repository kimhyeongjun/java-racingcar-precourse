package racinggame.util;

public final class Validator {

  private Validator() {}

  public static boolean isNumberFormat(String str) {
    return str.matches("^[0-9]$");
  }

}
