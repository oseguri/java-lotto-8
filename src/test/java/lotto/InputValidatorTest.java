package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class InputValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {" :false","0:false","999:false","1024:false","3000:true","10000:true"}, delimiter =':')
    void priceValidationTest(String price, String set) {
        if(set.equals("false")) {
            assertThatThrownBy(() -> InputValidator.validatePrice(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }else if(set.equals("true")) {
            assertThatCode(() -> InputValidator.validatePrice(price))
                    .doesNotThrowAnyException();
        }


    }

//    @ParameterizedTest
//    void winNumberValidationTest() {
//
//    }
//
//    @ParameterizedTest
//    void bonusNumberValidationTest() {
//
//    }
}
