
public class BeatByFrequency implements Player {
	
	// BeatByFrequency. This player should keep track of how frequently the opponent plays rock,
	// scissors, and paper, and use those counts to generate probabilities. Use these probabilities to
	// predict what the player will do next and play to beat it.

	private int currentTotalGames; 
	private int rockWins; 
	private int paperWins; 
	private int scissorWins; 
	
	private int rockProbability; 
	private int paperProbability; 
	private int scissorProbability;
	
	private int lastMove; 

	public BeatByFrequency() {
		currentTotalGames = 0; 
		rockWins = 0; paperWins = 0; scissorWins = 0; 
		rockProbability = 0; paperProbability = 0; scissorProbability = 0;
		lastMove = RPS.ROCK;
	}

	public int getMove() {
		double p = Math.random(); // 0 to 1 
		if(p < rockProbability) lastMove = RPS.ROCK;
		else if(p < paperProbability) lastMove = RPS.PAPER;
		else if(p < scissorProbability) lastMove = RPS.SCISSORS;
		
		return lastMove;
	}
	
	public void updateFrequencies(int outcome) {
		if(outcome == RPS.ROCK) rockWins++; 
		if(outcome == RPS.PAPER) paperWins++; 
		if(outcome == RPS.SCISSORS) scissorWins++;
		rockProbability = rockWins/currentTotalGames;
		paperProbability = paperWins/currentTotalGames;
		scissorProbability = scissorWins/currentTotalGames;
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
		currentTotalGames++;
		if(outcome == RPS.OPPONENT) {
			// The opponent won 
			updateFrequencies(outcome); 
		}
		
		opponentMove = getMove();
		
	}

}
