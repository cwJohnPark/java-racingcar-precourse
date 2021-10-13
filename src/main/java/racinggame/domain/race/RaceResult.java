package racinggame.domain.race;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.car.carname.CarNames;
import racinggame.domain.car.position.Position;
import racinggame.domain.movement.MovementsResult;

public class RaceResult {

	private static final String CHAMPION_ANNOUNCEMENT_FORMAT = "최종 우승자는 %s 입니다.";
	private static final String RACE_STEP_ANNOUNCEMENT_FORMAT = "%s : %s\n";

	private final List<MovementsResult> movementsResults;
	private final RaceCount totalRaces;

	private RaceResult(List<MovementsResult> movementsResults, RaceCount totalRaces) {
		this.movementsResults = movementsResults;
		this.totalRaces = totalRaces;
	}

	public static RaceResult from(List<MovementsResult> movementsResults, RaceCount raceCount) {
		return new RaceResult(movementsResults, raceCount);
	}

	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int count : totalRaces) {
			stringBuilder.append(getDescriptionStepAt(RaceStep.valueOf(count)));
		}

		stringBuilder.append(getDescriptionOfChampion());

		return stringBuilder.toString();
	}

	private String getDescriptionOfChampion() {
		Position foremostPosition = getForemostPosition();
		List<MovementsResult> championResult = new ArrayList<>();
		for (MovementsResult candidateResult : movementsResults) {
			championResult = appendIfEqualPosition(championResult, foremostPosition, candidateResult);
		}

		return getDescriptionOfChampion(championResult);
	}

	private List<MovementsResult> appendIfEqualPosition(List<MovementsResult> championResult, Position foremostPosition,
		MovementsResult candidateMovements) {
		final List<MovementsResult> appendResult = new ArrayList<>(championResult);
		if (candidateMovements.getFinalPosition().equals(foremostPosition)) {
			appendResult.add(candidateMovements);
		}
		return appendResult;
	}

	private String getDescriptionOfChampion(List<MovementsResult> championResult) {
		CarNames championCarNames = CarNames.createEmpty();
		for (MovementsResult movementsResult : championResult) {
			championCarNames.add(movementsResult.getCarName());
		}

		return format(CHAMPION_ANNOUNCEMENT_FORMAT, String.join(",", championCarNames.toStringArray()));
	}

	private Position getForemostPosition() {
		Position foremostPosition = Position.START_POSITION;

		for (MovementsResult candidateResult : movementsResults) {
			foremostPosition = foremostPosition.isAheadOf(candidateResult.getFinalPosition())
				? foremostPosition : candidateResult.getFinalPosition();
		}

		return foremostPosition;
	}

	private StringBuilder getDescriptionStepAt(RaceStep raceStep) {
		StringBuilder description = new StringBuilder();

		for (MovementsResult movementsResult : movementsResults) {
			description.append(
				format(RACE_STEP_ANNOUNCEMENT_FORMAT, movementsResult.getCarName(),
					movementsResult.getPositionAt(raceStep))
			);
		}

		return description;
	}

}
