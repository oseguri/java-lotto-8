package lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    //구입 금액
    private static final String INT_ERR_MSG = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String ZERO_ERR_MSG = "[ERROR] 구입 금액은 1000원 이상이여야 합니다.";
    private static final String MUL1000_ERR_MSG = "[ERROR] 구입 금액 1000의 배수여야 합니다.";
    // 당첨 번호
    private static final String WIN_REG = "(?:(\\d+),){5}(\\d+)";
    private static final String WIN_RANGE_ERR_MSG = "[ERROR] 당첨 번호는 1~45 사이 정수여야 합니다.";
    private static final String WIN_FORM_ERR_MSG = "[ERROR] 당첨 번호는 6개, n1,n2,n3,n4,n5,n6 와 같은 형식이여야합니다.";
    // 보너스 번호
    private static final String BONUS_NUM_INT_ERR = "[ERROR] 보너스 번호는 정수여야 합니다.";
    private static final String BONUS_NUM_RANGE_ERR = "[ERROR] 보너스 번호는 1~45사이여야 합니다.";

    public static void isNumInRange(String value, int min, int max, String message) {
        int num = Integer.parseInt(value);
        if(!(min <= num && num <= max)) throw new IllegalArgumentException(message);
    }

    public static void isInteger(String value, String message) {
        try{
            Integer.parseInt(value);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }


    public static void validatePrice(String value) {
        isInteger(value, INT_ERR_MSG);
        int num = Integer.parseInt(value);
        isNotZero(num);
        isMultipleOf1000(num);
    }
    public static void isMultipleOf1000(int value) {
        if(value%1000 != 0) throw new IllegalArgumentException(MUL1000_ERR_MSG);
    }
    public static void isNotZero(int value) {
        if(value == 0) throw new IllegalArgumentException(ZERO_ERR_MSG);
    }


    public static void isValidWinNum(String value) {
        isValidWinNumForm(value);
        isWinNumValidRange(value);
    }

    public static void isValidWinNumForm(String value) {
        Matcher matcher = Pattern.compile(WIN_REG).matcher(value);
        if(!matcher.matches()) throw new IllegalArgumentException(WIN_FORM_ERR_MSG);
    }

    public static void isWinNumValidRange(String value) {
        List<String> numsString = List.of(value.split(","));
        numsString.forEach(num -> isNumInRange(num,1,45,WIN_RANGE_ERR_MSG));
    }



    public static void isBonusValid(String value) {
        isInteger(value, BONUS_NUM_INT_ERR);
        isNumInRange(value, 1, 45, BONUS_NUM_RANGE_ERR);
    }

}
