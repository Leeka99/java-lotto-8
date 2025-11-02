package lotto.domain.caculate;

import lotto.util.config.MoneyConfig;

public class CalculateRate {

    private static double rate;

    public CalculateRate(int money, double totalPrize) {
        winningRate(money, totalPrize);
    }

    private void winningRate(int money, double totalPrize) {
        rate = (totalPrize / (double) money) * MoneyConfig.RATE_NUMBER.getNumber();
    }

    public static double getRate() {
        return rate;
    }
}
