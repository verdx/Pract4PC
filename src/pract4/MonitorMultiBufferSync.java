package pract4;

public class MonitorMultiBufferSync implements Almacen{

	private int maxN;
	private int n;
	private Producto buffer[];
	
	public MonitorMultiBufferSync(int n) {
		this.maxN = n;
		this.n = 0;
		buffer = new Producto[maxN];
	}
	
	public synchronized void almacenar(int id, Producto producto) throws InterruptedException {
		while(n >= maxN) wait();
		buffer[n] = producto;
		System.out.println("El productor " + id + " ha almacenado el producto " + producto.n +
				" en la posicion " + n + " del buffer.");
		n++;
		notifyAll();
	}
	
	public synchronized Producto extraer(int id) throws InterruptedException {
		while(n <= 0) wait();
		n--;
		Producto temp = buffer[n];
		System.out.println("El consumidor " + id + " ha extraido el producto " + temp.n +
				" de la posicion " + n + " del buffer.");
		notifyAll();
		return temp;
	}
	
}
