package racinggame.domain.car.carname;

import java.util.Objects;

import racinggame.domain.car.exception.InvalidCarNameException;

public class CarName {

	private final String name;

	private CarName(String carName) {
		name = carName;
	}

	public static CarName valueOf(String carName) {
		if (!isValidCarName(carName)) {
			throw new InvalidCarNameException();
		}
		return new CarName(carName);
	}

	private static boolean isValidCarName(String carName) {
		return carName.length() >= 1 && carName.length() <= 5;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		CarName carName = (CarName)other;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
