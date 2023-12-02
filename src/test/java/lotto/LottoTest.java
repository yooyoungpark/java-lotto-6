package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호를 생성한다.")
    @Test
    public void purchaseNumber() {
        Lotto purchaseNumber = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
        assertThat(purchaseNumber.getNumbersValue()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    public void createLottoByOverSize() {
        assertThatThrownBy(
                () -> {
                    new Lotto(List.of(
                            new LottoNumber(1),
                            new LottoNumber(2),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(6),
                            new LottoNumber(7)
                    ));
                    throw new IllegalArgumentException();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(
                () -> {
                    new Lotto(List.of(
                            new LottoNumber(1),
                            new LottoNumber(2),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(5)
                    ));
                    throw new IllegalArgumentException();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}