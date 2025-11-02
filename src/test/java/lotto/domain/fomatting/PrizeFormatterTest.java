package lotto.domain.fomatting;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeFormatterTest {

    @DisplayName("원 단위에 맞게 변환되는지 테스트한다.")
    @Test
    void parsePrizeValue() {

        // given
        new PrizeFormatter();

        // when
        List<String> prize = PrizeFormatter.getPrize();

        // then
        Assertions.assertThat(prize)
            .isEqualTo(List.of("5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000"));
    }
}