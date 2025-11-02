package lotto.domain.caculate;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateTotalPrizeTest {

    @BeforeEach
    void reset() {
        CalculateTotalPrize.reset();
    }

    @DisplayName("총 당첨금을 올바르게 계산하는지 테스트한다.")
    @Test
    void totalPrizeTest() {

        // given
        new CalculateTotalPrize(List.of(1, 0, 1, 0, 0));

        // when
        double totalPrize = CalculateTotalPrize.getTotalPrize();

        // then
        Assertions.assertThat(totalPrize).isEqualTo(1505000.0);
    }

    @DisplayName("당첨되지 않았을 경우 0원을 저장하는지 테스트한다.")
    @Test
    void noPrizeTest() {
        // given
        new CalculateTotalPrize(List.of(0, 0, 0, 0, 0));

        // when
        double totalPrize = CalculateTotalPrize.getTotalPrize();

        // then
        Assertions.assertThat(totalPrize).isEqualTo(0.0);
    }

    @DisplayName("총 당첨금이 매우 큰값일 경우 올바르게 계산하는지 테스트한다.")
    @Test
    void bigPrizeTest() {

        // given
        new CalculateTotalPrize(List.of(0, 0, 0, 0, 10));

        // when
        double totalPrize = CalculateTotalPrize.getTotalPrize();

        // then
        Assertions.assertThat(totalPrize).isEqualTo(20000000000.0);
    }

    @DisplayName("총 당첨금이 정말 큰값일 경우 올바르게 계산하는지 테스트한다.")
    @Test
    void veryBigPrizeTest() {

        // given
        new CalculateTotalPrize(List.of(0, 0, 0, 0, 1000));

        // when
        double totalPrize = CalculateTotalPrize.getTotalPrize();

        // then
        Assertions.assertThat(totalPrize).isEqualTo(2000000000000.0);
    }
}