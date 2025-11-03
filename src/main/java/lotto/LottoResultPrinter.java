package lotto;

import java.util.Map;


public class LottoResultPrinter {

    private static final Map<Integer, String> message = Map.of(
            LottoPrize.FIFTH, "3개 일치"
            ,LottoPrize.FOURTH, "4개 일치"
            ,LottoPrize.THIRD, "5개 일치"
            ,LottoPrize.SECOND,"5개 일치, 보너스 볼 일치"
            ,LottoPrize.FIRST, "6개 일치"
    );

    public static void print(LottoResult result) {

        double yield = result.getYield();
        Map<Integer,Integer> details = result.getWinningDetails();

        System.out.println("\n당첨 통계");
        System.out.println("---");

        details.forEach((price,num)-> System.out.printf("%s (%,d원) - %d개%n", message.get(price), price, num));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
