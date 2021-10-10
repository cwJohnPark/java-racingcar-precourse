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
	void 자동차_생성_테스트(String carName) {
		Car car = Car.of(CarName.valueOf(carName), () -> MovementType.FORWARD);

		assertThat(car.isNameOf(CarName.valueOf(carName))).isTrue();
		assertThat(car.move()).isEqualTo(MovementType.FORWARD);
	}
}