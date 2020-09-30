<%@ page import="java.util.ArrayList"%>
<%@ page import="models.Platform" %>
<!doctype html>
<html lang="en">
<head>
  <meta name="Description" content="">
  <link rel="stylesheet" href="css/common.css"></link>
  <link rel="stylesheet" href="css/show.css"></link>
<title>Document</title>
</head>

<body>
	<%	ArrayList<Platform> platform = (ArrayList)request.getAttribute("records") ; %>

	<div id="container">
		<span><img src="images/logo.png" id="logo"/></span> <br />
		<span id="text">Encrypted List</span>
	</div>
	
	<table id="recs">
		<tr id="box">
		<th id="head" class="cmn">ID</th>
		<th id="ptm" class="cmn">Platform</th>
		<th id="unm" class="cmn">Username</th>
		<th id="pass" class="cmn">Password</th>
		</tr>
		<% for(Platform plt : platform) { %>
		<tr>
			<td id="hd" class="cm"><%= plt.getPlatformId() %></td>
			<td id="pm" class="cm"><%= plt.getPlatformName() %></td>
			<td id="um" class="cm"><%= plt.getUserName() %></td>
			<td id="ps" class="cm"><%= plt.getPassword() %></td>
		</tr>
		<% } %>
	<form action="logout.do" method="post">
			<input class="fld" type="submit" value="Logout"/>
	</form>
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<form action="decrypt.do" method="post">
			<input class="fld" type="password" placeholder="Enter PIN to confirm" name="pass"/>
			<input class="fld" type="submit" value="Decrypt"/>
	</form>
	
	</table>
	
	 <!-- <div id="footer"></div> --> 
</body>

</html>
