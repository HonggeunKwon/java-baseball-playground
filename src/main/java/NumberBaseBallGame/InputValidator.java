package NumberBaseBallGame;

import NumberBaseBallGame.exception.InvalidInput;

public class InputValidator {
    public static final int INPUT_SIZE = 3;
    private static final String INVALID_INPUT_MESSAGE_FORMAT = "Invalid Input %s";
    public static void validate(String input) {
        if(input.length() != INPUT_SIZE || !input.matches("[0-9]+")) {
            throw new InvalidInput(
                    String.format(INVALID_INPUT_MESSAGE_FORMAT, input)
            );
        }
    }
}
