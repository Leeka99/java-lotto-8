package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateWinning {

    private static List<Integer> lottoResult = new ArrayList<>(Collections.nCopies(5, 0));
    private static double rate;

    public CalculateWinning(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus,
        int money) {
        winningCount(lottoPapers, lotto, bonus);
        winningRate(money);
    }

    private int count(List<Integer> numbers, List<Integer> lotto) {
        int count = 0;
        for (int winningNumber : lotto) {
            if (Collections.frequency(numbers, winningNumber) == 1) {
                count++;
            }
        }
        return count;
    }

    private void saveCount(int count, List<Integer> numbers, int bonus) {
        if (count == 5 && Collections.frequency(numbers, bonus) == 1) {
            lottoResult.set(3, lottoResult.get(3) + 1);
            return;
        }
        if (count == 6) {
            lottoResult.set(4, lottoResult.get(4) + 1);
            return;
        }
        if (count == 3 || count == 4 || count == 5) {
            lottoResult.set(count - 3, lottoResult.get(count - 3) + 1);
        }
    }

    private void winningCount(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus) {
        for (List<Integer> numbers : lottoPapers) {
            int count = count(numbers, lotto);
            saveCount(count, numbers, bonus);
        }
    }

    private double calculatePrize() {
        double prize = 0;
        for (int index = 0; index < 5; index++) {
            prize += Winning.values()[index].getPrize() * lottoResult.get(index);
        }

        return prize;
    }

    private void winningRate(int money) {
        // 수익률 : 당첨금액합 / 구입금액 * 100
        double prize = calculatePrize();
        rate = (prize / (double) money) * 100;
    }

    public static List<Integer> getLottoResult() {
        return lottoResult;
    }

    public static double getRate() {
        return rate;
    }
}
