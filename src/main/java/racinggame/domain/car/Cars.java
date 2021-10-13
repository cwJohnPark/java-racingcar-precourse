package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.movement.MovementsResult;
import racinggame.domain.race.RaceCount;
import racinggame.domain.race.RaceResult;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars from(List<Car> carList) {
		return new Cars(carList);
	}

	public RaceResult startRace(RaceCount raceCount) {
		return raceAll(raceCount);
	}

	private RaceResult raceAll(RaceCount raceCount) {
		List<MovementsResult> movementsResults = new ArrayList<>();
		for (Car car : cars) {
			movementsResults.add(car.startRace(raceCount));
		}
		return RaceResult.from(movementsResults, raceCount);
	}
}
