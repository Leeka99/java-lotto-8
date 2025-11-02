package lotto.domain.fomatting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateFormatterTest {

    @DisplayName("수익률에 대해서 소수점 둘째 자리 반올림하는지 테스트한다.")
    @Test
    void rateTest() {

        // given
        new RateFormatter(166.66666666666669);

        // when
        String rate = RateFormatter.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo("166.7");
    }

    @DisplayName("수익률 0에 대해서 테스트한다.")
    @Test
    void rateZeroTest() {

        // given
        new RateFormatter(0.0);

        // when
        String rate = RateFormatter.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo("0.0");
    }

    @DisplayName("매우 큰 수익률에 대해서 소수점 둘째 자리 반올림하는지 테스트한다.")
    @Test
    void rateBigNumberTest() {

        // given
        new RateFormatter(40321234456.26245);

        // when
        String rate = RateFormatter.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo("40,321,234,456.3");
    }

    @DisplayName("수익률에 대해서 원단위에 맞게 변환되는지 테스트한다.")
    @Test
    void parseRate() {

        // given
        new RateFormatter(2750.0);

        // when
        String rate = RateFormatter.getRate();

        // then
        Assertions.assertThat(rate).isEqualTo("2,750.0");
    }
}