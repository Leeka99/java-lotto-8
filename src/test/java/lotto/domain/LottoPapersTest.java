package lotto.domain;

import java.util.List;
import lotto.util.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPapersTest {

    @DisplayName("금액에 대해서 0을 입력하면 예외가 발생한다.")
    @Test
    void inputZeroTest() {
        Assertions.assertThatThrownBy(() -> new LottoPapers(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 대해서 1000원 단위 이외 입력하면 예외가 발생한다.")
    @Test
    void inputRemainderZeroTest() {
        Assertions.assertThatThrownBy(() -> new LottoPapers(8800))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 대해서 몇개의 로또용지가 반환되는지 테스트한다.")
    @Test
    void lottoPaperNumberTest() {

        // given
        new LottoPapers(8000);

        // when
        int paperNumber = LottoPapers.getPaperNumber();

        // then
        Assertions.assertThat(paperNumber).isEqualTo(8);
    }

    @DisplayName("금액에 대해서 장 수 만큼 로또를 생성했는지 테스트한다.")
    @Test
    void lottoGenerateLengthTest() {

        // given
        new LottoPapers(10000);

        // when
        int length = LottoPapers.getLottos().size();

        // then
        Assertions.assertThat(length).isEqualTo(10);
    }

    @DisplayName("생성된 각각의 로또용지 마다 번호 개수가 6개인지 확인한다.")
    @Test
    void checkLottoNumberLength() {

        // given
        new LottoPapers(3000);

        // when
        int lottoNumberLength1 = LottoPapers.getLottos().get(0).size();
        int lottoNumberLength2 = LottoPapers.getLottos().get(1).size();
        int lottoNumberLength3 = LottoPapers.getLottos().get(2).size();

        // then
        Assertions.assertThat(lottoNumberLength1).isEqualTo(6);
        Assertions.assertThat(lottoNumberLength2).isEqualTo(6);
        Assertions.assertThat(lottoNumberLength3).isEqualTo(6);
    }

    @DisplayName("생성된 로또번호로 오름차순 정렬 동작이 작동하는지 테스트한다.")
    @Test
    void lottoNumberSortTest() {

        // given
        LottoGenerator lottoGenerator = () -> List.of(6,5,4,3,2,1);
        new LottoPapers(1000, lottoGenerator);

        // when
        List<Integer> lottoNumbers = LottoPapers.getLottos().getFirst();

        // then
        Assertions.assertThat(lottoNumbers).isEqualTo(List.of(1,2,3,4,5,6));

    }

}