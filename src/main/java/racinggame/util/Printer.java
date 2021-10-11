package racinggame.util;

import racinggame.enums.Message;

public final class Printer {

  private Printer() {}

  public static void info(Message message) {
    System.out.println(message.value());
  }

  public static void error(Message message) {
    System.out.println(message.value());
  }

  public static void error(String message) {
    System.out.println(message);
  }

  public static void info(String message) {
    System.out.println(message);
  }

  public static void ln() {
    System.out.println();
  }
}
