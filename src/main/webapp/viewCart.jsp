<!DOCTYPE html>
<html lang="en">
<head>
<title>Display Users</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%		
		String userName = (String) session.getAttribute("LOGGED_IN_USER");
		%>
		<h3>List Of item</h3>
		<table class="table table-bordered">
			<caption>List of item</caption>
			<thead>
				<tr>
					<th id="">S.No</th>
					<th id="caseName">Case Name</th>
					<th id="mobileBrand">Mobile Brand</th>
					<th id="mobileModel">Mobile Model</th>
					<th id="price">Price</th>
					<th id="noOfCases">Number Of Cases</th>
				</tr>
			</thead>
			<tbody id="cart-table">
			</tbody>
		</table>
	</main>
	<script type="text/javascript">		

		function getCartdetails(){
			let url = "ViewCartServlet?userName=<%=userName%>";
			
			fetch(url).then(res=> res.json()).then(res=>{
				let cartDetails = res;
				console.log(cartDetails);
				
				let content = "";
				let serial=1;
				for(let cartList of cartDetails){ 
					
					console.log(cartList.noOfCases);
					content += "<tr><td>"+serial+
					"</td><td>"+cartList.caseName+
					"</td><td>"+cartList.mobileBrand+
					"</td><td>"+cartList.mobileModel+
					"</td><td>Rs."+cartList.price+
					"/-</td><td>"+cartList.noOfCases+
					"</td></tr>";
					serial++;
					
				}
				console.log(content);
				document.querySelector("#cart-table").innerHTML= content;
			})	
		}
		getCartdetails();
	
	</script>
	
</body>
</html>