package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    //구입 금액
    private static final String INT_ERR = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String ZERO_ERR = "[ERROR] 구입 금액은 1000원 이상이여야 합니다.";
    private static final String MUL1000_ERR = "[ERROR] 구입 금액 1000의 배수여야 합니다.";
    // 당첨 번호
    private static final String WIN_REG = "(?:(\\d+),){5}(\\d+)";
    private static final String WIN_RANGE_ERR = "[ERROR] 당첨 번호는 1~45 사이 정수여야 합니다.";
    private static final String WIN_FORM_ERR = "[ERROR] 당첨 번호는 6개, n1,n2,n3,n4,n5,n6 와 같은 형식이여야합니다.";
    private static final String WIN_DUPLICATE_ERR = "[ERROR] 당첨 번호는 중복되지 않는 숫자여야 합니다.";
    // 보너스 번호
    private static final String BONUS_NUM_INT_ERR = "[ERROR] 보너스 번호는 정수여야 합니다.";
    private static final String BONUS_NUM_RANGE_ERR = "[ERROR] 보너스 번호는 1~45사이여야 합니다.";
    private static final String BONUS_DUPLICATE_ERR = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";
    
    private static void isNumInRange(String value, int min, int max, String message) {
        int num = Integer.parseInt(value);
        if(!(min <= num && num <= max)) throw new IllegalArgumentException(message);
    }

    private static void isInteger(String value, String message) {
        try{
            Integer.parseInt(value);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }


    public static void validatePrice(String value) {
        isInteger(value, INT_ERR);
        int num = Integer.parseInt(value);
        isNotZero(num);
        isMultipleOf1000(num);
    }
    public static void isMultipleOf1000(int value) {
        if(value%1000 != 0) throw new IllegalArgumentException(MUL1000_ERR);
    }
    public static void isNotZero(int value) {
        if(value == 0) throw new IllegalArgumentException(ZERO_ERR);
    }


    public static void isValidWinNum(String value) {
        isValidWinNumForm(value);
        isWinNumValidRange(value);
        isWinNumNotDuplicate(value);
    }

    private static void isValidWinNumForm(String value) {
        Matcher matcher = Pattern.compile(WIN_REG).matcher(value);
        if(!matcher.matches()) throw new IllegalArgumentException(WIN_FORM_ERR);
    }

    private static void isWinNumValidRange(String value) {
        List<String> numsString = List.of(value.split(","));
        numsString.forEach(num -> isNumInRange(num,1,45,WIN_RANGE_ERR));
    }

    private static void isWinNumNotDuplicate(String value) {
        List<String> numsString = List.of(value.split(","));
        List<String> distinctList = numsString.stream().distinct().toList();
        if(numsString.size() != distinctList.size()) throw new IllegalArgumentException(WIN_DUPLICATE_ERR);
    }


    public static void isBonusValid(String value) {
        isInteger(value, BONUS_NUM_INT_ERR);
        isNumInRange(value, 1, 45, BONUS_NUM_RANGE_ERR);
    }

    private static void isNotDupBonus(List<String> winNums, String value) {
        if(winNums.contains(value)) throw new IllegalArgumentException(BONUS_DUPLICATE_ERR);
    }

}
