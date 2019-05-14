
public class BeatLastWinningMovePlayer implements Player {
	// BeatLastWinningMovePlayer. This player should play to beat the winning move from last round.

	private int lastOutcome; 
	private int theirLastMove;
	private int yourLastMove;
	private int lastRoundWinningMove; 
	
	
	public BeatLastWinningMovePlayer() {
		lastRoundWinningMove = RPS.ROCK; 
	}

	public int getMove() {
		if(lastOutcome == RPS.OPPONENT) {
			lastRoundWinningMove = getlastWinningMove(lastRoundWinningMove);
			return lastRoundWinningMove;
		} else return yourLastMove;
	}
	
	public int getlastWinningMove(int prev) {
		// get the winning move from the last round 
		if (prev == RPS.ROCK) return RPS.PAPER;
		if (prev == RPS.SCISSORS) return RPS.ROCK;
		return RPS.SCISSORS;
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
		this.theirLastMove = opponentMove;
		this.yourLastMove = yourMove; 
		this.lastOutcome = outcome; 
	}

}
