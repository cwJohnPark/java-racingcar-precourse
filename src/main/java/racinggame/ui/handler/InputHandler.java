package racinggame.ui.handler;

import java.util.function.Supplier;

import racinggame.domain.car.CarNames;

public class InputHandler<T> {

	public static InputHandler<CarNames> createHandler() {
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
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return InputHandlerResult.createFail();
		}
	}

}

