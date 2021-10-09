package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

	@ParameterizedTest
	@ValueSource(strings = {"car", "mine", "me"})
	void 자동차는_이름을_갖는다(String carName) {
		Car car = Car.from(CarName.valueOf(carName));
		assertThat(car.isNameOf(CarName.valueOf(carName))).isTrue();
	}
}