<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleQ.css">
<%@include file="templates/header.jsp" %>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" ></script>
<div class="containr1">
<div class="containerQ">
<div class="cardHeader">
<h1 class="fontQ">QuenTech Store</h1>
</div>

<div class="row">
<%	

	if(!item.isEmpty()){
		
		for(item i:item){%> 
			
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="img/<%=i.getImg()%>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=i.getName() %></h5>
						<h6 class="price">Price: $<%=i.getPrice() %></h6>
						<h6 class="category">Category: <%=i.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="addToCart?id=<%=i.getId()%>">Add to Cart</a> 

								<a class="btn btn-primary" href="OrderServlet?quantity=1&id=<%=i.getId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			
			
		<%} 
		
	}

	else{
		out.println("There is no proucts");
	}


%>



	
</div>


</div>

</div>





<%@include file="templates/footer.jsp" %>
</body>
</html>