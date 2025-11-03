package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoCalculatorTest {

    @Test
    @DisplayName("로또 결과 계산 테스트")
    void calculateTest() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottoList.add(new Lotto(List.of(1,2,3,4,5,45)));
        lottoList.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottoList.add(new Lotto(List.of(1,2,3,4,7,8)));
        lottoList.add(new Lotto(List.of(1,2,3,7,8,9)));
        lottoList.add(new Lotto(List.of(1,2,7,8,9,10)));
        lottoList.add(new Lotto(List.of(1,7,8,9,10,11)));
        lottoList.add(new Lotto(List.of(7,8,9,10,11,12)));

        List<Integer> prices = List.of(2000000000, 30000000, 1500000, 50000, 5000,0,0,0);

        assertThat(new LottoResult(prices))
                .usingRecursiveComparison()
                .isEqualTo(LottoCalculator.getResult(lottoList, List.of(1,2,3,4,5,6), 45));

    }
}
