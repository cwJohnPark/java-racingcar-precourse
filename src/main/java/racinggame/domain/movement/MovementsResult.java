package racinggame.domain.movement;

import racinggame.domain.Position;
import racinggame.domain.RaceStep;
import racinggame.domain.car.CarName;

public class MovementsResult {
	private final Movements movements;
	private final CarName carName;

	private MovementsResult(Movements movements, CarName carName) {
		this.movements = movements;
		this.carName = carName;
	}

	public static MovementsResult of(Movements movementsTemp, CarName carName) {
		return new MovementsResult(movementsTemp, carName);
	}

	public Position getFinalPosition() {
		return movements.getFinalPosition();
	}

	public CarName getCarName() {
		return carName;
	}

	public RaceStep getRaceStep() {
		return RaceStep.valueOf(movements.getSize());
	}

	public Position getPositionAt(RaceStep raceStep) {
		return movements.getPositionAt(raceStep);
	}
}
