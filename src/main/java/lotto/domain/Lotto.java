package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.config.NumberConfig;
import lotto.util.config.LottoConfig;
import lotto.util.exception.LottoValidationException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_LENGTH.getNumber()) {
            throw new LottoValidationException(LottoValidationException.NOT_SIX);
        }
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) != NumberConfig.EQUAL_VALUE.getNumber()) {
                throw new LottoValidationException(LottoValidationException.DUPLICATE_NUMBERS);
            }
            if (number < LottoConfig.LOTTO_START_NUMBER.getNumber()) {
                throw new LottoValidationException(LottoValidationException.NOT_ZERO);
            }
            if (LottoConfig.LOTTO_END_NUMBER.getNumber() < number) {
                throw new LottoValidationException(LottoValidationException.OVER_LOTTO_NUMBER);
            }
        }
    }
}
