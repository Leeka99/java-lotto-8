package lotto.domain.caculate;

import java.util.List;
import lotto.util.config.NumberConfig;
import lotto.util.config.Winning;
import org.assertj.core.util.VisibleForTesting;

public class CalculateTotalPrize {

    private static double totalPrize = NumberConfig.START_NUMBER.getNumber();

    public CalculateTotalPrize(List<Integer> lottoResult) {
        calculatePrize(lottoResult);
    }

    @VisibleForTesting
    public static void reset() {
        totalPrize = NumberConfig.START_NUMBER.getNumber();
    }

    private void calculatePrize(List<Integer> lottoResult) {
        for (int index = NumberConfig.START_NUMBER.getNumber(); index < lottoResult.size();
            index++) {
            totalPrize += (double) Winning.values()[index].getPrize() * lottoResult.get(index);
        }
    }

    public static double getTotalPrize() {
        return totalPrize;
    }
}
