package racinggame.domain.movement;

import static org.assertj.core.api.Assertions.*;
import static racinggame.domain.movement.MovementType.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.domain.car.position.Position;
import racinggame.domain.race.RaceStep;

class MovementsTest {

	private static Stream<Arguments> provideCarListMovementsPerStep() {
		return Stream.of(
			Arguments.of(
				Arrays.asList(FORWARD, FORWARD, FORWARD),
				Arrays.asList(Position.valueOf(1), Position.valueOf(2), Position.valueOf(3))),
			Arguments.of(
				Arrays.asList(FORWARD, STOP, FORWARD),
				Arrays.asList(Position.valueOf(1), Position.valueOf(1), Position.valueOf(2))),
			Arguments.of(
				Arrays.asList(STOP, STOP, STOP, STOP),
				Arrays.asList(Position.valueOf(0), Position.valueOf(0), Position.valueOf(0), Position.valueOf(0)))
		);
	}

	private static Stream<Arguments> provideMovementTypes() {
		return Stream.of(
			Arguments.of(
				Arrays.asList(FORWARD, FORWARD, FORWARD),
				Position.valueOf(3)),
			Arguments.of(
				Arrays.asList(FORWARD, STOP, FORWARD),
				Position.valueOf(2)),
			Arguments.of(
				Arrays.asList(STOP, STOP, STOP, STOP),
				Position.valueOf(0))
		);
	}

	@ParameterizedTest
	@MethodSource("provideMovementTypes")
	void N번_운전_후_최종위치는_전진한_횟수와_일치해야한다(List<MovementType> movementTypes, Position expectedPosition) {
		final Movements movements = Movements.createEmpty();

		for (MovementType movementType : movementTypes) {
			movements.add(movementType);
		}

		assertThat(movements.getFinalPosition()).isEqualTo(expectedPosition);
	}

	@ParameterizedTest
	@MethodSource("provideCarListMovementsPerStep")
	void N번_운전_후_각_시행별_위치를_알_수_있다(List<MovementType> movementTypes, List<Position> expectedPositions) {
		final Movements movements = Movements.createEmpty();

		for (int i = 0; i < movementTypes.size(); i++) {
			movements.add(movementTypes.get(i));
			final RaceStep raceStep = RaceStep.valueOf(i);
			assertThat(movements.getPositionAt(raceStep)).isEqualTo(expectedPositions.get(i));
		}
	}

}