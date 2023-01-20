package webpro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


	@WebServlet("/cancelorder")
	public class cancelOrder extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try(PrintWriter out = response.getWriter()) {
				String id = request.getParameter("id");
				if(id != null) {
					
					 dbConnect connect=new dbConnect();
					orderDButil orderDao = new orderDButil(connect.getConnection());
					orderDao.cancelOrder(Integer.parseInt(id));
				}
				response.sendRedirect("orders.jsp");
			} 
		}

	}
