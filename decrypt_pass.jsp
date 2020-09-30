<%@ page import="java.util.ArrayList"%>
<%@ page import="models.Platform" %>
<%@ page import="models.SaveToFile" %>
<!doctype html>
<html lang="en">
<head>
  <meta name="Description" content="">
  <link rel="stylesheet" href="css/common.css"></link>
  <link rel="stylesheet" href="css/show.css"></link>
<title>Document</title>
</head>

<body>
	<%	
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate") ;
		if(session.getAttribute("newPin")==null){
			response.sendRedirect("index.jsp") ;
		}

		ArrayList<Platform> rec = (ArrayList)session.getAttribute("rec") ;
		ArrayList<String> passList = (ArrayList)session.getAttribute("passList") ;
		
		int i = 0 ;
	%>

	<div id="container">
		<span><img src="images/logo.png" id="logo"/></span> <br />
		<span id="text">Decrypted List</span>
	</div>
	
	<table id="recs">
		<tr id="box">
		<th id="head" class="cmn">ID</th>
		<th id="ptm" class="cmn">Platform</th>
		<th id="unm" class="cmn">Username</th>
		<th id="pass" class="cmn">Password</th>
		</tr>
			
		<% for(Platform plt : rec) { %>
		<tr>
			<td id="hd" class="cm"><%= plt.getPlatformId() %></td>
			<td id="pm" class="cm"><%= plt.getPlatformName() %></td>
			<td id="um" class="cm"><%= plt.getUserName() %></td>
			<td id="ps" class="cm"><%= passList.get(i) %></td>
			<% i++; %>
		</tr>
		<% } %>
		
	

	<form action="logout.do" method="post">
		<input class="fld" type="submit" value="Logout"/>
	</form>
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<form action="save_password.jsp" method="post">
		<input class="fld" type="submit" value="Add Password"/>
	</form>
	
	</table>
	
	 <!-- <div id="footer"></div> --> 
</body>

</html>
