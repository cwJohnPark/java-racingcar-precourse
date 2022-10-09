package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingCarInputController {

    private final static String PROMPT = "경주할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)";
    private final static String CAR_NAME_SPLITTER = ",";

    private final Scanner scanner;

    public RacingCarInputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public CarNames inputCarNames() {
        System.out.println(PROMPT);

        List<String> carNamesLiteral = getCarNamesLiteral();

        CarNames carNames = CarNames.createEmpty();
        for (int i = 0; i < carNamesLiteral.size(); i++) {
            carNames.add(new CarName(carNamesLiteral.get(i)));
        }

        return carNames;
    }

    private List<String> getCarNamesLiteral() {
        String carNamesInline = scanner.nextLine();

        return new ArrayList<>(
                Arrays.asList(
                        carNamesInline.split(CAR_NAME_SPLITTER)));
    }
}
