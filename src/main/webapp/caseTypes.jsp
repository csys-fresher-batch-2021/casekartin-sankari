<%@page import="java.util.Set"%>
<%@page import="in.casekartin.service.CaseManagerService"%>
<%@page import="in.casekartin.model.CaseManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CaseKartin App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List Of Cases</h3>
		<table class="table table-bordered">
			<caption>List of Cases</caption>
			<thead>
				<tr>
					<th id="serialnumber">S.No</th>
					<th id="casename">Case Name</th>
					<th id="cost">Cost</th>
				</tr>
			</thead>
			<tbody>
				<!-- Scriptlets(java code for display the list of case types) -->
				<%
				Set<CaseManager> caseTypes = CaseManagerService.getCaseTypes();
				int i = 1;
				for (CaseManager cases : caseTypes) {
				%>
				<tr>
					<td><%=i%></td>
					<td><%=cases.getCaseType()%></td>
					<td>Rs.<%=cases.getCost()%>/-
					</td>
				</tr>
				<%
				i++;
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>