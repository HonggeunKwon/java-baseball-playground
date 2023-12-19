package NumberBaseBallGame;

import NumberBaseBallGame.exception.InvalidInput;

import java.util.Scanner;

public class GameInterface {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private final Scanner scanner;

    public GameInterface() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        System.out.print(INPUT_MESSAGE);
        String input = getNextLine();
        checkValidate(input);

        return input;
    }

    public String getNextLine() {
        return scanner.nextLine();
    }

    private void checkValidate(String input) {
        try {
            InputValidator.validate(input);
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
        }
    }
}
