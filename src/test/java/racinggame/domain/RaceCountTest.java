package racinggame.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

class RaceCountTest {

	@Test
	void 경주_횟수는_순회가능하다() {
		RaceCount raceCount = RaceCount.valueOf(3);
		int stepCounter = 0;
		for (int step : raceCount) {
			assertThat(step).isEqualTo(stepCounter);
			stepCounter += 1;
		}
	}
}