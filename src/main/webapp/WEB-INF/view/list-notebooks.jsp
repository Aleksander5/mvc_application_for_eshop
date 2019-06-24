<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Notebook list</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Notebooks database table</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Back"
					onclick="window.location.href='/'; return false;"
					class="add-button"
			/>
		
			<input type="button" value="Add Notebook"
					onclick="window.location.href='showFormForAddNotebook'; return false;"
					class="add-button"
			/>
			
			<table>
			
				<tr>
					<th>Model</th>
					<th>Series</th>
					<th>Screen size</th>
					<th>Processor model</th>
					<th>RAM memory</th>
					<th>Hard drive</th>
					<th>Manufacturer</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempNotebook" items="${notebooks}">
				
					<c:url var="updateLink" value="/notebook/showFormForUpdate">
						<c:param name="notebookId" value="${tempNotebook.id}" />
					</c:url>
				
					<c:url var="deleteLink" value="/notebook/delete">
						<c:param name="notebookId" value="${tempNotebook.id}" />
					</c:url>
					
					<tr>
						<td> ${tempNotebook.model} </td>
						<td> ${tempNotebook.series} </td>
						<td> ${tempNotebook.screenSize} </td>
						<td> ${tempNotebook.processorModel} </td>
						<td> ${tempNotebook.ram} </td>
						<td> ${tempNotebook.hardDrive} </td>
						<td> ${tempNotebook.manufacturer.brandName} </td>
						
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