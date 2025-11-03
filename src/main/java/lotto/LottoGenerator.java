package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateList(int n) {
        System.out.printf("%d개를 구매했습니다.\n", n);
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < n; i++) lottoList.add(generate());
        return lottoList;
    }
    public static Lotto generate() {
        List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(1,45,6);
        printNums(randomNums);
        return new Lotto(randomNums);
    }

    private static void printNums(List<Integer> nums) {
        String output = String.format("[%d, %d, %d, %d, %d, %d]",nums.toArray());
        System.out.println(output);
    }

}
