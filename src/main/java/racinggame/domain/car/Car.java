package racinggame.domain.car;

import racinggame.domain.car.cardriver.CarDriver;
import racinggame.domain.car.carname.CarName;
import racinggame.domain.movement.MovementType;
import racinggame.domain.movement.Movements;
import racinggame.domain.movement.MovementsResult;
import racinggame.domain.race.RaceCount;

public class Car {

	private final CarName name;
	private final CarDriver driver;

	public Car(CarName name, CarDriver driver) {
		this.name = name;
		this.driver = driver;
	}

	public static Car of(CarName name, CarDriver driver) {
		return new Car(name, driver);
	}

	public boolean isNameOf(CarName otherCarName) {
		return name.equals(otherCarName);
	}

	public MovementType move() {
		return driver.steer();
	}

	public MovementsResult startRace(RaceCount raceCount) {
		final Movements movements = Movements.createEmpty();
		raceCount.forEach((count) -> movements.add(move()));

		return MovementsResult.of(movements, name);
	}
}
