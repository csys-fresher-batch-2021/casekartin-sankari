<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>CaseKartin</h3>
		<form action="LoginServlet" method=post>
			<label for="userName">user name</label> <input type="text"
				name="userName" placeholder="User Name" pattern="[a-zA-Z0-9]{5,10}" required autofocus />
			<br />
			<br /> <label for="password"></label>password<input type="password"
				name="password" placeholder="Password" pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,})"
				required autofocus /> <br />
			<br />
			<button type="submit" class="btn btn-info">Login</button>
		</form>
	</main>
</body>
</html>