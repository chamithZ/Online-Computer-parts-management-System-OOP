package webpro;

import jakarta.servlet.RequestDispatcher;




 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email=request.getParameter("uid");
		String password=request.getParameter("pass");
		
		 boolean isTrue;
		  
		 isTrue =CusDBUtil.validate(email, password);
		 
		 if(isTrue==true) {
			 dbConnect connect=new dbConnect();
			
			 Customer cus=new Customer(email,password);
			 
			 request.getSession().setAttribute("cus",cus);
			 RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
			 dis.forward(request, response);
			 
		 }
		 else {
			 	out.println("<script type='text/javascript'>");
				out.println("alert('Your Email or password is invalid');");
				out.println("location='login.jsp'");
				out.println("</script>");
			 
		 }
			/*
			 * try { List<Customer> cusDetails=CusDBUtil.validate(email, password);
			 * request.setAttribute("cusDetails", cusDetails); } catch(Exception e) {
			 * e.printStackTrace(); }
			 */
		
		
		
	}

}
