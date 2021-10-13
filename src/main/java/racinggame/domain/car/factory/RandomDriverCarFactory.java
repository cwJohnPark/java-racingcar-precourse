package racinggame.domain.car.factory;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.car.Car;
import racinggame.domain.car.Cars;
import racinggame.domain.car.cardriver.CarDriver;
import racinggame.domain.car.cardriver.RandomCarDriver;
import racinggame.domain.car.carname.CarName;
import racinggame.domain.car.carname.CarNames;

public class RandomDriverCarFactory {

	private static final CarDriver randomCarDriver = RandomCarDriver.create();

	public static Car createRandomDriver(CarName carName) {
		return Car.of(carName, randomCarDriver);
	}

	public static Cars createCars(CarNames carNames) {
		List<Car> carList = new ArrayList<>();
		for (CarName carName : carNames) {
			carList.add(RandomDriverCarFactory.createRandomDriver(carName));
		}

		return Cars.from(carList);
	}
}
