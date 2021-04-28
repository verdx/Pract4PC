package pract4;

public class Main {

	public static void main(String args[]) {
		IncDec();
	}
	
	private static void IncDec() {
		Int2 n= new Int2(0);
		int ni = 7;
		tThreadDec[] dec = new tThreadDec[ni];
		tThreadInc[] inc = new tThreadInc[ni];
		for(int i = 1; i <= (ni*2);i+=2) {
			dec[i/2] = new tThreadDec(n, i);
			inc[i/2] = new tThreadInc(n, i + 1);
			dec[i/2].start();
			inc[i/2].start();
		}
		for(int i = 0; i < ni;i++) {
			try {
				dec[i].join();
				inc[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
