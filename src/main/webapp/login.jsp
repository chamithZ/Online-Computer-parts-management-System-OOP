<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >

<%@include file="templates/header.jsp" %>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" ></script>

<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">

				<form action="login" method="post">

					<div class="form-group">
						<label>Email</label> <input class="form-control" name="uid"
							placeholder="Enter your Email" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="pass" placeholder="********"
							required>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary" name="submit">Login</button>

					</div>
				</form>

			</div>
		</div>
	</div>


<%@include file="templates/footer.jsp" %>
</body>
</html>