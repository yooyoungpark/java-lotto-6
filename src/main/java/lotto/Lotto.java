package lotto;

import static lotto.Application.LOTTO_NUMBER_DIGIT;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("중복 되지 않는 수를 입력해 주세요.");
        }
        if (numbers.size() != LOTTO_NUMBER_DIGIT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_DIGIT + "개여야 합니다.");
        }
    }

    private boolean isDuplicated(List<LottoNumber> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getNumbersValue() {
        List<Integer> values = new ArrayList<>();
        for (LottoNumber lottoNumber : numbers) {
            int number = lottoNumber.getNumber();
            values.add(number);
        }
        return values;
    }
}