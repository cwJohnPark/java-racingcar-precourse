package racinggame.domain.exception;

public class InvalidRaceCountInputException extends RuntimeException {

	public InvalidRaceCountInputException() {
		super("[ERROR] 잘못된 시도 횟수를 입력하셨습니다.");
	}
}
