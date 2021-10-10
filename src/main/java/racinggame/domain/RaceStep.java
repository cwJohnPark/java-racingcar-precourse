package racinggame.domain;

import java.util.List;

public class RaceStep {

	private final int step;

	private RaceStep(int step) {
		this.step = step;
	}

	public static RaceStep valueOf(int step) {
		return new RaceStep(step);
	}

	public Position getPositionOf(List<Position> movements) {
		return movements.get(step);
	}
}
