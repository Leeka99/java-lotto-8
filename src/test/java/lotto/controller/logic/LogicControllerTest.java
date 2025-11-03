package lotto.controller.logic;

import java.util.List;
import lotto.domain.caculate.CalculateLottoResult;
import lotto.domain.caculate.CalculateRate;
import lotto.domain.caculate.CalculateTotalPrize;
import lotto.domain.fomatting.RateFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LogicControllerTest {

    @DisplayName("도메인 전체 로직 테스트")
    @Test
    void safeValueLogicTest() {

        // given
        new LogicController(3000, List.of(1,2,3,4,5,6),
            List.of(
                List.of(1,3,5,7,9,11),
                List.of(11,24,27,34,40,43),
                List.of(2,5,8,25,32,34)
            ), 7);

        // when
        List<Integer> lottoResult = CalculateLottoResult.getLottoResult();
        double prize = CalculateTotalPrize.getTotalPrize();
        double rate = CalculateRate.getRate();
        String fomattedRate= RateFormatter.getRate();

        // then
        Assertions.assertThat(lottoResult).isEqualTo(List.of(1,0,0,0,0));
        Assertions.assertThat(prize).isEqualTo(5000.0);
        Assertions.assertThat(rate).isEqualTo(166.66666666666669);
        Assertions.assertThat(fomattedRate).isEqualTo("166.7");
    }
}