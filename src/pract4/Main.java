package pract4;

public class Main {

	public static void main(String args[]) {
		ProdCons();
	}
	
	private static void IncDec() {
		int ni = 7;
		tThreadDec[] dec = new tThreadDec[ni];
		tThreadInc[] inc = new tThreadInc[ni];
		MonitorIncDec mon = new MonitorIncDec();
		for(int i = 1; i <= (ni*2);i+=2) {
			dec[i/2] = new tThreadDec(mon, i);
			inc[i/2] = new tThreadInc(mon, i + 1);
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
	
	private static void ProdCons() {
		int ni = 7;
		tThreadProd[] dec = new tThreadProd[ni];
		tThreadCons[] inc = new tThreadCons[ni];
		MonitorProdCons mon = new MonitorProdCons();
		for(int i = 1; i <= (ni*2);i+=2) {
			dec[i/2] = new tThreadProd(mon, i);
			inc[i/2] = new tThreadCons(mon, i + 1);
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
