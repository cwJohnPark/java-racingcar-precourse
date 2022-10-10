package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void N대의_자동차는_주어진_횟수_동안_전진_또는_멈출_수_있다() {
        final MoveCount numberOfMove = new MoveCount(10);
        Cars cars = getRacingCars(5);

        cars.moveAll(numberOfMove, new RandomMoveCondition(new NumberRange(0, 9), new Threshold(6)));

        CarMovementsResults carsMovementResults = cars.getCarsMovementResult();

        assertThat(carsMovementResults.isEqualMoveCount(numberOfMove));
    }

    private Cars getRacingCars(int numberOfCars) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car(new CarName("car-"+i)));
        }
        return new Cars(carList);
    }
}
