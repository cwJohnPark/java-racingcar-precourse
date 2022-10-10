package racingcar.view;

import racingcar.controller.CarGameController;
import racingcar.controller.CarGameResponse;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;

public class CarGameView {

    private final CarGameController carGameController;
    private final CarInputController carInputController;

    private static final String RACE_RESULT_PROMPT = "각 차수별 실행 결과";
    private static final String WINNER_PROMPT = "최종 우승자 : ";

    public CarGameView(CarGameController carGameController, CarInputController carInputController) {
        this.carGameController = carGameController;
        this.carInputController = carInputController;
    }

    public void play() {
        CarNames carNames = carInputController.inputCarNames();
        MoveCount moveCount = carInputController.inputMoveCount();

        CarGameResponse carGameResponse = carGameController.play(carNames, moveCount);

        System.out.println(RACE_RESULT_PROMPT);
        System.out.println(carGameResponse.getRaceResult());
        System.out.println(WINNER_PROMPT + carGameResponse.getWinners());
    }

}
