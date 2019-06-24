<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Update Manufacturer</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
		
		<div id="header">
			<h2></h2>
		</div>
	
	</div>

	<div id="container">
		<h3>Update Manufacturer</h3>
	
		<form:form action="updateManufacturer" modelAttribute="manufacturer" method="POST"> 
		
		<form:hidden path="id"/>
		
		<table>
			<tbody>
				<tr>
					<td><label>Brand Name:</label></td>
					<td><form:input path="brandName" /></td>
				</tr>
			
				<tr>
					<td><label>Importer:</label></td>
					<td><form:input path="importer" /></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Update" class="update"/></td>
				</tr>
			</tbody>
		</table>
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/manufacturer/list">Back to list</a>
		</p>
	</div>
</body>

</html>