package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class RacingCarTest {

    static final int MIN_RANDOM_NUMBER = 0;
    static final int MAX_RANDOM_NUMBER = 9;
    static final int THRESHOLD_NUMBER_INCLUSIVE = 4;

    static MockedStatic<Randoms> randoms;

    @BeforeAll
    static void setUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void clean() {
        randoms.close();
    }

    @Test
    void 자동차는_0에서_9사이에서_random_값을_가져와서_4이상일_경우_전진한다() {

        when(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)).thenReturn(THRESHOLD_NUMBER_INCLUSIVE);

        RacingCar racingCar = new RacingCar();
        RandomMoveCondition randomMoveCondition = getRandomMoveCondition();

        racingCar.move(randomMoveCondition);

        assertThat(racingCar.getTotalMovements()).containsExactly(MoveType.FORWARD);
    }

    @Test
    void 자동차는_0에서_9사이에서_random_값을_가져와서_4미만일_경우_멈춘다() {
        when(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)).thenReturn(THRESHOLD_NUMBER_INCLUSIVE - 1);

        RacingCar racingCar = new RacingCar();
        RandomMoveCondition randomMoveCondition = getRandomMoveCondition();

        racingCar.move(randomMoveCondition);

        assertThat(racingCar.getTotalMovements()).containsExactly(MoveType.STOP);
    }

    RandomMoveCondition getRandomMoveCondition() {
        return new RandomMoveCondition(
                new NumberRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER), new Threshold(THRESHOLD_NUMBER_INCLUSIVE));
    }
}
