package pract4;

public class MonitorIncDec {
	
	private int n;
	
	public MonitorIncDec() {
		n = 0;
	}
	
	public synchronized void inc(int id) {
		n++;
		System.out.println("El proceso " + id + " ha incrementado la n a " + n);
	}
	
	public synchronized void dec(int id) {
		n--;
		System.out.println("El proceso " + id + " ha decrementado la n a " + n);
	}
	
	public synchronized int getN() {
		return n;
	}
	
}
