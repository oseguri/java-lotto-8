package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    private static final String PRICE_MESSAGE= "구입금액을 입력해 주세요.";
    private static final String WIN_NUM_MESSAGE= "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUM_MESSAGE= "보너스 번호를 입력해 주세요.";


    private static String getInput(String message) {
        System.out.println("\n" + message);
        return Console.readLine();
    }

    public static int getPrice() {
        try {
            String input = getInput(PRICE_MESSAGE);
            InputValidator.validatePrice(input);
            return Integer.parseInt(input);
        }catch(IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return getPrice();
        }
    }

    public static List<Integer> getWinNumbers() {
        try {
            String input = getInput(WIN_NUM_MESSAGE);
            InputValidator.validateWinNum(input);
            return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        }catch(IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return getWinNumbers();
        }
    }

    public static int getBonusNumber(List<Integer> winNums) {
        try {
            String input = getInput(BONUS_NUM_MESSAGE);
            InputValidator.validateBonus(input,winNums);
            return Integer.parseInt(input);
        }catch(IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return getBonusNumber(winNums);
        }
    }

}
