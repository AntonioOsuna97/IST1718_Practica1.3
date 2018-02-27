package Practica3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Inicio de sesion
		HttpSession sesion = request.getSession(true);
		response.setContentType("text/html");
		//Variable html de tipo printwriter que nos permitirá escribir en el html.
		PrintWriter html = response.getWriter();
		
		sesion.setAttribute("name", request.getAttribute("name"));
	

					
				
				Date date = (Date)sesion.getAttribute("date");
				if(date != null) {
				html.print("Último acceso de la sesión: " + date + "<br>");
				}
				else {
				html.print("Este es el primer acceso de la sesión "+ (String)sesion.getAttribute("name") +" <br>");
				}
				date = new Date();
				sesion.setAttribute("date", date);
				//Establece el tiempo de la cookie de sesion a 5 segundos.
				//Esto hace que al exceder el tiempo de la cookie, el servidor te proporcione un SessionID nuevo.
				sesion.setMaxInactiveInterval(5);
				html.print("Fecha actual: " + date);
				html.print("</strong>");
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
