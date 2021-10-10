package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarDriverTest {

	private static Stream<Arguments> provideCarDriver() {
		return Stream.of(
			Arguments.of((CarDriver)() -> MovementType.FORWARD, MovementType.FORWARD),
			Arguments.of((CarDriver)() -> MovementType.STOP, MovementType.STOP)
		);
	}

	@ParameterizedTest
	@MethodSource("provideCarDriver")
	void 자동차_드라이버는_전진할지_멈출지_결정할_수_있다(CarDriver carDriver, MovementType expectedType) {
		MovementType movementType = carDriver.steer();
		assertThat(movementType).isEqualTo(expectedType);
	}

}
