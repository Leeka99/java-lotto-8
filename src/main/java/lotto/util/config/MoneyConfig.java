package lotto.util.config;

public enum MoneyConfig {
    RATE_NUMBER(100),
    MONEY_START(1000),
    CHECK_MONEY_VALUE(0);

    private final int number;

    MoneyConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
