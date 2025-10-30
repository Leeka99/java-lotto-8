package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
            if (number == 0) {
                throw new IllegalArgumentException("[ERROR] 0 입력 불가. 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
            if (45 < number) {
                throw new IllegalArgumentException("[ERROR] 45 초과 불가. 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
    }
}
