package webpro;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class customerinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String uid=request.getParameter("uid");
		String psw=request.getParameter("psw");
		
		boolean isTrue;
		
		isTrue=CusDBUtil.insertcustomer(name, email, phone,uid, psw);
		
		if(isTrue==true) {
			
			RequestDispatcher dis=request.getRequestDispatcher("suc.jsp");
			dis.forward(request, response);
			
		}
		else    {
			RequestDispatcher dis2=request.getRequestDispatcher("unsuc.jsp");
			dis2.forward(request,response);
			
		}
		
		
		
		 
		// TODO Auto-generated method stub
	}

}
