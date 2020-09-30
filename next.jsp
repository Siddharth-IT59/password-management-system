<!doctype html>
<html lang="en">
<head>
<title>Document</title>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/next.css"></link>
<script src="js/home.js"></script>
</head>
<body>
  <%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate") ;
		
		if(session.getAttribute("pin")==null){
			response.sendRedirect("index.jsp") ;
		}
	%>
	
	<div id="container">
		<span><img src="images/logo.png" id="logo"/></span> <br />
		<span id="text"></span>
	
	<div id="main_body" method="post">
		<form action="show.do" method="post">
			<input class="fld" type="submit" value="Show Password"/>
		</form>
	
		<form action="logout.do" method="post">
			<input class="fld" type="submit" value="Logout"/>
		</form>
	
	</div>

	
	<div id="footer"></div>
</body>
</html>
