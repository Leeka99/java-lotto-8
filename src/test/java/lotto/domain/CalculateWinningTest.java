package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateWinningTest {

    @BeforeEach
    void reset() {
        CalculateWinning.reset();
    }

    @DisplayName("3개 일치 후 값이 올바르게 저장되는지 테스트한다.")
    @Test
    void correctThreeTest() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(1, 3, 5, 7, 34, 11),
            List.of(11, 22, 33, 44, 12, 23)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 34, 44, 45);
        int bonus = 10;
        int money = 3000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        int correctThree = CalculateWinning.getLottoResult().getFirst();

        // then
        Assertions.assertThat(correctThree).isEqualTo(2);
    }

    @DisplayName("4개 일치 후 값이 올바르게 저장되는지 테스트한다.")
    @Test
    void correctFourTest() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(10, 21, 33, 34, 35, 45),
            List.of(11, 13, 25, 27, 34, 40),
            List.of(9, 10, 12, 13, 15, 20)
        );
        List<Integer> winningNumbers = List.of(10, 21, 33, 34, 41, 44);
        int bonus = 13;
        int money = 3000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        int correctFour = CalculateWinning.getLottoResult().get(1);

        // then
        Assertions.assertThat(correctFour).isEqualTo(1);
    }


    @DisplayName("5개 일치 후 값이 올바르게 저장되는지 테스트한다.")
    @Test
    void correctFiveTest() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(10, 21, 33, 34, 35, 45),
            List.of(19, 20, 21, 33, 35, 40),
            List.of(19, 20, 21, 40, 41, 43)
        );
        List<Integer> winningNumbers = List.of(19, 20, 21, 33, 35, 44);
        int bonus = 2;
        int money = 3000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        int correctFive = CalculateWinning.getLottoResult().get(2);

        // then
        Assertions.assertThat(correctFive).isEqualTo(1);
    }

    @DisplayName("5개 일치, 보너스 볼 일치 후 값이 올바르게 저장되는지 테스트한다.")
    @Test
    void correctFiveWithBonusTest() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(1, 9, 13, 22, 27, 30),
            List.of(11, 22, 33, 35, 40, 45),
            List.of(1, 11, 23, 40, 41, 43)
        );
        List<Integer> winningNumbers = List.of(11, 22, 33, 34, 35, 45);
        int bonus = 40;
        int money = 3000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        int correctFiveWithBonus = CalculateWinning.getLottoResult().get(3);

        // then
        Assertions.assertThat(correctFiveWithBonus).isEqualTo(1);
    }

    @DisplayName("6개 일치 후 값이 올바르게 저장되는지 테스트한다.")
    @Test
    void correctSixTest() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(7, 9, 11, 23, 27, 29),
            List.of(1, 22, 31, 39, 41, 43),
            List.of(1, 16, 22, 30, 37, 44)
        );
        List<Integer> winningNumbers = List.of(7, 9, 11, 23, 27, 29);
        int bonus = 23;
        int money = 3000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        int correctSix = CalculateWinning.getLottoResult().get(4);

        // then
        Assertions.assertThat(correctSix).isEqualTo(1);
    }

    @DisplayName("수익률이 올바르게 계산되는지 테스트한다.")
    @Test
    void rateTest() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(3, 8, 10, 32, 42, 45),
            List.of(8, 13, 29, 37, 42, 43),
            List.of(4, 8, 13, 17, 37, 41),
            List.of(1, 27, 29, 31, 38, 43)
        );
        List<Integer> winningNumbers = List.of(1, 3, 8, 10, 13, 29);
        int bonus = 2;
        int money = 4000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        double rate = CalculateWinning.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo(250.0);
    }

    @DisplayName("원 단위에 맞게 변환되는지 테스트한다.")
    @Test
    void parsePrizeValue() {

        // given
        new CalculateWinning();

        // when
        List<String> prize = CalculateWinning.getPrizeResult();

        // then
        Assertions.assertThat(prize)
            .isEqualTo(List.of("5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000"));
    }

    @DisplayName("수익률을 소수점 둘째 자리 반올림과 원 단위에 맞게 변환되는지 테스트한다.")
    @Test
    void parseRate() {

        // given
        List<List<Integer>> myLotto = List.of(
            List.of(1, 3, 8, 19, 25, 40),
            List.of(8, 10, 19, 23, 44, 45)
        );
        List<Integer> winningNumbers = List.of(8, 19, 21, 23, 40, 44);
        int bonus = 43;
        int money = 2000;

        new CalculateWinning(myLotto, winningNumbers, bonus, money);

        // when
        String rate = CalculateWinning.getRateLetter();

        // then
        Assertions.assertThat(rate).isEqualTo("2,750.0");
    }
}