package racinggame.ui.handler.racecount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.test.NSTest;

class RaceCountInputHandlerTest extends NSTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 5, Integer.MAX_VALUE})
	void 사용자는_자동차를_몇_번_이동할_것인지_입력할_수_있다(int inputCount) {
		assertSimpleTest(() -> {
			run(String.valueOf(inputCount));
			verify("");
		});
	}

	@ParameterizedTest
	@CsvSource({"-1,100", "0,100", "가나다,100"})
	void 잘못된_이동횟수를_입력시_오류메시지를_출력한다(String badInput, String validInput) {
		assertSimpleTest(() -> {
			run(badInput, validInput);
			verify(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		RaceCountInputHandler.inputRaceCount();
	}
}