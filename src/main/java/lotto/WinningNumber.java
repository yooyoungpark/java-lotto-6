package lotto;

import static lotto.Application.LOTTO_NUMBER_DIGIT;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        checkDuplicated(winningNumbers, bonusNumber);
        if (winningNumbers.size() != LOTTO_NUMBER_DIGIT) {
            throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_DIGIT + "개여야 합니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void checkDuplicated(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 중복되지 않는 보너스 번호를 입력해 주세요.");
        }
        for (int i = 0; i < winningNumbers.size(); i++) {
            for (int j = i + 1; j < winningNumbers.size(); j++) {
                if (winningNumbers.get(i).equals(winningNumbers.get(j))) {
                    throw new IllegalArgumentException("중복 되지 않는 수를 입력해 주세요.");
                }
            }
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbersValue() {
        List<Integer> values = new ArrayList<>();
        for (LottoNumber lottoNumber : winningNumbers){
            int number = lottoNumber.getNumber();
            values.add(number);
        }
        return values;
    }

    public int getBonusNumberValue(){
        return bonusNumber.getNumber();
    }
}
