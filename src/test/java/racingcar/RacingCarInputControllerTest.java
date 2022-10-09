package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarInputControllerTest {

    final String carNames = "woni,jihee,monky";

    @BeforeEach
    void setStreams() {
        setCarNamesInStreams();
        setSystemOut();
    }

    @Test
    void 여러_대의_자동차_이름을_쉼표로_구분하여_입력_받는다() {
        CarNames expectedCarNames = getCarNames();

        RacingCarInputController inputController = new RacingCarInputController(new Scanner(System.in));

        CarNames actualCarNames = inputController.inputCarNames();

        assertThat(actualCarNames).isEqualTo(expectedCarNames);
    }

    public CarNames getCarNames() {
        String[] carNamesLiteral = carNames.split(",");
        CarNames carNames = CarNames.createEmpty();
        for (String carNameLiteral : carNamesLiteral) {
            carNames.add(new CarName(carNameLiteral));
        }

        return carNames;
    }

    private void setCarNamesInStreams() {
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));
    }

    private void setSystemOut() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

}