<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Update Notebook</title>
	
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
		<h3>Update Notebook</h3>
	
		<form:form action="updateNotebook" modelAttribute="notebook" method="POST"> 
		
		<form:hidden path="id"/>
		
		<table>
			<tbody>
				<tr>
					<td><label>Model:</label></td>
					<td><form:input path="model" /></td>
				</tr>
			
				<tr>
					<td><label>Series:</label></td>
					<td><form:input path="series" /></td>
				</tr>
				
				<tr>
					<td><label>Screen size:</label></td>
					<td><form:input path="screenSize" /></td>
				</tr>
				
				<tr>
					<td><label>Processor model:</label></td>
					<td><form:input path="processorModel" /></td>
				</tr>
				
				<tr>
					<td><label>Ram:</label></td>
					<td><form:input path="ram" /></td>
				</tr>
				
				<tr>
					<td><label>Hard Drive:</label></td>
					<td><form:input path="hardDrive" /></td>
				</tr>
				
				<tr>
						
					<td><label>Manufacturer:</label></td>
					
					<td>
						<form:select path="manufacturerId">
						
							<form:option value="${notebook.manufacturer.id}"><c:out value="${notebook.manufacturer.brandName}"></c:out></form:option>
						
							<c:forEach var="tempManufacturer" items="${manufacturers}">
									<form:option value="${tempManufacturer.id}"><c:out value="${tempManufacturer.brandName}"/></form:option>
							</c:forEach>
								
						</form:select>
					</td>
					
						
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
			<a href="${pageContext.request.contextPath}/notebook/list">Back to list</a>
		</p>
	</div>
</body>

</html>