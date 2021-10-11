package racinggame.domain;

import static java.lang.String.*;

import java.util.List;

import racinggame.domain.movement.MovementsResult;

public class RaceResult {

	private final List<MovementsResult> movementsResults;
	private final RaceCount totalRaces;

	private RaceResult(List<MovementsResult> movementsResults, RaceCount totalRaces) {
		this.movementsResults = movementsResults;
		this.totalRaces = totalRaces;
	}

	public static RaceResult from(List<MovementsResult> movementsResults, RaceCount raceCount) {
		return new RaceResult(movementsResults, raceCount);
	}

	public RaceCount totalRaces() {
		return totalRaces;
	}

	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int count : totalRaces) {
			stringBuilder.append(getDescriptionStepAt(RaceStep.valueOf(count)));
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

	private StringBuilder getDescriptionStepAt(RaceStep raceStep) {
		StringBuilder description = new StringBuilder();

		for (MovementsResult movementsResult : movementsResults) {
			description.append(
				format("%s: %s\n", movementsResult.getCarName(), movementsResult.getPositionAt(raceStep))
			);
		}

		return description;
	}

}
