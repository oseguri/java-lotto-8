package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class InputValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {":false"," :false","0:false","999:false","1024:false","3000:true","10000:true"}, delimiter =':')
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
    void winNumberValidationTest(String input, String set) {
        if(set.equals("false")) {
            assertThatThrownBy(() -> InputValidator.isValidWinNum(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }else if(set.equals("true")) {
            assertThatCode(() -> InputValidator.isValidWinNum(input))
                    .doesNotThrowAnyException();
        }
    }
//
//    @ParameterizedTest
//    void bonusNumberValidationTest() {
//
//    }
}
