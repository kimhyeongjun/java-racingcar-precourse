package racinggame.enums;

public enum Message {

  START_GAME("경주할 자동자 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
  ASK_INPUT_MOVE_COUNT("시도할 횟수는 몇회인가요?"),
  END_GAME("실행결과"),
  WINNER("최종 우승자는 %s 입니다."),
  ERROR_MESSAGE_INVALID_NAME_INPUT("[ERROR] 자동차 이름은 %d자리 이하입니다."),
  ERROR_MESSAGE_INVALID_NUMBER_FORMAT("[ERROR] 횟수는 숫자만 입력가능합니다. 다시 입력해주세요.")
  ;

  private final String value;

  Message(String value) {
    this.value = value;
  }

  public String value() {
    return this.value;
  }
}
