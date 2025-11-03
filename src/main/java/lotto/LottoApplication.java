package lotto;

import java.util.List;

public class LottoApplication {
    private final List<Integer> winNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottoList;

    public LottoApplication() {
        int price = InputManager.getPrice();
        this.lottoList = LottoGenerator.generateList(price /1000);
        this.winNumbers = InputManager.getWinNumbers();
        this.bonusNumber = InputManager.getBonusNumber(winNumbers);
    }


    public void start() {
        LottoResult result = LottoCalculator.getResult(lottoList, winNumbers, bonusNumber);
        LottoResultPrinter.print(result);
    }

}
