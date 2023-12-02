package lotto;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    public static void printResult(PurchasePrice purchasePrice, int earnMoney, Map<Rank, Integer> scoreTable) {
        System.out.println("당첨 통계");
        System.out.println("---");
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println(
                "3개 일치 (" + df.format(Rank.RANK_5.getPrice()) + "원) - " + scoreTable.getOrDefault(Rank.RANK_5, 0) + "개");
        System.out.println(
                "4개 일치 (" + df.format(Rank.RANK_4.getPrice()) + "원) - " + scoreTable.getOrDefault(Rank.RANK_4, 0) + "개");
        System.out.println(
                "5개 일치 (" + df.format(Rank.RANK_3.getPrice()) + "원) - " + scoreTable.getOrDefault(Rank.RANK_3, 0) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (" + df.format(Rank.RANK_2.getPrice()) + "원) - " + scoreTable.getOrDefault(Rank.RANK_2, 0) + "개");
        System.out.println(
                "6개 일치 (" + df.format(Rank.RANK_1.getPrice()) + "원) - " + scoreTable.getOrDefault(Rank.RANK_1, 0) + "개");
        printRateOfReturn(purchasePrice, earnMoney);
    }

    private static void printRateOfReturn(PurchasePrice purchasePrice, int earnMoney) {
        double profit = purchasePrice.getRateOfReturn(earnMoney);
        String profitFormat = String.format("%.1f", profit);
        System.out.println("총 수익률은 " + profitFormat + "%입니다.");
    }
}
