package lotto;

import java.util.List;
import java.util.Map;

public class LottoResult {

    private final float yield;
    private int totalPrice;
    private Map<Integer, Integer> winningDetails = Map.of(
            5000, 0
            ,50000, 0
            ,1500000, 0
            ,30000000, 0
            ,2000000000, 0
    );

    public float getYield() {
        return yield;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public Map<Integer, Integer> getWinningDetails() {
        return winningDetails;
    }


    public LottoResult(List<Integer> prices) {
        int purchasePrice = prices.size() * 1000;
        prices.forEach(price -> {
            totalPrice += price;
            winningDetails.merge(price, 1, Integer::sum);
        });
        this.yield = (float) totalPrice / purchasePrice;
    }

}
