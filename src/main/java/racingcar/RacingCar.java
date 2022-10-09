package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final CarName carName;
    private final List<MoveType> moveResult;

    public RacingCar(CarName carName) {
        this.carName = carName;
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

    public CarName getName() {
        return carName;
    }
}
