package racinggame.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.domain.car.carname.CarName;
import racinggame.domain.car.position.Position;
import racinggame.domain.movement.MovementType;
import racinggame.domain.race.RaceCount;
import racinggame.domain.race.RaceResult;

class CarsTest {

	private static Stream<Arguments> provideCarListAndDriver() {
		return Stream.of(
			Arguments.of(
				RaceCount.valueOf(5),
				Cars.from(
					Arrays.asList(
						Car.of(CarName.valueOf("car1"), () -> MovementType.FORWARD),
						Car.of(CarName.valueOf("car2"), () -> MovementType.FORWARD),
						Car.of(CarName.valueOf("car3"), () -> MovementType.FORWARD)
					)
				),
				Arrays.asList(
					Position.valueOf(5),
					Position.valueOf(5),
					Position.valueOf(5)
				)
			),
			Arguments.of(
				RaceCount.valueOf(3),
				Cars.from(
					Arrays.asList(
						Car.of(CarName.valueOf("car1"), () -> MovementType.FORWARD),
						Car.of(CarName.valueOf("car2"), () -> MovementType.STOP)
					)
				),
				Arrays.asList(
					Position.valueOf(3),
					Position.valueOf(0)
				)
			)
		);
	}

	private static Stream<Arguments> provideRaceChampionCars() {
		return Stream.of(
			Arguments.of(
				RaceCount.valueOf(5),
				Cars.from(
					Arrays.asList(
						Car.of(CarName.valueOf("car1"), () -> MovementType.FORWARD),
						Car.of(CarName.valueOf("car2"), () -> MovementType.FORWARD),
						Car.of(CarName.valueOf("car3"), () -> MovementType.FORWARD)
					)
				),
				"car1,car2,car3"
			),
			Arguments.of(
				RaceCount.valueOf(3),
				Cars.from(
					Arrays.asList(
						Car.of(CarName.valueOf("car1"), () -> MovementType.FORWARD),
						Car.of(CarName.valueOf("car2"), () -> MovementType.STOP)
					)
				),
				"car1"
			),
			Arguments.of(
				RaceCount.valueOf(3),
				Cars.from(
					Arrays.asList(
						Car.of(CarName.valueOf("car1"), () -> MovementType.STOP),
						Car.of(CarName.valueOf("car2"), () -> MovementType.STOP),
						Car.of(CarName.valueOf("car3"), () -> MovementType.STOP)
					)
				),
				"car1,car2,car3"
			)
		);
	}

	@ParameterizedTest
	@MethodSource("provideCarListAndDriver")
	void 주어진_자동차_이동_횟수_만큼의_경주_완료_후_각_시행별_위치_결과를_반환_받는다(RaceCount raceCount, Cars cars,
		List<Position> expectedPositions) {

		RaceResult raceResult = cars.startRace(raceCount);

		System.out.println(raceResult.getDescription());

		expectedPositions.forEach(
			expectedPosition -> assertThat(raceResult.getDescription()).contains(expectedPosition.toString())
		);
	}

	@ParameterizedTest
	@MethodSource("provideRaceChampionCars")
	void 주어진_자동차_이동_횟수_만큼의_경주_완료_후_우승자_결과를_반환_받는다(RaceCount raceCount, Cars cars, String champions) {

		RaceResult raceResult = cars.startRace(raceCount);

		System.out.println(raceResult.getDescription());

		assertThat(raceResult.getDescription()).contains(champions);
	}

}
