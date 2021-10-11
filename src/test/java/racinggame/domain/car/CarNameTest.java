package racinggame.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.car.exception.InvalidCarNameException;

class CarNameTest {

	@ParameterizedTest
	@ValueSource(strings = {"valid", "12345", "a"})
	void 자동차_이름은_5자_이하만_가능하다(String carName) {
		assertThatNoException()
			.isThrownBy(() -> assertThat(CarName.valueOf(carName)));
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalid", "123456", "abcde f"})
	void 자동차_이름이_5자_초과인_경우_예외를_던진다(String carName) {
		assertThatExceptionOfType(InvalidCarNameException.class)
			.isThrownBy(() -> assertThat(CarName.valueOf(carName)));
	}
}
