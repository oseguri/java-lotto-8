package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {":false"," :false","0:false","999:false","1024:false","3000:true","10000:true"}, delimiter =':')
    @DisplayName("구매가격 입력 검증 테스트")
    void priceValidationTest(String price, String set) {
        if(set.equals("false")) {
            assertThatThrownBy(() -> InputValidator.validatePrice(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }else if(set.equals("true")) {
            assertThatCode(() -> InputValidator.validatePrice(price))
                    .doesNotThrowAnyException();
        }


    }

    @ParameterizedTest
    @CsvSource(value = {":false"," :false", "1,2,3,4,2,3:false", "1,2,3:false", "a,b,c,d,e,f:false", "1|2|3|4|5|6:false","1234:false","1,2,3,4,5,6:true","1,15,17,19,40,45:true"}, delimiter = ':')
    @DisplayName("우승번호 입력 검증 테스트")
    void winNumberValidationTest(String input, String set) {
        if(set.equals("false")) {
            assertThatThrownBy(() -> InputValidator.validateWinNum(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }else if(set.equals("true")) {
            assertThatCode(() -> InputValidator.validateWinNum(input))
                    .doesNotThrowAnyException();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {":false","a:false","46:false","0:false", "3:false", "7:true", "45:true"}, delimiter = ':')
    @DisplayName("보너스 번호 입력 검증 테스트")
    void bonusNumberValidationTest(String input, String set) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        if(set.equals("false")) {
            assertThatThrownBy(() -> InputValidator.validateBonus(input, nums))
                    .isInstanceOf(IllegalArgumentException.class);
        }else if(set.equals("true")) {
            assertThatCode(() -> InputValidator.validateBonus(input, nums))
                    .doesNotThrowAnyException();
        }

    }
}
