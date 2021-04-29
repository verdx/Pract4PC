package pract4;

public class tThreadDec extends Thread{
	
	MonitorIncDec mon;
	int id;
	
	tThreadDec(MonitorIncDec mon, int id) {
		this.mon = mon;
		this.id = id;
		System.out.println("Hilo decrementador " + id + " creado.");
	}
	
	public void run() {
		for(int i = 0; i < 3;i++) {
			mon.dec(id);
		}
	}
}
