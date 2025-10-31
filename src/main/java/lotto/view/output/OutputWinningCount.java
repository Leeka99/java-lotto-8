package lotto.view.output;

import java.util.List;
import lotto.util.config.Winning;
import lotto.util.config.NumberConfig;

public class OutputWinningCount {

    public static void printWinningIntro() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningCount(List<Integer> winningValue, List<String> prizeResult, List<Integer> lottoResult) {
        for (int index = NumberConfig.START_NUMBER.getNumber(); index < lottoResult.size(); index++) {
            int value = winningValue.get(index);
            String prize = prizeResult.get(index);
            int count = lottoResult.get(index);

            if (index == Winning.FIVE_WITH_BONUS.ordinal()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개", value, prize, count);
                System.out.println();
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개", value, prize, count);
            System.out.println();
        }
    }

}
