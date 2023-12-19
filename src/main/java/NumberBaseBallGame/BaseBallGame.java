package NumberBaseBallGame;

import NumberBaseBallGame.enums.GameStart;

import static NumberBaseBallGame.enums.GameStart.*;

public class BaseBallGame {
    public static void main(String[] args) {
        BaseBallSimulator simulator = new BaseBallSimulator();

        do {
            simulator.start();
        } while (simulator.reGame() == START);
    }
}
