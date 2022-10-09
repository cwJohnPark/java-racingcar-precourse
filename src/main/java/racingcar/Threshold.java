package racingcar;

public class Threshold {

    private final int thresholdInclusive;

    public Threshold(int thresholdInclusive) {
        this.thresholdInclusive = thresholdInclusive;
    }

    public boolean isAbove(int other) {
        return thresholdInclusive <= other;
    }
}
