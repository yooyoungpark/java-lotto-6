package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static PurchasePrice inputPurchasePrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            return new PurchasePrice(inputToNumber(input));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputPurchasePrice();
        }
    }

    public static WinningNumber inputWinningNumberAndBonusNumber() {
        try {
            List<LottoNumber> winningNumbers = inputWinningNumber();
            LottoNumber bonusNumber = inputBonusNumber();
            return new WinningNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputWinningNumberAndBonusNumber();
        }
    }

    private static List<LottoNumber> inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String inputSplit : input.split(",")) {
            LottoNumber lottoNumber = new LottoNumber(inputToNumber(inputSplit));
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private static LottoNumber inputBonusNumber() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            LottoNumber bonusNumber = new LottoNumber(inputToNumber(input));
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static int inputToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }
}
