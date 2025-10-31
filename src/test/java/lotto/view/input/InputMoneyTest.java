package lotto.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputMoneyTest {
    @DisplayName("금액에 대해서 공백을 입력하면 예외가 발생한다.")
    @Test
    void inputBlankTest() {
        Assertions.assertThatThrownBy(() -> new InputMoney(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 대해서 음수를 입력하면 예외가 발생한다.")
    @Test
    void inputMinusTest() {
        Assertions.assertThatThrownBy(() -> new InputMoney("-3000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 대해서 소수점을 포함한 숫자 입력시 예외가 발생한다.")
    @Test
    void inputDecimalNumberTest() {
        Assertions.assertThatThrownBy(() -> new InputMoney("5000.5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 대해서 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @Test
    void inputLetterTest() {
        Assertions.assertThatThrownBy(() -> new InputMoney("threeThousand"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}