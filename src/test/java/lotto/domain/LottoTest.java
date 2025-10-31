package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 0이 있으면 예외가 발생한다.")
    @Test
    void inputZeroTest() {
        assertThatThrownBy(() -> new Lotto(List.of(0,1,2,3,4,5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개 미만이면 예외가 발생한다.")
    @Test
    void lottoLengthUnderSixTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 이외 숫자를 입력하면 예외가 발생한다.")
    @Test
    void notLottoNumberTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,67)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
