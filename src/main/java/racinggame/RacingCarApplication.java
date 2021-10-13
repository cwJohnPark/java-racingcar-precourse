package racinggame;

import racinggame.domain.car.Cars;
import racinggame.domain.car.carname.CarNames;
import racinggame.domain.car.factory.RandomDriverCarFactory;
import racinggame.domain.race.RaceCount;
import racinggame.domain.race.RaceResult;
import racinggame.ui.handler.car.CarNamesInputHandler;
import racinggame.ui.handler.racecount.RaceCountInputHandler;

public class RacingCarApplication {

	private RacingCarApplication() {
	}

	public static RacingCarApplication createApplication() {
		return new RacingCarApplication();
	}

	public void startRacingCarGame() {
		final CarNames carNames = CarNamesInputHandler.inputCarName();
		final RaceCount raceCount = RaceCountInputHandler.inputRaceCount();

		final Cars cars = RandomDriverCarFactory.createCars(carNames);

		final RaceResult raceResult = cars.startRace(raceCount);

		System.out.println(raceResult.getDescription());
	}

}

