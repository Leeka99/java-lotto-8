package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.config.MoneyConfig;
import lotto.util.config.NumberConfig;
import lotto.util.config.Winning;
import org.assertj.core.util.VisibleForTesting;

public class CalculateWinning {

    private static List<Integer> lottoResult = new ArrayList<>(
        Collections.nCopies(Winning.values().length, NumberConfig.START_NUMBER.getNumber()));
    private static List<Integer> winningValue = new ArrayList<>();
    private static List<String> prizeResult = new ArrayList<>();
    private static double rate;
    private static String rateLetter;

    public CalculateWinning(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus,
        int money) {
        winningCount(lottoPapers, lotto, bonus);
        winningRate(money);

        saveResult();
        parseToLetter(rate);
    }

    @VisibleForTesting
    CalculateWinning() {
        saveResult();
        parseToLetter(rate);
    }

    @VisibleForTesting
     static void reset() {
        lottoResult = new ArrayList<>(Collections.nCopies(Winning.values().length, NumberConfig.START_NUMBER.getNumber()));
        winningValue = new ArrayList<>();
        prizeResult = new ArrayList<>();
    }

    private int count(List<Integer> numbers, List<Integer> lotto) {
        int count = NumberConfig.START_NUMBER.getNumber();
        for (int winningNumber : lotto) {
            if (Collections.frequency(numbers, winningNumber) == NumberConfig.EQUAL_VALUE.getNumber()) {
                count++;
            }
        }
        return count;
    }

    private void saveCount(int count, List<Integer> numbers, int bonus) {
        if (count == Winning.FIVE_WITH_BONUS.getWinningCount() && Collections.frequency(numbers, bonus) == NumberConfig.EQUAL_VALUE.getNumber()) {
            lottoResult.set(Winning.FIVE_WITH_BONUS.ordinal(), lottoResult.get(Winning.FIVE_WITH_BONUS.ordinal()) + NumberConfig.PLUS_ONE.getNumber());
            return;
        }
        if (count == Winning.SIX.getWinningCount()) {
            lottoResult.set(Winning.SIX.ordinal(), lottoResult.get(Winning.SIX.ordinal()) + NumberConfig.PLUS_ONE.getNumber());
        }
        if (count == Winning.THREE.getWinningCount()) {
            lottoResult.set(Winning.THREE.ordinal(), lottoResult.get(Winning.THREE.ordinal()) + NumberConfig.PLUS_ONE.getNumber());
        }
        if (count == Winning.FOUR.getWinningCount()) {
            lottoResult.set(Winning.FOUR.ordinal(), lottoResult.get(Winning.FOUR.ordinal()) + NumberConfig.PLUS_ONE.getNumber());
        }
        if (count == Winning.FIVE.getWinningCount()) {
            lottoResult.set(Winning.FIVE.ordinal(), lottoResult.get(Winning.FIVE.ordinal()) + NumberConfig.PLUS_ONE.getNumber());
        }
    }

    private void winningCount(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus) {
        for (List<Integer> numbers : lottoPapers) {
            int count = count(numbers, lotto);
            saveCount(count, numbers, bonus);
        }
    }

    private double calculatePrize() {
        double prize = NumberConfig.START_NUMBER.getNumber();
        for (int index = NumberConfig.START_NUMBER.getNumber(); index < lottoResult.size(); index++) {
            prize += Winning.values()[index].getPrize() * lottoResult.get(index);
        }

        return prize;
    }

    private void winningRate(int money) {
        double prize = calculatePrize();
        rate = (prize / (double) money) * MoneyConfig.RATE_NUMBER.getNumber();
    }

    private void saveResult() {
        for (int index = NumberConfig.START_NUMBER.getNumber(); index < lottoResult.size(); index++) {
            winningValue.add(Winning.values()[index].getWinningCount());
            prizeResult.add(String.format("%,d", Winning.values()[index].getPrize()));
        }
    }

    private void parseToLetter(double rate) {
        rateLetter =  String.format("%,.1f", rate);
    }

    public static List<Integer> getLottoResult() {
        return lottoResult;
    }

    public static double getRate() {
        return rate;
    }

    public static String getRateLetter() {
        return rateLetter;
    }

    public static List<Integer> getWinningValue() {
        return winningValue;
    }

    public static List<String> getPrizeResult() {
        return prizeResult;
    }
}
