package lotto.util.config;

public enum NumberConfig {
    START_NUMBER(0),
    EQUAL_VALUE(1),
    PLUS_ONE(1),
    PRIZE_LENGTH(5);

    private final int number;

    NumberConfig (int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
