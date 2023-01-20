package webpro;

import jakarta.servlet.ServletException;




import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/logout")


public class logoutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter Out = response.getWriter();
		response.setContentType("text/html");
		try(PrintWriter out=response.getWriter()){
			if(request.getSession().getAttribute("cus")!=null) {
				
				request.getSession().removeAttribute("cus");
				response.sendRedirect("login.jsp");
			}
			else {
				out.println("<script type='text/javascript'>");
				out.println("alert('You must Login first!');");
				out.println("location='index.jsp'");
				out.println("</script>");
				
			}
		}
		
	}

	
	

}
