package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

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
