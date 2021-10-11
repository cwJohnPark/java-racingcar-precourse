package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
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

	public int size() {
		return carNames.size();
	}

	public boolean containsAll(List<CarName> carNameList) {
		return carNames.containsAll(carNameList);
	}
}
