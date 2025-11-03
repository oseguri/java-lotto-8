package lotto;


import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;

public class InputManagerTest {

    @AfterEach
    void restore(){
        Console.close();
    }

    static void setUp(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("구매 가격을 올바른 입력이 들어올 때 까지 입력받는다")
    void getPriceTest(){
        String input = "20\n200\n \n0\n1242\n30000\n";
        setUp(input);
        assertEquals(30000, InputManager.getPrice());
    }

    @Test
    @DisplayName("당첨 번호를 올바른 입력이 들어올 때 까지 입력받는다")
    void getWinNumberTest(){
        String input = "1,2,3,4,2,3\n1,2,3\na,b,c,d,e,f\n1|2|3|4|5|6\n1234\n1,1,1,2,3,4\n1,15,17,19,40,45\n";
        setUp(input);
        assertThat(List.of(1,15,17,19,40,45)).isEqualTo(InputManager.getWinNumbers());
    }

    @Test
    @DisplayName("보너스 번호를 올바른 입력이 들어올 때 까지 입력받는다")
    void getBonusNumberTest(){
        String input = " a\n46\n0\n5\n-1\n45\n";
        setUp(input);
        List<Integer> winNums = List.of(1,2,3,4,5,6);
        assertThat(45).isEqualTo(InputManager.getBonusNumber(winNums));
    }
}
