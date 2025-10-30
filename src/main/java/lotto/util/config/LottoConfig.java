package lotto.util.config;

public enum LottoConfig {
    LOTTO_LENGTH(6),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45);

    private final int number;

    LottoConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
