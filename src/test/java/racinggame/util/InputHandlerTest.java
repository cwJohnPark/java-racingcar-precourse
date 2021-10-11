package racinggame.util;

import static java.lang.String.*;
import static org.assertj.core.api.Assertions.*;
import static testutil.CommandUtils.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.domain.car.CarName;
import racinggame.domain.car.CarNames;
import racinggame.ui.handler.CarNamesInputHandler;

@DisplayNameGeneration(ReplaceUnderscores.class)
public class InputHandlerTest {

	@ParameterizedTest
	@CsvSource("test,123,a")
	void 자동차_이름을_쉼표로_구분하여_여러_자동차_이름을_받을_수_있다(String first, String second, String third) {
		command(format("%s,%s,%s", first, second, third));

		final CarNames carNames = CarNamesInputHandler.inputCarName();

		assertThat(carNames.size()).isEqualTo(3);

		assertThat(carNames.containsAll(
			Arrays.asList(CarName.valueOf(first), CarName.valueOf(second), CarName.valueOf(third)))).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"abcdef,abcde", "123456,abcde"})
	void 잘못된_자동차_이름_입력시_재입력을_받아야한다(String badInput, String goodInput) {
		command(badInput, goodInput);

		final CarNames carNames = CarNamesInputHandler.inputCarName();

		assertThat(carNames.containsAll(Collections.singletonList(CarName.valueOf(goodInput)))).isTrue();
	}

}
