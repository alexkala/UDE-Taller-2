package servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Arrays;

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
	    boolean error = false;
	    String msjError = new String();
	    synchronized (context)
		{			
			try {
				String url ="//localhost:1099/fachada";
				fachada = (IFachadaCapaLogica) Naming.lookup(url); 	// ACCEDE AL SERVER 
				DataJugador[] jugadores = fachada.listarRanking();
				
				ArrayList <DataJugador> ranking = (ArrayList<DataJugador>) Arrays.asList(jugadores); 	// Transforma el arreglo en ArrayList
				
				context.setAttribute("ranking", ranking);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				error = true;
				msjError = e.getMessage();
				req.setAttribute("msgError", msjError);
			}
			catch (ExceptionsPersistencia e2) {
				e2.printStackTrace();
				error = true;
				msjError =e2.getMessage();
				req.setAttribute("msgError", msjError);
			} catch (NotBoundException e) {
				e.printStackTrace();
				error = true;
				msjError =e.getMessage();
				req.setAttribute("msgError", msjError);
			}
						
	    }    
	    
		//Pagina Resultado
		RequestDispatcher rd;
		if(!error)
			rd = req.getRequestDispatcher("Ranking.jsp");
		else
			rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(req, resp);
	}
}
