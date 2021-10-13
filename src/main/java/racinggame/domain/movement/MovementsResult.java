package racinggame.domain.movement;

import racinggame.domain.car.carname.CarName;
import racinggame.domain.car.position.Position;
import racinggame.domain.race.RaceStep;

public class MovementsResult {
	private final Movements movements;
	private final CarName carName;

	private MovementsResult(Movements movements, CarName carName) {
		this.movements = movements;
		this.carName = carName;
	}

	public static MovementsResult of(Movements movements, CarName carName) {
		return new MovementsResult(movements, carName);
	}

	public Position getFinalPosition() {
		return movements.getFinalPosition();
	}

	public CarName getCarName() {
		return carName;
	}

	public Position getPositionAt(RaceStep raceStep) {
		return movements.getPositionAt(raceStep);
	}
}
