package lotto.view.output;

import java.util.List;
import lotto.domain.Winning;

public class OutputWinningCount {
    private static final int START_INDEX = 0;

    public static void printWinningIntro() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningCount(List<Integer> lottoResult) {
        for (int index = START_INDEX; index < lottoResult.size(); index++) {
            int count = lottoResult.get(index);
            if (index == Winning.FIVE_WITH_BONUS.ordinal()) {
                System.out.println(
                    Winning.values()[index].getWinningCount() + "개 일치, 보너스 볼 일치 " + "("
                        + String.format("%,d", Winning.values()[index].getPrize()) + "원) - " + count
                        + "개");
                continue;
            }
            System.out.println(
                Winning.values()[index].getWinningCount() + "개 일치 " + "(" + String.format(
                    "%,d", Winning.values()[index].getPrize()) + "원) - " + count + "개");
        }
    }

}
