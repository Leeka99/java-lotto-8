package lotto.util.config;

public enum Winning {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int winningCount;
    private final int prize;

    Winning(int winningCount, int prize) {
        this.winningCount = winningCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

}
