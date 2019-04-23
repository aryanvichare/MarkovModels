package FiveStateBaby;

public class FiveStateBaby {
	
	static final String[] stateNames = { "sleeping", "eating", "crying", "playing", "fussing" };
	
	static final int SLEEPING = 0;
	static final int EATING = 1; 
	static final int CRYING = 2; 
	static final int PLAYING = 3; 
	static final int FUSSING = 4; 
	
	private static int currentState;
	static double[][] transitions = { { 0.2, 0.4, 0.1, 0.15, 0.15 },
							          { 0.4, 0.1, 0.0, 0.3, 0.2 },
							          { 0.0, 0.2, 0.1, 0.2, 0.5 },
							          { 0.1, 0.2, 0.1, 0.3, 0.3 },
							          { 0.1, 0.1, 0.3, 0.4, 0.1 } };
	
	public FiveStateBaby(int startState) {
		currentState = startState; 
	}
	
	public static void train(int[] stateSequence) {
		
		int[][] transitions = new int[5][5];
		
		for(int i = 0; i < stateSequence.length - 1; i++) {
			transitions[stateSequence[i]][stateSequence[i+1]]++; 
		}
		
		print(transitions);
		double[] sumRow = sumRow(transitions);
		for(int i = 0; i < sumRow.length; i++) {
			System.out.println(sumRow[i] + ", ");
		}
		
		String[][] prob = new String[5][5];
		
		for(int i = 0; i < prob.length; i++) {
			for(int j = 0; j < prob.length; j++) {
				if(sumRow[i] != 0) {
					prob[i][j] = String.format("%.2f", (transitions[i][j])/(sumRow[i]));
				}
				else {
					prob[i][j] = "0.00";
				}
			}
		}
		
		print(prob);
	}
	
	public void displayBabyStates(int n) {
		int x;
		for(int i = 0; i < n; i++) {
			x = predictState();
			if(x == 0) System.out.print("SLEEPING ");
			if(x == 1) System.out.print("EATING ");
			if(x == 2) System.out.print("CRYING ");
			if(x == 3) System.out.print("PLAYING ");
			if(x == 4) System.out.print("FUSSING ");
			
			currentState = x;
		}
	}
	
	public static int predictState() {
		double p = Math.random();
		double lb = 0, hb = transitions[currentState][0];
		for(int i = 0; i < 4; i++) {
			if(p > lb && p < hb) return i;
			else {
				// Shifting bounds
				lb += transitions[currentState][i];
				hb += transitions[currentState][i + 1];
			}
		}	
		return FUSSING; 
	}
	
	public void transitionToNextState() {
		currentState = predictState();
	}

	public static double[] sumRow(int[][] a){
		double[] sumRow = new double[a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				sumRow[i] += a[i][j];
			}
		}
		return sumRow; 
	}
	
	private static void print(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void print(double[][] a){
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void print(String[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
