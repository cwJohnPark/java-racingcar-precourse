package racinggame.domain;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class RaceCount implements Iterable<Integer>, Iterator<Integer> {

	private final int step;
	private int currentCount;

	private RaceCount(Integer step) {
		this.step = step;
		this.currentCount = 0;
	}

	public static RaceCount valueOf(int count) {
		return new RaceCount(count);
	}

	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		for (int count : this) {
			action.accept(count);
		}
	}

	@Override
	public boolean hasNext() {
		return step > currentCount;
	}

	@Override
	public Integer next() {
		return currentCount++;
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
		return Objects.equals(step, raceCount.step) &&
			Objects.equals(currentCount, raceCount.currentCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(step, currentCount);
	}

}
