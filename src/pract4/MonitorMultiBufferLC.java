package pract4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MonitorMultiBufferLC implements Almacen{
	
	private final Lock l;
	private final Condition colaProd;
	private final Condition colaCons;
	
	private int maxN;
	private int n;
	private Producto buffer[];
	
	public MonitorMultiBufferLC(int n) {
		this.maxN = n;
		this.n = 0;
		this.buffer = new Producto[maxN];
		this.l = new ReentrantLock();
		this.colaProd = l.newCondition();
		this.colaCons = l.newCondition();
	}

	@Override
	public void almacenar(int id, Producto producto) throws InterruptedException {
		l.lock();
		while(n >= maxN) colaProd.await();
		buffer[n] = producto;
		System.out.println("El productor " + id + " ha almacenado el producto " + producto.n +
				" en la posicion " + n + " del buffer.");
		n++;
		colaCons.signal();
		l.unlock();
	}

	@Override
	public Producto extraer(int id) throws InterruptedException {
		l.lock();
		while(n <= 0) colaCons.await();
		n--;
		Producto temp = buffer[n];
		System.out.println("El consumidor " + id + " ha extraido el producto " + temp.n +
				" de la posicion " + n + " del buffer.");
		colaProd.signal();
		l.unlock();
		return temp;
	}

}
