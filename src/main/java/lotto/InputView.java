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

    public static int inputToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }

    public static WinningNumber inputWinningNumberAndBonusNumber() {
        try {
            List<LottoNumber> winningNumbers = inputWinningNumber();
            LottoNumber bonusNumber = inputBonusNumber();
            WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputWinningNumberAndBonusNumber();
        }
    }

    public static List<LottoNumber> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String inputSplit : input.split(",")) {
            LottoNumber winningNumber = new LottoNumber(inputToNumber(inputSplit));
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

    public static LottoNumber inputBonusNumber() {
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
}
