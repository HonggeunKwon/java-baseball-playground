package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + a", "1 c 2", "1 + +", "+ 1 +", "+ + 1", "1 / 0"})
    @DisplayName("올바르지 않은 문자열 입력 시, 예외가 반환되어야 한다.")
    void invalid_input(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 / 3:1", "1 + 3 - 5 * 7 / 7:-1"}, delimiter = ':')
    @DisplayName("올바른 문자열 입력 시, 계산 결과가 일치해야 한다.")
    void valid_calculate(String input, String expected) {
        int result = calculator.calculate(input);
        assertThat(String.valueOf(result)).isEqualTo(expected);
    }

}