package padSim;

public class Main {
	static double skyfall1 = 0;
	static double skyfall2 = 0;
	static double skyfall3 = 0;
	static double skyfall4 = 0;
	static double skyfall5more = 0;
	public static void main(String[] args) {
		//Start of changeable variables
		int orbTypes = 6; //Number of types of orb (normal = 6, no RCV = 5, tricolor = 4)
		int reps = 10000000; //Number of simulations run (caps at 2147483647, 1 million is about 10 seconds)
		int boardWidth = 6; //Number of orbs per row
		int boardHeight = 5; //Number of orbs per column
		int notifyCount = 100000; //Notifies you of progress every [this number] of runs
		//End of changeable variables

		//Working Code
		double tempcent = 0;
		for(int i=0;i<reps;i++){
			runSim(orbTypes,boardWidth,boardHeight);
			if(i%notifyCount==0){
				tempcent = skyfall1/i;
				System.out.print(i+"/"+reps+" trials run - Current % = "+tempcent+"\n");
			}
		}
		skyfall1 = skyfall1/reps;
		skyfall2 = skyfall2/reps;
		skyfall3 = skyfall3/reps;
		skyfall4 = skyfall4/reps;
		skyfall5more = skyfall5more/reps;		
		System.out.print("1+ match = "+skyfall1+", 2+ match = "+skyfall2+", 3+ match = "+skyfall3+", 4+ match = "+skyfall4+", 5+ match = "+skyfall5more);
	}	

	public static void runSim(int x, int y, int z){
		int board[][][];
		board = new int[y][z][2];
		board = boardFill(board,x,y,z);
		int matches = 0;
		boolean matched = true;
		while(matched){
			matched = false;
			for(int k = 0; k < z; k++){ //horizontal match check
				for(int j=0; j < y-2; j++){
					if(board[j][k][0] == board[j+1][k][0] && board[j][k][0] == board[j+2][k][0]){
						if(board[j][k][1] == 0 && board[j+1][k][1] == 0 && board[j+2][k][1] == 0){
							matches++;
						}
						matched = true;
						board[j][k][1] = board[j+1][k][1] = board[j+2][k][1] = 1;
					}
				}
			}
			for(int k = 0; k < z-2; k++){ //vertical match check
				for(int j=0; j < y; j++){
					if(board[j][k][0] == board[j][k+1][0] && board[j][k][0] == board[j][k+2][0]){
						if(board[j][k][1] == 0 && board[j][k+1][1] == 0 && board[j][k+2][1] == 0){
							matches++;
						}
						matched = true;
						board[j][k][1] = board[j][k+1][1] = board[j][k+2][1] = 1;
					}
				}
			}
			if(matched){
				board = boardClear(board,y,z);
				board = boardFill(board,x,y,z);
			}
		}
		matchCatch(matches);
	}

	public static int randomRange(int min,int max){
		int r=(max-min)+1;
		return (int)(Math.random()*r)+min;
	}

	public static void matchCatch(int m){
		if(m>0){
			skyfall1=skyfall1+1;
		}
		if(m>1){
			skyfall2=skyfall2+1;
		}
		if(m>2){
			skyfall3=skyfall3+1;
		}
		if(m>3){
			skyfall4=skyfall4+1;
		}
		if(m>4){
			skyfall5more=skyfall5more+1;
		}
	}

	public static int[][][] boardClear(int board[][][], int y, int z){
		for(int k = 0;k < z; k++){ //clearing matched orbs
			for(int j=0; j < y; j++){
				if(board[j][k][1] == 1){
					board[j][k][0] = 0;
					board[j][k][1] = 0;
				}
			}
		}
		return board;
	}
	
	public static int[][][] boardFill(int board[][][], int x, int y, int z){
		for(int count = 0;count < z; count++){
			for(int k = z-1;k > -1;k=k-1){
				for(int j=0;j<y;j++){
					if(board[j][k][0]==0){
						if(k==0){
							board[j][k][0]=randomRange(1,x);
						}else{
							board[j][k][0]=board[j][k-1][0];
							board[j][k-1][0]=0;
						}
					}
				}
			}
		}

		return board;
	}
	//made by Phi/CC
	//PAD Phi161803
	//PAD 368 658 315
}
