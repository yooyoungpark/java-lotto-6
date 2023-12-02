package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 번호를 생성한다.")
    @Test
    public void createNumber() {
        int number = 1;
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("각 번호가 1~45사이가 아니면 예외가 발생한다.")
    @Test
    public void rangeNumber() {
        assertThatThrownBy(
                () -> {
                    int number = 47;
                    new LottoNumber(number);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
