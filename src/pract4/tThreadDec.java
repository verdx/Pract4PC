package pract4;

public class tThreadDec extends Thread{
	Int2 n;
	int id;
	
	tThreadDec(Int2 n,  int id) {
		this.n = n;
		this.id = id;
		System.out.println("Hilo decrementador " + id + " creado.");
	}
	
	public void run() {
		for(int i = 0; i < 3;i++) {
			n.n--;
			System.out.println("Hilo: "+ id + ": " + n.n);
		}
	}
}
