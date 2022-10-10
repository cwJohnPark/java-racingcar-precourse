package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public void moveAll(MoveCount moveCount, RandomMoveCondition moveCondition) {
        if (moveCount.isStopToMove()) {
            return;
        }
        for (Car car : cars) {
            car.move(moveCondition);
        }

        moveAll(moveCount.decrease(), moveCondition);
    }

    public CarMovementsResults getCarsMovementResult() {
        List<CarMovementsResult> movementsResults = new ArrayList<>();
        for (Car car : cars) {
            new CarMovementsResult(car.getName(), car.getTotalMovements());
        }

        return new CarMovementsResults(movementsResults);
    }
}
