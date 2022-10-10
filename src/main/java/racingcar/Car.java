package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final CarName carName;
    private final List<MoveType> moveResult;

    public Car(CarName carName) {
        this.carName = carName;
        this.moveResult = new ArrayList<>();
    }

    public Movements getTotalMovements() {
        return new Movements(moveResult);
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
