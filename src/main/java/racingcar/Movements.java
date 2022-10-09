package racingcar;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Objects;

public class Movements {

    private final List<MoveType> movements;

    public Movements(List<MoveType> movements) {
        this.movements = movements;
    }

    public Movements(MoveType ...moveTypes) {
        this(Lists.newArrayList(moveTypes));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movements movements1 = (Movements) o;

        return movements.equals(movements1.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movements);
    }
}
