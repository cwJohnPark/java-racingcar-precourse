package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        CarGameView carGameView = new CarGameView(
                new CarGameController(
                        new RandomMoveCondition(new NumberRange(0, 9), new Threshold(4))),
                new CarInputController(new Scanner(System.in)));

        carGameView.play();
    }
}
