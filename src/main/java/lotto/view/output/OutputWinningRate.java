package lotto.view.output;

public class OutputWinningRate {

    public static void printRate(double rate) {

        System.out.println("총 수익률은 " + String.format("%,.1f", rate) + "%입니다.");
    }

}
