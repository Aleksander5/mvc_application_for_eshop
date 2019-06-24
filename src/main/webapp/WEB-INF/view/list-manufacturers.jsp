<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Manufacturers list</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Manufacturer database table</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Back"
					onclick="window.location.href='/'; return false;"
					class="add-button"
			/>
		
			<input type="button" value="Add Manufacturer"
					onclick="window.location.href='showFormForAddManufacturer'; return false;"
					class="add-button"
			/>
			
			<table>
			
				<tr>
					<th>Brand name</th>
					<th>Importer</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempManufacturer" items="${manufacturers}">
				
					<c:url var="updateLink" value="/manufacturer/showFormForUpdate">
						<c:param name="manufacturerId" value="${tempManufacturer.id}" />
					</c:url>
				
					<c:url var="deleteLink" value="/manufacturer/delete">
						<c:param name="manufacturerId" value="${tempManufacturer.id}" />
					</c:url>
				
					<tr>
						<td> ${tempManufacturer.brandName} </td>
						<td> ${tempManufacturer.importer} </td>
						
						<td> 
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
							
					</tr>
				
				</c:forEach>
				
			</table>
			
		</div>	
	</div>
	
</body>

</html>