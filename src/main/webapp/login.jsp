<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>CaseKartin</h3>
		<form onsubmit="login()">
			<label for="userName">user name</label> <input type="text" id="userName"
				name="userName" placeholder="User Name" pattern="[a-zA-Z0-9]{5,10}" required autofocus />
			<br />
			<br /> <label for="password"></label>password<input type="password" id="password"
				name="password" placeholder="Password" pattern="[a-zA-Z0-9*&$#@!]{5,10}"
				required autofocus /> <br />
			<br />
			<button class="btn btn-info"type="submit">Login</button>
			<button type="reset" class="btn btn-info">Reset</button>		
		</form>
	</main>
<script type="text/javascript">
function login(){
	event.preventDefault();
	let userName=document.querySelector("#userName").value;
	let password=document.querySelector("#password").value;
	const queryParameter = "?userName=" + userName +"&password="+password;
	let url = "LoginServlet"+queryParameter;
	fetch(url).then(res=> res.json()).then(res=> {
	let message=res;
	if(message=="true")
	{
	alert("Login Success");
	window.location.href="index.jsp";
	}
else
	{
	alert(message);
	window.location.href="login.jsp";
	}
	
	}
	);
}
</script>
</body>
</html>