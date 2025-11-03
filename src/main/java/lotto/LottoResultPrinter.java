package lotto;

import java.util.Map;
import java.util.Set;

public class LottoResultPrinter {

    private static final Map<Integer, String> message = Map.of(
            5000, "3개 일치"
            ,50000, "4개 일치"
            ,1500000, "5개 일치"
            ,30000000,"5개 일치, 보너스 볼 일치"
            ,2000000000, "6개 일치"
    );

    public static void print(LottoResult result) {

        double yield = result.getYield();
        Map<Integer,Integer> details = result.getWinningDetails();

        System.out.println("\n당첨 통계");
        System.out.println("---");
        Set<Integer> keys = details.keySet();

        details.forEach((price,num)-> System.out.printf("%s (%,d원) - %d개%n", message.get(price), price, num));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
