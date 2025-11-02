package lotto.domain.caculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateRateTest {

    @DisplayName("수익률이 올바르게 계산되는지 테스트한다.")
    @Test
    void rateTest() {

        // given
        new CalculateRate(3000, 5000.0);

        // when
        double rate = CalculateRate.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo(166.66666666666669);
    }

    @DisplayName("총 상금 0원에 대해서 수익률이 올바르게 계산되는지 테스트한다.")
    @Test
    void totalPrizeZeroTest() {

        // given
        new CalculateRate(3000, 0.0);

        // when
        double rate = CalculateRate.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo(0.0);
    }

    @DisplayName("총 상금이 매우 큰 값에 대해서 수익률이 올바르게 계산되는지 테스트한다.")
    @Test
    void totalPrizeBigNumberTest() {

        // given
        new CalculateRate(3000, 20000000000.0);

        // when
        double rate = CalculateRate.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo(666666666.6666667);
    }
}