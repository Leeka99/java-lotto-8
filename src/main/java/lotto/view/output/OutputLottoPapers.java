package lotto.view.output;

import java.util.List;

public class OutputLottoPapers {

    public static void printPaperNumber(int paperCount) {
        System.out.println();
        System.out.println(paperCount + "개를 구매했습니다.");
    }

    public static void printLottoPapers(List<List<Integer>> lottos) {
        for (List<Integer> paper : lottos) {
            System.out.println(paper);
        }
    }
}
