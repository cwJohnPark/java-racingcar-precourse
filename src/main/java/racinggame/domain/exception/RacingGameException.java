package racinggame.domain.exception;

public abstract class RacingGameException extends RuntimeException {
	public RacingGameException(String message) {
		super(message);
	}
}
