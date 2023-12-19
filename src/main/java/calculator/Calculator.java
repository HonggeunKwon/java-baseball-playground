package calculator;

import java.util.Scanner;

public class Calculator {
    private final Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public String input() {
        return scanner.nextLine();
    }

    public String[] getNumbers(String input) {
        return RegexUtils.split(input, RegexUtils.OPERATOR_REGEX);
    }

    public String[] getOperators(String input) {
        return RegexUtils.split(input, RegexUtils.NUMBER_REGEX);
    }

    public int calculate(String[] numbers, String[] operators) {
        if (numbers.length - operators.length != 1) {
            throw new RuntimeException("입력값이 유효하지 않습니다.");
        }

        try {
            int sum = Integer.parseInt(numbers[0]);

            for (int i = 0; i < operators.length; i++) {
                sum = calculate(sum, numbers[i], operators[i]);
            }

            return sum;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private int calculate(int sum, String number, String operator) {
        int num = Integer.parseInt(number);
        switch (operator) {
            case "+":
                sum = add(sum, num);
                break;
            case "-":
                sum = minus(sum, num);
                break;
            case "*":
                sum = multiply(sum, num);
                break;
            case "/":
                sum = divide(sum, num);
                break;
            default:
                throw new RuntimeException(
                        String.format("Invalid Operator : %s", operator)
                );
        }

        return sum;
    }

    private int add(int A, int B) {
        return A + B;
    }

    private int minus(int A, int B) {
        return A - B;
    }

    private int multiply(int A, int B) {
        return A * B;
    }

    private int divide(int A, int B) {
        if (B == 0)
            throw new RuntimeException("0으로 나눌 수 없습니다.");
        return A / B;
    }
}
