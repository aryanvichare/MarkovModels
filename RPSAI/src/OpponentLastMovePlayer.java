
public class OpponentLastMovePlayer implements Player {
	// OpponentLastMovePlayer. This player should play whatever the opponent’s last move was.
	
	int opponentLastMove; 
	
	public OpponentLastMovePlayer() {
		opponentLastMove = RPS.ROCK;
	}

	public int getMove() {
		return getOpponentsLastMove(opponentLastMove);
	}
	
	public int getOpponentsLastMove(int prev) {
		return prev; 
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
		opponentLastMove = opponentMove;  
	}

}
