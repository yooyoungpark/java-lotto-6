package lotto;

import static lotto.Application.LOTTO_PRICE_UNIT;

public class PurchasePrice {
    private int price;

    public PurchasePrice(int price) {
        if (price < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException("구매 금액은 " + LOTTO_PRICE_UNIT + "원 이상을 입력해 주세요.");
        }
        if (price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("구매 금액은 " + LOTTO_PRICE_UNIT + "원 단위로 입력해 주세요.");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
