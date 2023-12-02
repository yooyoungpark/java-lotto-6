package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_DIGIT = 6;

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        int purchaseCount = purchasePrice.getPurchaseCount();
        OutputView.printPurchaseCount(purchaseCount);

        List<Lotto> lottos = issueLotto(purchaseCount);
        OutputView.printPurchaseLotto(lottos);

        WinningNumber winningNumber = InputView.inputWinningNumberAndBonusNumber();
        Map<Rank, Integer> scoreTable = new HashMap<>();
        int earnMoney = calculateMoney(lottos, winningNumber, scoreTable);
        OutputView.printResult(purchasePrice, earnMoney, scoreTable);
    }

    private static List<Lotto> issueLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = purchaseLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto purchaseLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                LOTTO_NUMBER_DIGIT);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int randomNumber : randomNumbers) {
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            lottoNumbers.add(lottoNumber);
        }
        return new Lotto(lottoNumbers);
    }

    public static int calculateMoney(List<Lotto> lottos, WinningNumber winningNumber, Map<Rank, Integer> scoreTable) {
        //당첨 금액이 얼만지
        int earnMoney = 0;
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(winningNumber, lotto);
            int currentCount = scoreTable.getOrDefault(rank, 0);
            scoreTable.put(rank, currentCount + 1);
            earnMoney += rank.getPrice();
        }
        return earnMoney;
    }

    private static Rank calculateRank(WinningNumber winningNumber, Lotto lotto) {
        //calculateRank : 몇개 같은지, 보너스 번호가 있는지
        List<Integer> lottoNumbers = lotto.getNumbersValue();
        List<Integer> winningNumbers = winningNumber.getWinningNumbersValue();
        int bonusNumber = winningNumber.getBonusNumberValue();

        int sameCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                sameCount++;
            }
        }
        boolean hasBonus = lottoNumbers.contains(bonusNumber);
        return Rank.rankFind(sameCount, hasBonus);
    }
}
