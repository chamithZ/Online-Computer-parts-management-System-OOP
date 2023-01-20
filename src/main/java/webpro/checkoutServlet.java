package webpro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class checkoutServlet
 */

@WebServlet("/checkoutServlet")

public class checkoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();  //set date
            
            //retrive all cart products
            ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart-list");
            
            //user authentication
            Customer cus = (Customer) request.getSession().getAttribute("cus");
			
			//check cus and cart lsit
            if(cart_list !=null && cus!=null) {
            	
            	for(cart c:cart_list) {
            		//prepare the order object
            		order ord=new order();
            		ord.setId(c.getId());
            		ord.setUid(c.getId()); //giving user id
            		ord.setQuantity(c.getQuantity());
            		ord.setDate(formatter.format(date));
            		dbConnect connect=new dbConnect();
                    
            		//intantiate the orderdb class
                    orderDButil oDb = new orderDButil(connect.getConnection());
                    //calling insert method
                    boolean result=oDb.insertOrder(ord);
                    
                    if(!result) break;
            		
            		
            	}
            	cart_list.clear(); //destroy all the cart list
            	response.sendRedirect("order.jsp");
            	
            }
            else {
            	if(cus==null) {
            		response.sendRedirect("login.jsp");
            		
            	}
            	if(cart_list==null) {
            		response.sendRedirect("cart.jsp");
            	}
            }
            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
