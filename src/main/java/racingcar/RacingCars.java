package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCars = racingCarList;
    }

    public void moveAll(int numberOfMove, RandomMoveCondition moveCondition) {
        if (numberOfMove <= 0) {
            return;
        }
        for (RacingCar racingCar : racingCars) {
            racingCar.move(moveCondition);
        }

        moveAll(numberOfMove-1, moveCondition);
    }

    public CarMovementsResults getCarsMovementResult() {
        List<CarMovementsResult> movementsResults = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            new CarMovementsResult(racingCar.getName(), racingCar.getTotalMovements());
        }

        return new CarMovementsResults(movementsResults);
    }
}
