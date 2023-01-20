<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="webpro.*" %>
<%@page import="webpro.itemDButill" %>
<%@page import="java.util.*"%>

<%@page import="java.text.DecimalFormat"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <%@include file="templates/header.jsp"%> 

<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>


	<%-- <%
	if(cart_list!=null){
		for(cart c:cartItem){ %>
			<tr>
			<td><%=c.getName() %></td>
			<td><%=c.getCategory() %></td>
			<td><%= c.getPrice() %></td>
			<td>
				<form action="addToCart" method="post" class="form-inline">
				<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
					<div class="form-group d-flex justify-content-between">
						<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
						<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
						<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
					</div>
					<button type="submit" class="btn btn-primary btn-sm">Buy</button>
				</form>
			</td>
			<td><a href="" class="btn btn-sm btn-danger">Remove</a></td>
		</tr>
		<% 
		}
		
	}
%>
 <div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody> <!--error  -->
				<%
				if (cart_list != null) {
					for (cart c : cartItem) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					
					<td>
						<form action="#" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div> --%>

	<div class="container my-3">
		<div class="d-flex py-3">
			<h3>Total Price:$ ${(total>0)?dcf.format(total):0}</h3>  <!-- import total from header.jsp -->
			<a class="mx-3 btn btn-primary" href="checkoutServlet">Check Out</a>
		</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			<% if(cart_list !=null){
				
				for(cart c:cartProduct){%>
					
					<tr>
					
					<td><%=c.getName()%></td>
					<td><%=c.getCategory() %></td>
					<td><%= dcf.format(c.getPrice())%></td>
					<td>
						<form action="OrderServlet" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=c.getId() %>" class="form-input">
							<div class="form-group d-flex justify-content">
							
			<a class="btn btn-sm btn-decre" href="quantityIncDecServlet?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
			<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity() %>" readonly> 
			<a class="btn btn-sm btn-incre" href="quantityIncDecServlet?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
			
			
			 </div>
			 <button type="submit" class="btn btn-primary">Buy</button> 
			
			</form>
</td>
					<td><a href="removeCartServlet?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>
					
				<%}
			}
			%>
			
			
				<!--error  -->

			</tbody>
		</table>
	</div>

</body>
</html>