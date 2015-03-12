package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import valueObjects.DataPersona;


public class IngresoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	    // obtengo los datos del Request
	    String nombre = req.getParameter("nombre");
	    String procedencia = req.getParameter("procedencia");

	    // valido los datos ingresados
	    boolean error = false;
	    String msgError = new String();
	    if ((nombre == null) || nombre.trim().equals(""))
	    {
			error = true;
			msgError = "El nombre no puede estar vacio";
	    }

	    // guardo los datos de la persona en la sesión
	    if (!error)
	    {		    
	        HttpSession session = req.getSession();
		    DataPersona datosPer = new DataPersona(nombre,procedencia);
		    synchronized (session)
		    {
		        session.setAttribute("datosPer",datosPer);    
		    }		    
	    }    
	    
		// forwardeo a la página apropiada
	    req.setAttribute("msgError", msgError);
		RequestDispatcher rd;
		if (!error)
			rd = req.getRequestDispatcher("Mensaje.jsp");
		else
			rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(req, resp);
	}
}
