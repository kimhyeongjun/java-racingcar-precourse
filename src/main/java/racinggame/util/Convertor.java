package racinggame.util;

public final class Convertor {

  private Convertor() {}

  public static String[] convertStringToArray(final String str, final String regex) {
    return str.split(regex);
  }

}
