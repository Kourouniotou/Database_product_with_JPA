<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"/>
<title>Products of Database</title>
</head>

<body>
	<br><br>
	<h1><b>
	<%
		List listProduct = (List)request.getAttribute("listProduct");
		Iterator it = listProduct.iterator();
		int i=0;
		while(it.hasNext()){
			i++;
			out.print("<br>"+i+"."+" "+" "+it.next());
		}
	%>
	</b></h1>
</body>
</html>