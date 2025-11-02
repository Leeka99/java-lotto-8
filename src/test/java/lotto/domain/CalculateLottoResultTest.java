package lotto.domain;

import java.util.List;
import lotto.domain.caculate.CalculateLottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateLottoResultTest {

    @BeforeEach
    void reset() {
        CalculateLottoResult.reset();
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

        new CalculateLottoResult(myLotto, winningNumbers, bonus);

        // when
        int correctThree = CalculateLottoResult.getLottoResult().getFirst();

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

        new CalculateLottoResult(myLotto, winningNumbers, bonus);

        // when
        int correctFour = CalculateLottoResult.getLottoResult().get(1);

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

        new CalculateLottoResult(myLotto, winningNumbers, bonus);

        // when
        int correctFive = CalculateLottoResult.getLottoResult().get(2);

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

        new CalculateLottoResult(myLotto, winningNumbers, bonus);

        // when
        int correctFiveWithBonus = CalculateLottoResult.getLottoResult().get(3);

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

        new CalculateLottoResult(myLotto, winningNumbers, bonus);

        // when
        int correctSix = CalculateLottoResult.getLottoResult().get(4);

        // then
        Assertions.assertThat(correctSix).isEqualTo(1);
    }
}