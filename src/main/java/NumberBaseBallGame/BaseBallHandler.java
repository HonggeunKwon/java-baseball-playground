package NumberBaseBallGame;

import com.sun.tools.javac.util.List;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseBallHandler {
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int NUMBER_SIZE = InputValidator.INPUT_SIZE;

    private final Random random;

    public BaseBallHandler() {
        this.random = new Random();
    }

    public int[] generateRandomValue() {
        int[] numbers = new int[NUMBER_SIZE];
        int size = new HashSet<>(List.of(numbers)).size();
        do {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(10);
            }
        } while (reGenerate(numbers));

        return numbers;
    }

    public boolean checkResult(String input, int[] answer) {
        int[] userNums = stringToNumbers(input);

        int strike = 0, ball = 0;

        for (int i = 0; i < userNums.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == userNums[i]) {
                    if (i == j) strike++;
                    else ball++;
                    break;
                }
            }
        }

        return isFinished(strike, ball);
    }

    private boolean reGenerate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }

        return set.size() != NUMBER_SIZE;
    }

    private int[] stringToNumbers(String input) {
        int[] numbers = new int[NUMBER_SIZE];

        for (int i = 0; i < NUMBER_SIZE; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    private boolean isFinished(int strike, int ball) {
        String message = generateResponseMessage(strike, ball);
        System.out.println(message);

        if (strike == 3) {
            System.out.println(END_MESSAGE);
            return true;
        }
        return false;
    }

    private String generateResponseMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        return sb.toString();
    }
}
