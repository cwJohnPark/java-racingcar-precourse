package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarInputController {

    private final static String CAR_NAMES_PROMPT = "경주할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)";
    private final static String MOVE_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private final static String CAR_NAME_SPLITTER = ",";

    private final Scanner scanner;

    public CarInputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public CarNames inputCarNames() {
        System.out.println(CAR_NAMES_PROMPT);

        List<String> carNamesLiteral = getCarNamesLiteral();

        CarNames carNames = CarNames.createEmpty();
        for (int i = 0; i < carNamesLiteral.size(); i++) {
            carNames.add(new CarName(carNamesLiteral.get(i)));
        }

        return carNames;
    }

    public MoveCount inputMoveCount() {
        System.out.println(MOVE_COUNT_PROMPT);

        return getMoveCount();
    }

    private MoveCount getMoveCount() {
        String moveCountLiteral = scanner.nextLine();
        return new MoveCount(Integer.parseInt(moveCountLiteral));
    }

    private List<String> getCarNamesLiteral() {
        String carNamesInline = scanner.nextLine();

        return new ArrayList<>(
                Arrays.asList(
                        carNamesInline.split(CAR_NAME_SPLITTER)));
    }
}
