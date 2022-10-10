package racingcar.view;

import racingcar.controller.CarGameController;
import racingcar.controller.CarGameResponse;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;

public class CarGameView {

    private final CarGameController carGameController;
    private final CarInputController carInputController;

    public CarGameView(CarGameController carGameController, CarInputController carInputController) {
        this.carGameController = carGameController;
        this.carInputController = carInputController;
    }

    public void play() {
        CarNames carNames = carInputController.inputCarNames();
        MoveCount moveCount = carInputController.inputMoveCount();

        CarGameResponse carGameResponse = carGameController.play(carNames, moveCount);

        System.out.println("각 차수별 실행 결과");
        System.out.println(carGameResponse.getRaceResult());
        System.out.println("최종 우승자 : " + carGameResponse.getWinners());
    }

}
