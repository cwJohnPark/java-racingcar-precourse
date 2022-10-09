package racingcar;

import java.util.Objects;

public class MoveCount {

    private final int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoveCount moveCount1 = (MoveCount) o;

        return moveCount == moveCount1.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }
}
