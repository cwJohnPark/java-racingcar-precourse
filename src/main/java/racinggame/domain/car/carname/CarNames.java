package racinggame.domain.car.carname;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarNames implements Iterable<CarName> {
	private static final String CAR_NAME_SEPARATOR = ",";

	private final List<CarName> carNames;

	public CarNames(List<CarName> carNames) {
		this.carNames = carNames;
	}

	public static CarNames createEmpty() {
		return new CarNames(new ArrayList<>());
	}

	public static CarNames from(String carNamesLiteral) {
		final String[] carNames = carNamesLiteral.split(CAR_NAME_SEPARATOR);
		List<CarName> carNameList = new ArrayList<>();
		for (String carName : carNames) {
			carNameList.add(CarName.valueOf(carName));
		}

		return new CarNames(carNameList);
	}

	public void add(CarName carName) {
		carNames.add(carName);
	}

	public List<String> toStringArray() {
		final List<String> carNamesStringList = new ArrayList<>();
		for (CarName carName : carNames) {
			carNamesStringList.add(carName.toString());
		}

		return carNamesStringList;
	}

	@Override
	public Iterator<CarName> iterator() {
		return new CarNamesIterator(carNames);
	}

	private static class CarNamesIterator implements Iterator<CarName> {

		private final List<CarName> carNames;
		private int count;

		public CarNamesIterator(List<CarName> carNames) {
			this.carNames = carNames;
			count = 0;
		}

		@Override
		public boolean hasNext() {
			return carNames.size() > count;
		}

		@Override
		public CarName next() {
			return carNames.get(count++);
		}
	}
}
