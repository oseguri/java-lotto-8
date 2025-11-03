package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoCalculator {
    private final static Map<Integer, Integer> winnerPrice = Map.of(
            6,2000000000
            ,5,1500000
            ,4,50000
            ,3,5000);

    public static LottoResult getResult(List<Lotto> lottoList, List<Integer> winNums, int bonusNum) {
        List<Integer> prices = new ArrayList<>();
        lottoList.forEach((lotto) -> prices.add(calculate(lotto,winNums,bonusNum)));

        return new LottoResult(prices);
    }

    private static int calculate(Lotto lotto, List<Integer> winNums, int bonusNum) {
        List<Integer> lottoNums = lotto.getNumbers();

        AtomicInteger correct = new AtomicInteger();
        winNums.forEach(num -> {
            if(lottoNums.contains(num)) correct.getAndIncrement();
        });

        int correctNum = correct.get();
        if(!winnerPrice.containsKey(correctNum)) return 0;

        int price = winnerPrice.get(correctNum);
        if(correctNum == 5 && lottoNums.contains(bonusNum)) price *= 20;
        return price;
    }
}
