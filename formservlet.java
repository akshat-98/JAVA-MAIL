package formUsingServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

/**
 * Servlet implementation class formservlet
 */
@WebServlet("/formservlet")
public class formservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		String username = request.getParameter("username");
		out.println("<html><head>");
		out.println("<title> YO </title>");
		out.println("</head><body>");
		out.println("<h1> Hello " + username + "</h1>");
		out.println("</body></html>");
		
		
	}
}
