package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    void N대의_자동차는_주어진_횟수_동안_전진_또는_멈출_수_있다() {
        final int numberOfMove = 10;
        RacingCars racingCars = getRacingCars(5);

        racingCars.moveAll(numberOfMove, new RandomMoveCondition(new NumberRange(0, 9), new Threshold(6)));

        CarMovementsResults carsMovementResults = racingCars.getCarsMovementResult();

        assertThat(carsMovementResults.isSizeOf(numberOfMove));
    }

    private RacingCars getRacingCars(int numberOfCars) {
        List<RacingCar> racingCarList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            racingCarList.add(new RacingCar(new CarName("car-"+i)));
        }
        return new RacingCars(racingCarList);
    }
}
