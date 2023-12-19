package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void first_problem() {
        String input = "1,2";

        String[] split = input.split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void second_problem() {
        String input = "(1,2)";

        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열을 인덱스로 가져오면 값이 유효해야 하고, 인덱스를 벗어났을 때 예외를 반환해야한다.")
    void third_problem() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
