package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static racinggame.domain.movement.MovementType.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.domain.movement.MovementType;

@DisplayNameGeneration(ReplaceUnderscores.class)
class PositionTest {

	private static Stream<Arguments> provideMovementsWithExpectedPosition() {
		return Stream.of(
			Arguments.of(
				Arrays.asList(FORWARD, STOP), Position.valueOf(1)
			),
			Arguments.of(
				Arrays.asList(FORWARD, FORWARD), Position.valueOf(2)
			),
			Arguments.of(
				Arrays.asList(STOP), Position.valueOf(0)
			)
		);
	}

	@ParameterizedTest
	@MethodSource("provideMovementsWithExpectedPosition")
	void 위치를_조정하여_새_위치를_반환_받을_수_있다(List<MovementType> movementTypes, Position expectedPosition) {
		Position position = Position.START_POSITION;

		for (MovementType movementType : movementTypes) {
			position = position.adjustPosition(movementType);
		}

		assertThat(position).isEqualTo(expectedPosition);
	}
}