package racinggame.domain.car;

import static racinggame.domain.movement.MovementType.*;

import nextstep.utils.Randoms;
import racinggame.domain.movement.MovementType;

public class RandomCarDriver implements CarDriver {

	private static final int RANDOM_NUMBER_START = 0;
	private static final int RANDOM_NUMBER_LIMIT = 9;
	private static final int FORWARD_THRESHOLD = 4;

	private RandomCarDriver() {
	}

	public static CarDriver create() {
		return new RandomCarDriver();
	}

	@Override
	public MovementType steer() {
		return getRandomNumberInRange() >= FORWARD_THRESHOLD ? FORWARD : STOP;
	}

	private int getRandomNumberInRange() {
		return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_LIMIT);
	}
}
