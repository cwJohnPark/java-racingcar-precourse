package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCars = racingCarList;
    }

    public void moveAll(MoveCount moveCount, RandomMoveCondition moveCondition) {
        if (moveCount.isStopToMove()) {
            return;
        }
        for (RacingCar racingCar : racingCars) {
            racingCar.move(moveCondition);
        }

        moveAll(moveCount.decrease(), moveCondition);
    }

    public CarMovementsResults getCarsMovementResult() {
        List<CarMovementsResult> movementsResults = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            new CarMovementsResult(racingCar.getName(), racingCar.getTotalMovements());
        }

        return new CarMovementsResults(movementsResults);
    }
}
