<%@page import="java.util.Set" %>
<%@page import="in.casekartin.service.CaseManagerService" %>
<%@page import="in.casekartin.model.CaseManagerModel" %>

<html>
<head>
<title>CaseKartin App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List Of Cases</h3>
		<table class="table table-bordered">
		<thead>
		<tr>
		<th>S.No</th>
		<th>Case Name</th>
		<th>Cost</th>
		</tr>
		</thead>
		<tbody>
		<!-- Scriptlets(java code for display the list of case types) -->
		<%
		Set<CaseManagerModel> caseTypes = CaseManagerService.getCaseTypes();
				int i=1;
				for(CaseManagerModel cases:caseTypes){
		%>
		<tr>
		<td><%=i %></td>
		<td><%=cases.caseType %></td>
		<td>Rs.<%=cases.cost %>/-</td>
		</tr>
		<%i++;} %>
		</tbody>
		</table>
	</main>
</body>
</html>