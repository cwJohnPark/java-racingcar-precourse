package racinggame.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.Position;
import racinggame.domain.RaceCount;
import racinggame.domain.movement.MovementType;
import racinggame.domain.movement.MovementsResult;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

	private static Stream<Arguments> provideMovements() {
		return Stream.of(
			Arguments.of(
				RaceCount.valueOf(3),
				Position.valueOf(3)
			),
			Arguments.of(
				RaceCount.valueOf(0),
				Position.valueOf(0)
			)
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"car", "mine", "me"})
	void 자동차_생성_테스트(String carName) {
		final Car car = createForwardDriveCar(CarName.valueOf(carName));

		assertThat(car.isNameOf(CarName.valueOf(carName))).isTrue();
		assertThat(car.move()).isEqualTo(MovementType.FORWARD);
	}

	private Car createForwardDriveCar(CarName carName) {
		return Car.of(carName, () -> MovementType.FORWARD);
	}

	@ParameterizedTest
	@MethodSource("provideMovements")
	void 자동차는_주어진_N번_운전_후_운전_결과를_반환한다(RaceCount raceCount, Position finalPosition) {
		final Car car = createForwardDriveCar(CarName.valueOf("test"));

		final MovementsResult movementsResult = car.startRace(raceCount);

		assertThat(movementsResult.getFinalPosition()).isEqualTo(finalPosition);
	}
}