package racingcar;

import java.util.List;

public class CarMovementsResults {

    private final List<CarMovementsResult> carMovementsResults;

    public CarMovementsResults(List<CarMovementsResult> carMovementsResults) {
        this.carMovementsResults = carMovementsResults;
    }

    public boolean isSizeOf(int numberOfMovements) {
        return carMovementsResults.size() == numberOfMovements;
    }
}
