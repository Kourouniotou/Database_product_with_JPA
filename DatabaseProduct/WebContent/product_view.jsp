<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"/>
<title>Import Result</title>
</head>

<body>
	<br><br><br>
	<h1>Your insertion was successfull</h1>
	<br><br><br><br><br>
	<h2><b>
	<%out.print(request.getParameter("barcode"));%>
	<%out.print(request.getParameter("name"));%>
	<%out.print(request.getParameter("color"));%>
	<%out.print(request.getParameter("description"));%>
	</b></h2>
</body>
</html>