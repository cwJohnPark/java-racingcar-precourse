package racinggame.domain.car.exception;

import racinggame.domain.exception.RacingGameException;

public class InvalidCarNameException extends RacingGameException {

	public InvalidCarNameException() {
		super("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
	}
}
