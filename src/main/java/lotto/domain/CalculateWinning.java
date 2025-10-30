package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateWinning {

    private static final int START_NUMBER = 0;
    private static final int EQUAL_VALUE = 1;
    private static final int PLUS_ONE = 1;
    private static final int RATE_NUMBER = 100;

    private static List<Integer> lottoResult = new ArrayList<>(
        Collections.nCopies(Winning.values().length, START_NUMBER));
    private static double rate;

    public CalculateWinning(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus,
        int money) {
        winningCount(lottoPapers, lotto, bonus);
        winningRate(money);
    }

    private int count(List<Integer> numbers, List<Integer> lotto) {
        int count = START_NUMBER;
        for (int winningNumber : lotto) {
            if (Collections.frequency(numbers, winningNumber) == EQUAL_VALUE) {
                count++;
            }
        }
        return count;
    }

    private void saveCount(int count, List<Integer> numbers, int bonus) {
        if (count == Winning.FIVE_WITH_BONUS.getWinningCount() && Collections.frequency(numbers, bonus) == EQUAL_VALUE) {
            lottoResult.set(Winning.FIVE_WITH_BONUS.ordinal(), lottoResult.get(Winning.FIVE_WITH_BONUS.ordinal()) + PLUS_ONE);
            return;
        }
        if (count == Winning.SIX.getWinningCount()) {
            lottoResult.set(Winning.SIX.ordinal(), lottoResult.get(Winning.SIX.ordinal()) + PLUS_ONE);
        }
        if (count == Winning.THREE.getWinningCount()) {
            lottoResult.set(Winning.THREE.ordinal(), lottoResult.get(Winning.THREE.ordinal()) + PLUS_ONE);
        }
        if (count == Winning.FOUR.getWinningCount()) {
            lottoResult.set(Winning.FOUR.ordinal(), lottoResult.get(Winning.FOUR.ordinal()) + PLUS_ONE);
        }
        if (count == Winning.FIVE.getWinningCount()) {
            lottoResult.set(Winning.FIVE.ordinal(), lottoResult.get(Winning.FIVE.ordinal()) + PLUS_ONE);
        }
    }

    private void winningCount(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus) {
        for (List<Integer> numbers : lottoPapers) {
            int count = count(numbers, lotto);
            saveCount(count, numbers, bonus);
        }
    }

    private double calculatePrize() {
        double prize = START_NUMBER;
        for (int index = START_NUMBER; index < lottoResult.size(); index++) {
            prize += Winning.values()[index].getPrize() * lottoResult.get(index);
        }

        return prize;
    }

    private void winningRate(int money) {
        double prize = calculatePrize();
        rate = (prize / (double) money) * RATE_NUMBER;
    }

    public static List<Integer> getLottoResult() {
        return lottoResult;
    }

    public static double getRate() {
        return rate;
    }
}
