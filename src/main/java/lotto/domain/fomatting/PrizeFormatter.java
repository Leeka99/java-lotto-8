package lotto.domain.fomatting;

import java.util.ArrayList;
import java.util.List;
import lotto.util.config.NumberConfig;
import lotto.util.config.Winning;

public class PrizeFormatter {

    private static List<String> prize = new ArrayList<>();

    public PrizeFormatter() {
        saveResult();
    }

    private void saveResult() {
        for (int index = NumberConfig.START_NUMBER.getNumber();
            index < NumberConfig.PRIZE_LENGTH.getNumber(); index++) {
            prize.add(String.format("%,d", Winning.values()[index].getPrize()));
        }
    }

    public static List<String> getPrize() {
        return prize;
    }

}
