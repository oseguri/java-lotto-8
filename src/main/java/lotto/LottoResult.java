package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final double yield;
    private final Map<Integer, Integer> winningDetails = new LinkedHashMap<>();

    public double getYield() {
        return yield;
    }
    public Map<Integer, Integer> getWinningDetails() {
        return winningDetails;
    }


    public LottoResult(List<Integer> prices) {
        winningDetails.put(LottoPrize.FIFTH, 0);
        winningDetails.put(LottoPrize.FOURTH, 0);
        winningDetails.put(LottoPrize.THIRD, 0);
        winningDetails.put(LottoPrize.SECOND, 0);
        winningDetails.put(LottoPrize.FIRST, 0);

        int purchasePrice = prices.size() * 1000;
        int totalPrice = 0;

        for(int price : prices) {
            totalPrice += price;
            if(winningDetails.containsKey(price)) winningDetails.put(price, winningDetails.get(price) + 1);
        }
        this.yield = ((double) totalPrice / purchasePrice) * 100;
    }

}
