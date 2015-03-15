package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintStream;

import logica.IFachadaCapaLogica;
import servidor.ObjectCliente;
import valueObjects.DataMensaje;
import valueObjects.DataPersona;
import logica.ValueObjetcs.*;
import logica.exceptions.ExceptionsPersistencia;



public class Ranking extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private static IFachadaCapaLogica fachada;	
	
	public void init()
	{		
		fachada = ObjectCliente.Inicializar();

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	    // obtengo los datos del Request
	    //String mensaje = req.getParameter("mensaje");

	    // obtengo el nombre del autor de la sesión
        HttpSession session = req.getSession();
	  /*  DataJugador datosPer;
	    synchronized (session)
	    {
	        datosPer = (DataJugador) session.getAttribute("datosPer");    
	    }	*/	    
	    	    
	    // guardo el mensaje en el contexto
	    ServletContext context = super.getServletContext();
	    synchronized (context)
		{
	    	//String autor = datosPer.getNombre();
	    	ArrayList<DataJugador> jugadores = null;
			try {
				jugadores = new ArrayList<DataJugador>(Arrays.asList(fachada.listarRanking()));
			} catch (ClassNotFoundException | ExceptionsPersistencia e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			for (DataJugador dataJugador : jugadores) {
				out.println(dataJugador.getNombre());
			}
			out.close ();
	    	//ArrayList<DataJugador> mensajes = jugadores//((ArrayList<DataJugador>)  fachada.listarRanking());//(ArrayList <DataJugador>) context.getAttribute("mensajes");
	    	//if (mensajes == null)
	    		//mensajes = new ArrayList<DataJugador>();
	    	//mensajes.add(datosMens);			        
	    	context.setAttribute("Ranking",jugadores);
	    }    
	    
		// forwardeo a la página de resultados
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("Ranking.jsp");
		rd.forward(req, resp);
	}
	
	public void destroy()
	{
		
	}
}
