package logica;

import java.io.Serializable;

public class Monitor implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cantLectores;
	private boolean escribiendo;
	
	public Monitor(){
		cantLectores=0;
		escribiendo=false;
	}
	
	public synchronized void comienzoLectura() //throws InterruptedException
	{
		while (escribiendo) 
		{	try { 
				wait();
			}
			catch (InterruptedException e){}
		}
		
		cantLectores = cantLectores + 1;			
	}
	
	public synchronized void terminoLectura()
	{
		notify();
		cantLectores = cantLectores - 1;
	}
	
	public synchronized void comienzoEscritura() 
	{
		while ((escribiendo) || (cantLectores>0))
		{	try { 
				wait();
			}
			catch (InterruptedException e){}
		}
		
		escribiendo = true;
	}
	
	public synchronized void terminoEscritura()
	{
		notify();
		escribiendo = false;
	}

}
