package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    public static final int LOTTO_NUMBER_DIGIT = 6;

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        int purchaseCount = purchasePrice.getPurchaseCount();
        OutputView.printPurchaseCount(purchaseCount);

        List<Lotto> lottos = issueLotto(purchaseCount);
        OutputView.printPurchaseLotto(lottos);
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
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX, LOTTO_NUMBER_DIGIT);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer randomNumber : randomNumbers) {
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            lottoNumbers.add(lottoNumber);
        }
        return new Lotto(lottoNumbers);
    }
}
