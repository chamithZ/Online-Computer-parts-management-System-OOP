<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/register.css">


</head>
<body>
 <div class="main-container">
        <div class="container">
            <div class="form-container">
                <h2>Create an Account</h2>
	<form action="insert" method="post" >
		Name <input type="text" name="name" required><br>
		Email <input type="text" name="email" required><br>
		Phone Number <input type="text" name="phone" required><br>
		User Name <input type="text" name="uid" required><br>
		Password <input type="password" name="psw" required><br>
		
		<input type="submit" name="submit" value="Create Customer">
	</form>
	</div>
	</div>
	</div>
</body>

</html>