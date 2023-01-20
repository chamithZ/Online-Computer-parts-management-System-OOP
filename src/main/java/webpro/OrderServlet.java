package webpro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            Customer cus = (Customer) request.getSession().getAttribute("cus");

            if (cus != null) {
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                order orderModel = new order();
                orderModel.setId(Integer.parseInt(productId));
                orderModel.setUid(cus.getId());
                orderModel.setQuantity(productQuantity);
                orderModel.setDate(formatter.format(date));

                dbConnect connect=new dbConnect();
                
                orderDButil orderDao = new orderDButil(connect.getConnection());
                boolean result = orderDao.insertOrder(orderModel);
                if (result) {
                    ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (cart c : cart_list) {
                            if (c.getId() == Integer.parseInt(productId)) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    out.println("<script type='text/javascript'>");
    				out.println("alert('Item purchased!');");
    				out.println("location='order.jsp'");
    				out.println("</script>");
                    
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } 
	}
    

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);

    } 


}