package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    private static final String PRICE_MESSAGE= "구입금액을 입력해 주세요.";
    private static final String WIN_NUM_MESSAGE= "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUM_MESSAGE= "보너스 번호를 입력해 주세요.";


    private static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static int getPrice() {
        String input = getInput(PRICE_MESSAGE);
        InputValidator.validatePrice(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinNumbers() {
        String input = getInput(WIN_NUM_MESSAGE);
        InputValidator.validateWinNum(input);
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    public static int getBonusNumber(List<Integer> winNums) {
        String input = getInput(BONUS_NUM_MESSAGE);
        InputValidator.validateBonus(input,winNums);
        return Integer.parseInt(input);
    }

}
