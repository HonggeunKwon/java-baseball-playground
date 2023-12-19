package NumberBaseBallGame;

import NumberBaseBallGame.enums.GameStart;

public class BaseBallSimulator {
    private final BaseBallHandler baseBallHandler;
    private final GameInterface gameInterface;

    private int[] answer;

    public BaseBallSimulator() {
        baseBallHandler = new BaseBallHandler();
        gameInterface = new GameInterface();
    }

    public void start() {
        answer = baseBallHandler.generateRandomValue();

        String input = null;

        do {
            input = gameInterface.getInput();
        } while (isCorrect(input));
    }

    public GameStart reGame() {
        String input = gameInterface.getInput();
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (input.equals("1")) {
                return GameStart.START;
            } else if (input.equals("2")) {
                return GameStart.END;
            }
        }
    }

    private boolean isCorrect(String input) {
        return !baseBallHandler.checkResult(input, answer);
    }

    private void init() {
    }
}
