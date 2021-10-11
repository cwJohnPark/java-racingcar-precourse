package racinggame.ui.handler.car;

import static java.lang.String.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.test.NSTest;

@DisplayNameGeneration(ReplaceUnderscores.class)
public class CarInputHandlerTest extends NSTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@ParameterizedTest
	@CsvSource("test,123,a")
	void 자동차_이름을_쉼표로_구분하여_여러_자동차_이름을_받을_수_있다(String first, String second, String third) {

		assertSimpleTest(() -> {
			run(format("%s,%s,%s", first, second, third));
			verify("");
		});
	}

	@ParameterizedTest
	@CsvSource({"abcdef,abcde", "123456,abcde"})
	void 잘못된_자동차_이름_입력시_재입력을_받아야한다(String badInput, String validInput) {
		assertSimpleTest(() -> {
			run(badInput, validInput);
			verify(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		CarNamesInputHandler.inputCarName();
	}
}
