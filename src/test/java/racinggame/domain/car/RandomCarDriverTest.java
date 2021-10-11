package racinggame.domain.car;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static racinggame.domain.movement.MovementType.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.domain.movement.MovementType;

class RandomCarDriverTest {

	@ParameterizedTest
	@CsvSource({"0,false", "3,false", "4,true", "9,true"})
	void 자동차의_전진_조건은_0_부터_9_사이의_Random_값을_구하여_4_이상일_경우_전진하고_3_이하면_멈춘다(int randomNumber, boolean doForward) {
		final MovementType movementType = doForward ? FORWARD : STOP;

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(randomNumber);

			CarDriver carDriver = RandomCarDriver.create();

			final MovementType resultMovement = carDriver.steer();

			assertThat(resultMovement).isEqualTo(movementType);
		}
	}
}
