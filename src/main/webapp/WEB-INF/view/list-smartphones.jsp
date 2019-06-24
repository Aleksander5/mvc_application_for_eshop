<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Smartphone list</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Smartphone database table</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Back"
					onclick="window.location.href='/'; return false;"
					class="add-button"
			/>
		
			<input type="button" value="Add Smartphone"
					onclick="window.location.href='showFormForAddSmartphone'; return false;"
					class="add-button"
			/>
			
			<table>
			
				<tr>
					<th>Model</th>
					<th>Screen size</th>
					<th>RAM/ROM memory</th>
					<th>Operating System</th>
					<th>Colour</th>
					<th>Manufacturer</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempSmartphone" items="${smartphones}">
				
					<c:url var="updateLink" value="/smartphone/showFormForUpdate">
						<c:param name="smartphoneId" value="${tempSmartphone.id}" />
					</c:url>
				
					<c:url var="deleteLink" value="/smartphone/delete">
						<c:param name="smartphoneId" value="${tempSmartphone.id}" />
					</c:url>
				
						<tr>
							<td> ${tempSmartphone.model} </td>
							<td> ${tempSmartphone.screenSize} </td>
							<td> ${tempSmartphone.ramRom} </td>
							<td> ${tempSmartphone.operatingSystem} </td>
							<td> ${tempSmartphone.colour} </td>
							<td> ${tempSmartphone.manufacturer.brandName} </td>
							
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