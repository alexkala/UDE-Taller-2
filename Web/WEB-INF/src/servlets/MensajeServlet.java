package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import valueObjects.DataMensaje;
import valueObjects.DataPersona;

public class MensajeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	    // obtengo los datos del Request
	    String mensaje = req.getParameter("mensaje");

	    // obtengo el nombre del autor de la sesión
        HttpSession session = req.getSession();
	    DataPersona datosPer;
	    synchronized (session)
	    {
	        datosPer = (DataPersona) session.getAttribute("datosPer");    
	    }		    
	    	    
	    // guardo el mensaje en el contexto
	    ServletContext context = super.getServletContext();
	    synchronized (context)
		{
	    	String autor = datosPer.getNombre();
	    	DataMensaje datosMens = new DataMensaje(autor,mensaje);
	    	ArrayList<DataMensaje> mensajes = (ArrayList <DataMensaje>) context.getAttribute("mensajes");
	    	if (mensajes == null)
	    		mensajes = new ArrayList<DataMensaje>();
	    	mensajes.add(datosMens);			        
	    	context.setAttribute("mensajes",mensajes);
	    }    
	    
		// forwardeo a la página de resultados
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("Resultados.jsp");
		rd.forward(req, resp);
	}
}
