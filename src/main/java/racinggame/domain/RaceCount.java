package racinggame.domain;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

import racinggame.domain.exception.InvalidRaceCountInputException;

public class RaceCount implements Iterable<Integer> {

	private final int step;

	private RaceCount(Integer step) {
		this.step = step;
	}

	public static RaceCount valueOf(int count) {
		inspectRange(count);
		return new RaceCount(count);
	}

	private static void inspectRange(int count) {
		if (count < 1) {
			throw new InvalidRaceCountInputException();
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RaceCountIterator(step);
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		for (int count : this) {
			action.accept(count);
		}
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		RaceCount raceCount = (RaceCount)other;
		return Objects.equals(step, raceCount.step);
	}

	@Override
	public int hashCode() {
		return Objects.hash(step);
	}

	static class RaceCountIterator implements Iterator<Integer> {
		private final int totalCount;
		private int currentCount;

		public RaceCountIterator(int totalCount) {
			this.totalCount = totalCount;
			this.currentCount = 0;
		}

		@Override
		public boolean hasNext() {
			return totalCount > currentCount;
		}

		@Override
		public Integer next() {
			return currentCount++;
		}
	}

}
