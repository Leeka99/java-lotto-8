package lotto.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputWinningNumberTest {

    @DisplayName("공백 입력 시 예외가 발생한다.")
    @Test
    void inputBlankTest() {
        Assertions.assertThatThrownBy(() -> new InputWinningNumber(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수 입럭 시 예외가 발생한다.")
    @Test
    void inputMinusTest() {
        Assertions.assertThatThrownBy(() -> new InputWinningNumber("-1,1,2,3,4,5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소수점을 포함한 숫자 입력시 예외가 발생한다.")
    @Test
    void inputDecimalNumberTest() {
        Assertions.assertThatThrownBy(() -> new InputWinningNumber("3.5,1,2,3,4,5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("(,) 쉼표와 숫자 이외 입력시 예외가 발생한다.")
    @Test
    void inputCommaTest() {
        Assertions.assertThatThrownBy(() -> new InputWinningNumber("1-2-3-4-5-6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자 입력 시 예외가 발생한다.")
    @Test
    void inputLetterTest() {
        Assertions.assertThatThrownBy(() -> new InputWinningNumber("one,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}