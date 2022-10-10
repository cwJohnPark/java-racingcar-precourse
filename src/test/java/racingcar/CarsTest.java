package racingcar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    RandomMoveCondition moveCondition = new RandomMoveCondition(
            new NumberRange(0, 1), new Threshold(0));

    Cars cars = new Cars(Lists.newArrayList(
            new Car(new CarName("car-0")), new Car(new CarName("car-1")), new Car(new CarName("car-2"))));

    @Test
    void 자동차_경주__각_차수별로_이동거리를_알_수_있다() {

        cars.move(moveCondition);

        CarMovementsResults carsMovementResults = cars.getCarsMovementResult();

        assertThat(carsMovementResults.getResult().split("\n"))
                .containsExactly("car-0 : -", "car-1 : -", "car-2 : -");

        cars.move(moveCondition);

        carsMovementResults = cars.getCarsMovementResult();

        assertThat(carsMovementResults.getResult().split("\n"))
                .containsExactly("car-0 : --", "car-1 : --", "car-2 : --");
    }

}
