package racingcar;

public class Car {

    private final CarName carName;
    private final Movements movements;

    public Car(CarName carName) {
        this.carName = carName;
        this.movements = Movements.create();
    }

    public Movements getMovements() {
        return movements;
    }

    public void move(RandomMoveCondition randomMoveCondition) {
        if (randomMoveCondition.doMove()) {
            movements.add(MoveType.FORWARD);
            return;
        }
        movements.add(MoveType.STOP);
    }

    public CarName getName() {
        return carName;
    }
}
