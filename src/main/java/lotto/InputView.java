package lotto;

import camp.nextstep.edu.missionutils.Console;

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
}
