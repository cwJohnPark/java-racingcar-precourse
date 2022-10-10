package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public void move(RandomMoveCondition moveCondition) {
        for (Car car : cars) {
            car.move(moveCondition);
        }
    }

    public CarMovementsResults getCarsMovementResult() {
        List<CarMovementsResult> movementsResults = new ArrayList<>();

        for (Car car : cars) {
            movementsResults.add(
                    new CarMovementsResult(car.getName(), car.getMovements()));
        }

        return new CarMovementsResults(movementsResults);
    }
}
