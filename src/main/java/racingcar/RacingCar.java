package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<MoveType> moveResult;

    public RacingCar() {
        this.moveResult = new ArrayList<>();
    }

    public List<MoveType> getTotalMovements() {
        return moveResult;
    }

    public void move(RandomMoveCondition randomMoveCondition) {
        if (randomMoveCondition.doMove()) {
            moveResult.add(MoveType.FORWARD);
            return;
        }
        moveResult.add(MoveType.STOP);
    }
}
