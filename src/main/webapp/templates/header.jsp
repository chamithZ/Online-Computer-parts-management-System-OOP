<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="webpro.*" %>
    <%@page import="java.util.*"%>
    <%@page import="java.text.DecimalFormat"%>
    <%
    DecimalFormat dcf=new DecimalFormat("#.##");
    request.setAttribute("dcf",dcf);
    Customer cus=(Customer)request.getSession().getAttribute("cus");
    if(cus!=null){
    	request.setAttribute("cus",cus);
    }
   
    
    dbConnect dbc=new dbConnect();
    itemDButill id=new itemDButill(dbc.getConnection());
    List<item> item=id.getAllItem();
    
    %>
    <%
    
  /* Cart */
	ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
	List<cart> cartProduct = null;
	if (cart_list != null) {
		dbConnect db1=new dbConnect();
		itemDButill pDao = new itemDButill(db1.getConnection());
		cartProduct = pDao.getCartitem(cart_list);
		double total=pDao.getTotCartPrice(cart_list);
		request.setAttribute("cart_list", cart_list);
		request.setAttribute("total", total);
}
%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <link rel="stylesheet" type="text/css" href="./css/header.css">
    <link rel="stylesheet" type="text/css" href="./css/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />
    <script src="./js/form.js" defer></script>
    <script src="./js/script.js" defer></script>

    <title>
        <?php echo $title; ?>
    </title>
</head>

<body>

     <header>
        <div class="header">
            <div class="top-container">
                <div class="logo">
                 
                    <a href="index.jsp" class="brand-logo">
                        <!-- <img src="./src/logo.png"  id="logo"> -->
                    </a>
                </div>
                <div class="cat-button">
                <a href="index.jsp" > <button class="Hbtn">Home</button></a>
                   
                   
                </div>

                <div class="bottom-container">
                <nav>
                    <div class="nav-links">
                        <ul id="nav-mobile" class="right hide-on-med-and-down">
                            <li><a href="store.jsp">Store</a></li>
                            <li><a href="Contactus.jsp ">Contact</a></li>
                            <li><a href="faq.jsp ">FAQ</a></li>
                            <li><a href="aboutus.jsp ">About Us</a></li>
                            
                        </ul>
                    </div>
                </nav>
            </div>
                <div class="search-bar">
                    <div class="search">
                        
                            <a href="search.jsp"><button type="submit" class="search-btn" name="search-btn">
                            <i class="fa fa-search"></i>
                        </button></a>
                        
                    </div>
                </div>

                <div class="login">
                	<%
						if(cus!=null){
							%>
							<a href="cart.jsp"><button>Cart<span  class="badge badge-danger px-1">${cart_list.size()}</span></button></a>
							<a href="logout">
		                    <button>
		                    <span>
		                    		
		                        <img src="./src/profile.svg " alt=" " style="margin-right:5px; width:20px; height:auto ">
		                    </span>
		                    <span>Log out</span>
		                </button> </a>
						<%
						} 
						else{%>
						<a href="login.jsp"><button>Log In</button></a>	
						<a href="customerInsert.jsp">
		                    <button>
		                    <span>
		                        <img src="./src/profile.svg " alt=" " style="margin-right:5px; width:20px; height:auto ">
		                    </span>
		                    <span>Sign in</span>
		                </button> </a>
						<%
						}
					%>
                    
                    
                    
                </div>

            </div>
           
        </div>
    </header>



    </body>
</html>