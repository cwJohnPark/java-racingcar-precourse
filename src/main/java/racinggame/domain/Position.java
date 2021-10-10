package racinggame.domain;

import java.util.Objects;

import racinggame.domain.movement.MovementType;

public class Position {

	public static final Position START_POSITION = Position.valueOf(0);

	private final int position;

	private Position(int position) {
		this.position = position;
	}

	public static Position valueOf(int position) {
		return new Position(position);
	}

	@Override
	public String toString() {
		return getResultAsString();
	}

	public String getResultAsString() {
		StringBuilder result = new StringBuilder(position);
		for (int i = 0; i < position; i++) {
			result.append("-");
		}
		return result.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Position position1 = (Position)other;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	public Position adjustPosition(MovementType movement) {
		return movement == MovementType.FORWARD ? Position.valueOf(position + 1) : this;
	}
}
