package pract4;

public class Main {

	public static void main(String args[]) {
		//IncDec();
		//ProdCons(new MonitorProdConsMonoBuffer());
		//ProdCons(new MonitorMultiBufferSync(5));
		ProdCons(new MonitorMultiBufferLC(5));
	}
	
	private static void ProdCons(Almacen mon) {
		int ni = 7;
		tThreadProd[] prod = new tThreadProd[ni];
		tThreadCons[] cons = new tThreadCons[ni];
//		for(int i = 1; i <= (ni*2);i+=2) {
//			prod[i/2] = new tThreadProd(mon, i);
//			cons[i/2] = new tThreadCons(mon, i + 1);
//			prod[i/2].start();
//			cons[i/2].start();
//		}
//		for(int i = 0; i < ni;i++) {
//			try {
//				prod[i].join();
//				cons[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		for(int i = 0; i < ni; i++) {
			prod[i] = new tThreadProd(mon, i);
			prod[i].start();
		}
		for(int i = 0; i < ni; i++) {
			cons[i] = new tThreadCons(mon, i+ni);
			cons[i].start();
		}
		for(int i = 0; i < ni; i++) {
			try {
				prod[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i < ni; i++) {
			try {
				cons[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
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
	
	
}
