package racinggame.domain.exception;

public class InvalidCarNameException extends IllegalArgumentException {

	public InvalidCarNameException() {
		super("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
	}
}
