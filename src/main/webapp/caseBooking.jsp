
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
<% String userName= (String) session.getAttribute("LOGGED_IN_USER");
   if(userName==null){
	   response.sendRedirect("login.jsp");
   }
%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="containe-fluid">
	<form onsubmit="booking()">
	<br/>
	<% String cases=request.getParameter("caseType");
	   String cost=request.getParameter("price");
	%>
		<label for="caseType">Case Type</label> <input type="text"
			name="caseType" id="caseType" value="<%=cases %>" readonly required /><br />
		<br />
		<label for="price">Price</label> <input type="text"
			name="price" id="price" value="<%=cost %>" readonly required /><br />
		<br />
		<br /> <label for="mobileBrand">Select Mobile Brand *</label> <select
			name="mobileBrand" id="mobileBrand" required>
			<option value="" disabled selected hidden>Choose a Mobile Brand</option>
			<option value="vivo">vivo</option>
			<option value="samsung">samsung</option>
			<option value="apple">Apple</option>
			<option value="lenovo">Lenovo</option>
		</select><br /> <br />
		<br /> <label for="mobileModel">Select Mobile Model *</label> <select
			name="mobileModel" id="mobileModel" required>
			<option value="" disabled selected hidden>Choose a Mobile Model</option>
			<option value="Galaxy M30s">Galaxy M30s</option>
			<option value="V7 Plus">V7 Plus</option>
			<option value="Zuk Z2 Plus">Zuk Z2 Plus</option>
			<option value="iPhone 12 pro max">pocoiPhone 12 pro max</option>
		</select><br /> <br />
		<br /> <label for="noOfCases">No Of Cases *</label> <input
			type="number" name="noOfCases" id="noOfCases" min="1" required
			autofocus /><br /> <br />
		<br />
			<button type="submit" class="btn btn-primary">Add to Cart</button>
	</form>
	</main>
	<script type="text/javascript">
	function booking(){
		
		let caseType=document.querySelector("#caseType").value;
		let cost=document.querySelector("#price").value;
		let mobileBrand=document.querySelector("#mobileBrand").value;
		let mobileModel=document.querySelector("#mobileModel").value;
		let noOfCases=document.querySelector("#noOfCases").value;
		const queryParameter="?caseType="+ caseType +"&price="+ cost +"&mobileBrand="+ mobileBrand +"&mobileModel="+ mobileModel +"&noOfCases="+ noOfCases;
		let url = "BookingServlet"+ queryParameter;
		fetch(url).then(res=> res.json()).then(res=>{
			let message=res;
			if(message==true)
				{
					alert("Added to cart Successfully");
					windows.location.href="viewCart.jsp";
				}
			else{
				alert("Cases not sufficient");
			}
		})
	}
	booking();
	</script>
</body>
</html>