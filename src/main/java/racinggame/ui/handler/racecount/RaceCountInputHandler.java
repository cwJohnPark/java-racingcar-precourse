package racinggame.ui.handler.racecount;

import nextstep.utils.Console;
import racinggame.domain.RaceCount;
import racinggame.ui.handler.InputHandler;

public class RaceCountInputHandler {

	private static final String CAR_NAME_INPUT_ANNOUNCEMENT = "시도할 횟수는 몇회인가요?";

	private static final InputHandler<RaceCount> inputHandler = InputHandler.createHandler();

	public static RaceCount inputRaceCount() {
		return inputHandler.retryUntilComplete(
			() -> RaceCount.valueOf(Integer.parseInt(Console.readLine()))
		);
	}
}
