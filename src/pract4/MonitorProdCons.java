package pract4;

public class MonitorProdCons {
	
	private Producto buffer;
	
	public synchronized void almacenar(int id, Producto producto) throws InterruptedException {
		while(buffer!=null) wait();
		buffer = producto;	
		System.out.println("El productor " + id + " ha almacenado el producto " + producto.n);
		notifyAll();
	}
	
	public synchronized Producto extraer(int id) throws InterruptedException {
		while(buffer==null) wait();
		Producto temp = buffer;
		buffer = null;
		System.out.println("El consumidor " + id + " ha extraido el producto " + temp.n);
		notifyAll();
		return temp;
	}
	
	
}
