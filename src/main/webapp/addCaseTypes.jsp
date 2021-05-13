
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Case Name</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Case Type</h3>
		<form action="AddCaseTypeServlet">
			<label for="caseName">Case Name</label> <input type="text"
				name="caseName" placeholder="Enter case Name" required autofocus />
			<br />
			<br /> <label for="price">Price</label> <input type="number"
				name="cost" placeholder="Enter cost of case" step=".01" min=100
				required autofocus /> <br />
			<br />
			<button type="submit" class="btn btn-info">Submit</button>
		</form>
	</main>
</body>
</html>