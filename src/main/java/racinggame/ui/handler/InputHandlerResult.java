package racinggame.ui.handler;

import static racinggame.ui.handler.InputResult.*;

import java.util.Objects;

public class InputHandlerResult<T> {
	private final InputResult inputResult;
	private final T resultData;

	private InputHandlerResult(InputResult inputResult, T resultData) {
		this.inputResult = inputResult;
		this.resultData = resultData;
	}

	public static <T> InputHandlerResult<T> createSuccess(T inputResult) {
		if (Objects.isNull(inputResult)) {
			throw new RuntimeException();
		}
		return new InputHandlerResult<>(SUCCESS, inputResult);
	}

	public static <T> InputHandlerResult<T> createFail() {
		return new InputHandlerResult<>(FAILED, null);
	}

	public T getResult() {
		if (inputResult == FAILED) {
			throw new RuntimeException();
		}
		return resultData;
	}

	public boolean isFailed() {
		return inputResult == FAILED;
	}
}
