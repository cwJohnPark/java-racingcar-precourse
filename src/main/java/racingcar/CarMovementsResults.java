package racingcar;

import java.util.List;

public class CarMovementsResults {

    private final List<CarMovementsResult> carMovementsResults;

    public CarMovementsResults(List<CarMovementsResult> carMovementsResults) {
        this.carMovementsResults = carMovementsResults;
    }

    public boolean isEqualMoveCount(MoveCount moveCount) {
        return moveCount.isEqualTo(carMovementsResults.size());
    }
}
