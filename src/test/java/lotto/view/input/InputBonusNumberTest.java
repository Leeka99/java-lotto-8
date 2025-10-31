package lotto.view.input;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputBonusNumberTest {

    @DisplayName("보너스 번호 입력에 대해서 공백을 입력하면 예외가 발생한다.")
    @Test
    void inputBlankTest() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해서 0을 입력하면 예외가 발생한다.")
    @Test
    void inputZeroTest() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해서 음수를 입력하면 예외가 발생한다.")
    @Test
    void inputMinusTest() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber("-32"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해서 소수점을 포함한 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputDecimalNumberTest() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber("12.5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해서 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @Test
    void inputLetterTest() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber("two"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해서 1 ~ 45 숫자 이외 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputLottoNumberTest() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber("75"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해서 당첨 번호에 포함된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputDuplicationNumber() {
        Assertions.assertThatThrownBy(() -> new InputBonusNumber("5", List.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

}