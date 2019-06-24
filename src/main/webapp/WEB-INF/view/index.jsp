<!DOCTYPE html>
<html>

<head>
	<title>index</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Select database table</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Manufacturers"
					onclick="window.location.href='/manufacturer/list'"
					class="add-button"
			/>
			
			<input type="button" value="Notebook"
					onclick="window.location.href='/notebook/list'"
					class="add-button"
			/>
			
			<input type="button" value="Smartphone"
					onclick="window.location.href='/smartphone/list'"
					class="add-button"
			/>
			
		</div>
	</div>
	
</body>
</html>
