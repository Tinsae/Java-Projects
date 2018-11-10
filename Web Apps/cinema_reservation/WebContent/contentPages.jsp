<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <title>User Registration</title>
<link href="main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrap">
		<table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td id="logo" colspan="4"><img src="images/logo.png" alt="logo" /> <%
 	if (session.getAttribute("username") != null) {%>

					<form method="post" action="index.jsp">
						<div align="right">
							Logged in as: <label><%=session.getAttribute("username")%></label><input
								name="logoff" type="submit" value="Log Off" />
						</div>
					</form></td>		
				<%
					}
				%>
			</tr>
			
			<tr>
				<td colspan="2">
					<ul id="nav">
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About Us</a></li>
						<li><a href="schedule.jsp">Program</a></li>
						<li><a href="services.jsp">Services</a></li>
						<li><a href="contact.jsp">Contact</a></li>
						<li><a href="#">Coming soon</a></li>
						<li><a href="#">Box Office</a></li>

					</ul>
				</td>
			</tr>
			<tr>
				<td colspan="1" id="content" >
				
							
				<td rowspan="2">
				here
					</td>
						</tr>
					</table>
					
		</table>

		
	</div>
</body>
</html>
<%
	if (request.getParameter("logoff") != null) {
		session.setAttribute("username", null);
		response.sendRedirect("index.jsp");

	}

%>
