package lotto.view.output;

import java.util.List;
import lotto.util.config.NumberConfig;
import lotto.util.config.Winning;

public class OutputWinningCount {

    public static void printWinningIntro() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningCount(List<String> prizeResult, List<Integer> lottoResult) {
        for (int index = NumberConfig.START_NUMBER.getNumber(); index < lottoResult.size();
            index++) {
            int value = Winning.values()[index].getWinningCount();
            String prize = prizeResult.get(index);
            int count = lottoResult.get(index);

            matchResult(index, value, prize, count);
        }
    }

    private static void matchResult(int index, int value, String prize, int count) {
        if (index == Winning.FIVE_WITH_BONUS.ordinal()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개", value, prize, count);
            System.out.println();
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개", value, prize, count);
        System.out.println();
    }
}
