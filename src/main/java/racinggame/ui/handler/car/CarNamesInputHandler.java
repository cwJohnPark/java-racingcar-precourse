package racinggame.ui.handler.car;

import nextstep.utils.Console;
import racinggame.domain.car.carname.CarNames;
import racinggame.ui.handler.InputHandler;

public class CarNamesInputHandler {

	private static final String CAR_NAME_INPUT_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private static final InputHandler<CarNames> inputHandler = InputHandler.createHandler();

	public static CarNames inputCarName() {
		return inputHandler.retryUntilComplete(() -> {
				System.out.println(CAR_NAME_INPUT_ANNOUNCEMENT);
				return CarNames.from(Console.readLine());
			}
		);
	}
}
