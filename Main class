public class Main {
static double a = 0;
static double b = 0;
static double c = 0;
static double d = 0;
static double e = 0;
	public static void main(String[] args) {
		//Start of changeable variables
		int orbTypes = 6; //Number of types of orb (default = 6, no RCV = 5, tricolor = 4)
		int reps = 2147483647; //Number of simulations run (caps at 2147483647, 10 million is about 30 seconds)
		int boardWidth = 6; //Number of orbs per row (default: 6)
		int boardHeight = 5; //Number of orbs per column (default: 5)
		int notifyCount = 10000000; //Notifies you of progress every [this number] of runs (default: about 30 seconds)
		//End of changeable variables
		
		//Working Code
		double t = 0;
		for(int i=0;i<reps;i++){
			runSim(orbTypes,boardWidth,boardHeight);
			if(i%notifyCount==0){
				t = a/i;
				System.out.print(i+"/"+reps+" trials run - Current % = "+t+"\n");
			}
		}
		a = a/reps;
		b = b/reps;
		c = c/reps;
		d = d/reps;
		e = e/reps;		
		System.out.print(a+", "+b+", "+c+", "+d+", "+e);
	}	
	public static void runSim(int x, int y, int z){
		int o[][];
		o = new int[y][z];
		for(int k = 0; k < z; k++){
			for(int j = 0; j < y; j++){
				o[j][k] = rR(1,x);
			}
		}
		int m = 0;
		for(int k = 0; k < z; k++){
			for(int j=0; j < y-2; j++){
				if(o[j][k] == o[j+1][k] && o[j][k] == o[j+2][k] && (j == 0 || o[j][k] != o[j-1][k])){
					m++;
				}
			}
		}
		for(int k = 0; k < z-2; k++){
			for(int j=0; j < y; j++){
				if(o[j][k] == o[j][k+1] && o[j][k] == o[j][k+2] && (k == 0 || o[j][k] != o[j][k-1])){
					m++;
				}
			}
		}
		if(m>0){
			a=a+1;
		}
		if(m>1){
			b=b+1;
		}
		if(m>2){
			c=c+1;
		}
		if(m>3){
			d=d+1;
		}
		if(m>4){
			e=e+1;
		}
	}
	public static int rR(int min,int max){
		int r=(max-min)+1;
		return (int)(Math.random()*r)+min;
	}
//made by Phi/CC
//PAD Phi161803
//PAD 368 658 315
}
