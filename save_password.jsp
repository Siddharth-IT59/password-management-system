<!doctype html>
<html lang="en">
<head>
  <title>Document</title>
  <link rel="stylesheet" href="css/common.css"></link>
  <link rel="stylesheet" href="css/form.css"></link>
  <script src="js/show.js"></script>
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
		<span id="text">Welcome</span>
	</div>

	<form action="save.do" method="post">
		<table id="pass_form">
			<tr>
			<th class="plat">Platform</th>
			<th class="plat">:</th>
			<th class="plat"><input class="fld" type="text" name="platform" /></th>
			</tr>
			
			<tr>
			<th class="plat">Username</th>
			<th class="plat">:</th>
			<th class="plat"><input class="fld" type="text" name="uname"/></th>
			</tr>
			
			<tr>
			<th class="plat">Password</th>
			<th class="plat">:</th>
			<th class="plat"><input class="fld" type="password" name="password" id="passInput"/></th>
			<th class="plat"><img src="images/eye.png" id="eye" onclick="showPass()"/></th>
			</tr>
		
		</table>
		
		<div id="btn_box">
			<input id="btn" type="submit" value="Save" />
		</div>
	</form>
	
		

	<div id="footer"></div>	  
	<script src="js/show.js"></script>
</body>
</html>

