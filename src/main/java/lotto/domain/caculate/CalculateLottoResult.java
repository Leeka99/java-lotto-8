package lotto.domain.caculate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.config.NumberConfig;
import lotto.util.config.Winning;
import org.assertj.core.util.VisibleForTesting;

public class CalculateLottoResult {

    private static List<Integer> lottoResult = new ArrayList<>(
        Collections.nCopies(Winning.values().length, NumberConfig.START_NUMBER.getNumber()));

    public CalculateLottoResult(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus) {
        winningCount(lottoPapers, lotto, bonus);
    }

    @VisibleForTesting
    public static void reset() {
        lottoResult = new ArrayList<>(
            Collections.nCopies(Winning.values().length, NumberConfig.START_NUMBER.getNumber()));
    }

    private int count(List<Integer> numbers, List<Integer> lotto) {
        int count = NumberConfig.START_NUMBER.getNumber();
        for (int winningNumber : lotto) {
            if (Collections.frequency(numbers, winningNumber)
                == NumberConfig.EQUAL_VALUE.getNumber()) {
                count++;
            }
        }
        return count;
    }

    private void saveCount(int count, List<Integer> numbers, int bonus) {
        if (count == Winning.FIVE_WITH_BONUS.getWinningCount()
            && Collections.frequency(numbers, bonus) == NumberConfig.EQUAL_VALUE.getNumber()) {
            addLottoResult(Winning.FIVE_WITH_BONUS);
        }
        if (count == Winning.SIX.getWinningCount()) {
            addLottoResult(Winning.SIX);
        }
        if (count == Winning.THREE.getWinningCount()) {
            addLottoResult(Winning.THREE);
        }
        if (count == Winning.FOUR.getWinningCount()) {
            addLottoResult(Winning.FOUR);
        }
        if (count == Winning.FIVE.getWinningCount()) {
            addLottoResult(Winning.FIVE);
        }
    }

    private void addLottoResult(Winning winning) {
        int index = winning.ordinal();
        lottoResult.set(index, lottoResult.get(index)
            + NumberConfig.PLUS_ONE.getNumber());
    }

    private void winningCount(List<List<Integer>> lottoPapers, List<Integer> lotto, int bonus) {
        for (List<Integer> numbers : lottoPapers) {
            int count = count(numbers, lotto);
            saveCount(count, numbers, bonus);
        }
    }

    public static List<Integer> getLottoResult() {
        return lottoResult;
    }
}
