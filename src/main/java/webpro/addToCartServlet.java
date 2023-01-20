package webpro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



@WebServlet("/addToCart")

public class addToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
//        	out.print("add to cart servlet");

            ArrayList<cart> cartList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            cart cm = new cart();
            cm.setId(id);
            cm.setQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
                //response.sendRedirect("index.jsp");
            } else {
                cartList = cart_list;

                boolean exist = false;
                for (cart c : cart_list) {
                    if (c.getId() == id) {
                        exist = true;
                        out.println("<script type='text/javascript'>");
        				out.println("alert('product exists in your cart!');");
        				out.println("location='cart.jsp'");
        				out.println("</script>");
                        
                    }
                    
                }
                if (!exist) {
                    cartList.add(cm);
                    response.sendRedirect("index.jsp");
                    //response.sendRedirect("index.jsp");
                }

                
            }
        }
	}

}
