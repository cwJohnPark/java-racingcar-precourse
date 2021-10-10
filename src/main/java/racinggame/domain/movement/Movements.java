package racinggame.domain.movement;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.Position;
import racinggame.domain.RaceStep;

public class Movements {
	private final List<Position> movements;

	public Movements(List<Position> movements) {
		this.movements = movements;
	}

	public static Movements createEmpty() {
		return new Movements(new ArrayList<>());
	}

	public void add(MovementType movementType) {
		Position position = getLastMovement();
		movements.add(position.adjustPosition(movementType));
	}

	private Position getLastMovement() {
		return movements.isEmpty() ? Position.START_POSITION : movements.get(movements.size() - 1);
	}

	public Position getFinalPosition() {
		return getPositionAt(RaceStep.valueOf(movements.size() - 1));
	}

	public Position getPositionAt(RaceStep raceStep) {
		return raceStep.getPositionOf(movements);
	}
}
