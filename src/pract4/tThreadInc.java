package pract4;

public class tThreadInc extends Thread{

	MonitorIncDec mon;
	int id;
	
	tThreadInc(MonitorIncDec mon, int id) {
		this.mon = mon;
		this.id = id;
		System.out.println("Hilo incrementador " + id + " creado.");
	}
	
	public void run() {
		for(int i = 0; i < 3;i++) {
			mon.inc(id);
		}
	}
}
