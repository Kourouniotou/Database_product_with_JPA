<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"/>
<title>Import Result</title>
</head>

<body>
	<br><br><br><br><br>
	<%out.print("<h2><b>Sorry, barcode "+request.getParameter("barcode")+" is already in use");%>
	<br><br>
</body>
</html>