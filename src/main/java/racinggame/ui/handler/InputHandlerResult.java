package racinggame.ui.handler;

public class InputHandlerResult<T> {
	private final InputResult exceptionChecker;
	private final T resultData;

	private InputHandlerResult(InputResult exceptionChecker, T resultData) {
		this.exceptionChecker = exceptionChecker;
		this.resultData = resultData;
	}

	public static <T> InputHandlerResult<T> createSuccess(T inputResult) {
		return new InputHandlerResult<>(InputResult.SUCCESS, inputResult);
	}

	public static <T> InputHandlerResult<T> createFail() {
		return new InputHandlerResult<>(InputResult.FAILED, null);
	}

	public T getResult() {
		return resultData;
	}

	public boolean isFailed() {
		return exceptionChecker == InputResult.FAILED;
	}
}
