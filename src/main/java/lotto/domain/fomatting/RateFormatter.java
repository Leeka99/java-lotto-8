package lotto.domain.fomatting;

public class RateFormatter {

    private static String rate;

    public RateFormatter(double rate) {
        parseToLetter(rate);
    }

    private void parseToLetter(double rate) {
        RateFormatter.rate = String.format("%,.1f", rate);
    }

    public static String getRate() {
        return rate;
    }
}
