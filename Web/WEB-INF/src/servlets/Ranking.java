package servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.IFachadaCapaLogica;
import logica.ValueObjetcs.DataJugador;
import logica.exceptions.ExceptionsPersistencia;


public class Ranking extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IFachadaCapaLogica fachada;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{   	       	    
	    // guardo el mensaje en el contexto
	    ServletContext context = super.getServletContext();
	    boolean hayError =false;
	    String msjError = "";
	    synchronized (context)
		{			
			try {
				String url ="//" + "localhost" + ":" +"1099"+ "/" + "fachada";		//HardCode
				fachada = (IFachadaCapaLogica) Naming.lookup(url); 	// ACCEDE AL SERVER 
				DataJugador [] arregloJugadores = fachada.listarRanking();
				
				ArrayList <DataJugador> arraylist= new ArrayList<>();
				for(int i=0;i<arregloJugadores.length;i++)
					arraylist.add(arregloJugadores[i]);
				context.setAttribute("Ranking", arraylist);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				hayError = true;
				msjError = e.getMessage();
				req.setAttribute("msgError", msjError);
			}
			catch (ExceptionsPersistencia e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				hayError = true;
				msjError =e2.getMessage();
				req.setAttribute("msgError", msjError);
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				hayError = true;
				msjError =e.getMessage();
				req.setAttribute("msgError", msjError);
			}
						
	    }    
	    
		//Pagina Resultado
		RequestDispatcher rd;
		if(!hayError)
			rd = req.getRequestDispatcher("Ranking.jsp");
		else
			rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(req, resp);
	}
}
