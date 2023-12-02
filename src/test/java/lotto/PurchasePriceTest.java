package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceTest {
    @DisplayName("구입 금액을 생성한다.")
    @Test
    public void createPurchasePrice() {
        int price = 8000;
        PurchasePrice purchasePrice = new PurchasePrice(price);

        assertThat(purchasePrice.getPrice()).isEqualTo(price);
    }

    @DisplayName("구입 금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    public void purchasePriceUnder1000() {
        assertThatThrownBy(
                () -> {
                    int price = 800;
                    PurchasePrice purchasePrice = new PurchasePrice(price);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    public void purchasePriceUnit() {
        assertThatThrownBy(
                () -> {
                    int price = 3200;
                    PurchasePrice purchasePrice = new PurchasePrice(price);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 로또 수량을 생성한다.")
    @Test
    public void createPurchaseAmount() {
        PurchasePrice purchasePrice = new PurchasePrice(8000);

        assertThat(purchasePrice.getPurchaseCount()).isEqualTo(8);
    }

    @DisplayName("수익률을 생성한다.")
    @Test
    public void createProfit(){
        PurchasePrice purchasePrice = new PurchasePrice(8000);
        double profit = purchasePrice.getRateOfReturn(8000);

        String profitFormat = String.format("%.1f", profit);
        assertThat(profitFormat).isEqualTo("100.0");
    }
}
