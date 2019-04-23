package MarkovModels;

public class TwoStateBaby {
	static final String[] stateNames = { "awake", "sleeping" };
	static final int AWAKE = 0;
	static final int SLEEPING = 1; 
	
	private int currentState;
	double[][] transitions = { { 0.3, 0.7 },
							   { 0.4, 0.6 } };
	
	public TwoStateBaby(int startState) {
		currentState = startState; 
	}
	
	public int mostLikelyNextState() {
		if(transitions[currentState][0] > transitions[currentState][1]) return AWAKE;
		else return SLEEPING;
	}
	
	public int getNextState() {
		double p = Math.random();
		if(p < transitions[currentState][AWAKE]) return AWAKE;
		else return SLEEPING; 
	}
	
	public void transitionToNextState() {
		currentState = getNextState();
	}
	
	public void displayBabyStates(int n) {
		int x;
		for(int i = 0; i < n; i++) {
			x = getNextState();
			if(x == 0) {
				System.out.print("AWAKE ");
			}
			if(x == 1) {
				System.out.print("ASLEEP ");
			}
			currentState = x;
		}
	}

}
