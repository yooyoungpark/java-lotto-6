package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<LottoNumber> numbers = lotto.getNumbers();
            List<Integer> lottoNumbersValue = new ArrayList<>();
            for (LottoNumber number : numbers) {
                int num = number.getNumber();
                lottoNumbersValue.add(num);
            }
            Collections.sort(lottoNumbersValue);
            System.out.println(lottoNumbersValue);
        }
    }
}
