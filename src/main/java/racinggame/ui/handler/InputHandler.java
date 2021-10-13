package racinggame.ui.handler;

import java.util.function.Supplier;

import racinggame.domain.exception.RacingGameException;

public class InputHandler<T> {

	private static final String INTEGER_PARSING_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";

	public static <T> InputHandler<T> createHandler() {
		return new InputHandler<>();
	}

	public T retryUntilComplete(Supplier<T> supplier) {
		InputHandlerResult<T> handlerResult = InputHandlerResult.createFail();
		while (handlerResult.isFailed()) {
			handlerResult = exceptionHandler(supplier);
		}
		return handlerResult.getResult();
	}

	private InputHandlerResult<T> exceptionHandler(Supplier<T> supplier) {
		try {
			final T inputResult = supplier.get();
			return InputHandlerResult.createSuccess(inputResult);
		} catch (NumberFormatException nfe) {
			System.out.println(INTEGER_PARSING_EXCEPTION_MESSAGE);
		} catch (RacingGameException e) {
			System.out.println(e.getMessage());
		}
		return InputHandlerResult.createFail();
	}

}

