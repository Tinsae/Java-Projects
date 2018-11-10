<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>
<%
DatabaseConnector dc=new DatabaseConnector();
dc.init();	
if (request.getParameter("submit") != null) {
	//HttpSession session = request.getSession( false );
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String userType = "";
		try {
			//Statement st = dc.con.createStatement();
			ResultSet rs = dc.st.executeQuery("SELECT * FROM register WHERE UserName='"+ userName + "' AND Password='" + password + "'");
			//out.println("Welcome" + userName);
			if (dc.st.getMaxRows() <= 0) {
%>
<script type="text/javascript">
	alert('Invalid User Name or Password');
</script>
<%
	}
 		while (rs.next()) {			
 			 userType = rs.getObject(6).toString().trim();
				session.setAttribute("fullname", rs.getObject(1));
				session.setAttribute("username", userName);
				session.setAttribute("usertype", userType);
				if (userType.equals("standard")) {
					response.sendRedirect("standard.jsp");
					dc.destroy();
				} else if (userType.equals("admin")) {
					response.sendRedirect("admin.jsp");
					dc.destroy();	

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
%>
<script type="text/javascript">
	alert("unable to connect for login");
</script>
<%
	}
			
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome to Cinema Morning</title>
<link href="main.css" rel="stylesheet" type="text/css" />

<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />


<script language="JavaScript1.2" type="text/javascript">
	var howOften = 4; //number often in seconds to rotate
	var current = 0; //start the counter at 0
	var ns6 = document.getElementById && !document.all; //detect netscape 6
	// place your images, text, etc in the array elements here
	var items = new Array();
	items[0] = "<a href='link.htm' ><img src='images/p1.jpg' height='300' width='400' border='1' /></a>";
	items[1] = "<a href='link.htm' ><img src='images/image0.jpg' height='300' width='400' border='1' /></a>";
	items[2] = "<a href='link.htm'><img src='images/image1.jpg' height='300' width='400' border='1' /></a>";
	items[3] = "<a href='link.htm'><img src='images/image2.jpg' height='300' width='400' border='1' /></a>";
	items[4] = "<a href='link.htm'><img src='images/image3.jpg' height='300' width='400' border='1' /></a>";
	items[5] = "<a href='link.htm'><img src='images/image4.jpg' height='300' width='400' border='1' /></a>";
	items[6] = "<a href='link.htm'><img src='images/image5.jpg' height='300' width='400' border='1' /></a>";

	function rotater() {
		document.getElementById("placeholderdiv").innerHTML = items[current];
		current = (current == items.length - 1) ? 0 : current + 1; //increment or reset
		setTimeout("rotater()", howOften * 1000);
	}
	window.onload = rotater;
</script>
</head>
<body>
	<div id="wrap">
		<table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr >
				<td id="logo" colspan="4"><img src="images/logo.png" alt="logo" /> <%
 	if (session.getAttribute("username") != null) {
 %>
					<form method="post" action="index.jsp">
						<div id="logInf" align="right">
							Logged in as: <label><%=session.getAttribute("username")%></label>
							<!--  
							<input
								name="logoff" type="submit" value="Log Off" />
								-->
								
						</div>
					</form></td>		
				<%
					}
				%>
			</tr>
			
			<tr>
				<td colspan="2">
					<ul id="MenuBar1" class="MenuBarHorizontal">
  <li><a class="MenuBarItemSubmenu" href="index.jsp">Home</a>
    <ul>
      <li><a href="standard.jsp" class="MenuBarItemSubmenu">Standard</a>
        <ul>
          <li><a href="standard.jsp">Reserve Film</a></li>
          <li><a href="standard.jsp">Other Task</a></li>
        </ul>
      </li>
<li><a href="admin.jsp" class="MenuBarItemSubmenu">Admin</a>
        <ul>
          <li><a href="admin.jsp">Update Film</a></li>
          <li><a href="admin.jsp">Update Schedule</a></li>
        </ul>
      </li>      
    </ul>
  </li>
  <li><a href="about.jsp" class="MenuBarItemSubmenu">About Us</a>
    <ul>
      <li><a href="#">Site Owner</a></li>
      <li><a href="#">Web Designers</a></li>
      <li><a href="#">Partners</a></li>
            <li><a href="#">Developers</a></li>
      
    </ul>
  </li>
  <li><a class="MenuBarItemSubmenu" href="schedule.jsp">Program</a>
    <ul>
      <li><a class="MenuBarItemSubmenu" href="#">Day</a>
        <ul>
          <li><a href="#">Monday</a></li>
          <li><a href="#">Tuesday</a></li>
          <li><a href="#">Wednesday</a></li>
          
        </ul>
      </li>
      <li><a class="MenuBarItemSubmenu" href="#">Time</a>
        <ul>
          <li><a href="#">8:00</a></li>
          <li><a href="#">10:00</a></li>
          <li><a href="#">12:00</a></li>
          <li><a href="#">2:00</a></li>
          
 
        </ul>
      </li>
      <li><a href="#">Most Viewed</a></li>
    </ul>
  </li>
  
  <li><a href="services.jsp" class="MenuBarItemSubmenu">Services</a>
    <ul>
      <li><a href="#" class="MenuBarItemSubmenu">Current</a>
        <ul>
          <li><a href="#">Cinema Reservation</a></li>
          <li><a href="#">Customer Satisfaction</a></li>
        </ul>
                
        
        <li><a href="#">Future</a></li>
     
      </li>
    </ul>
  </li>
   <li><a href="#" class="MenuBarItemSubmenu">Box Office</a>
    <ul>
      <li><a href="#" class="MenuBarItemSubmenu">Weekly</a>
        <li><a href="#">Monthly</a></li>
     
      </li>
    </ul>
  </li>
 
  
  <li><a href="#">Contact Us</a></li>
  
   <% 	if (session.getAttribute("username") != null) {%>
  
  <li><a href="#">Account</a>
  <ul>
    <li><a href="#">View Profile</a></li>
    							
   <li>
    					<form method="post" action="index.jsp">
    <input style="font-size:12;text-align:left; border:none; display: block; cursor: pointer;background-color: #EEE;color: #333;text-decoration: none;" name="logoff" type="submit" value="Log Off" />
   </form>
    </li> 
  </ul>
  
  </li>
<%
					}
%>
  

</ul>
			<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
    </script>		
					
									</td>
			</tr>
			<tr>
				<td colspan="1" id="content2">
					<div id="placeholderdiv" align="left"></div>
				</td>
				<td>
			
					<table border="0" cellpadding="0" cellspacing="0"
						style="border-collapse: collapse" bordercolor="#111111"
						width="100%" height="1" bgcolor="#FFFFFF">
															<% 	if(session.getAttribute("username")==null){%>	
						
					
						<tr>
							<td width="100%" bgcolor="#FFFFFF" height="1" align="left"
								valign="top">
								<form name="loginForm" method="post" action="">
									<font color="#666666"	face="Comic Sans MS" size="2">LOGIN</font>
									
									<table id="mytable" border="0" cellpadding="0" cellspacing="0"
										style="border-collapse: collapse" bordercolor="#111111"
										width="100%" id="AutoNumber4" bgcolor="#F0F0F0">
										<tr>
											<td width="100%" align="center">&nbsp;
											</td>
										</tr>
										<tr>
											<td width="100%" align="center"><font color="#666666"
												face="Comic Sans MS" size="2">User id: </font> <font
												face="Arial" color="#666666"><b> <INPUT
														TYPE="text" name="userName" size="18" /></b></font></td>
										</tr>
										<tr>
											<td width="100%" align="center"><font color="#666666"
												face="Comic Sans MS"> <font size="2">Password:</font></font><font
												face="Arial" color="#666666"><b><INPUT
														TYPE="password" name="password" size="18" /></b></font><font
												color="#666666" face="Comic Sans MS"> </font><font
												face="Arial" color="#666666"><b>&nbsp;<BR>&nbsp;
												</b></font></td>
										</tr>
										<tr>
											<td width="100%" align="center"><input type="submit"
												name="submit" value="Login" />&nbsp; <INPUT TYPE="reset"
												value="Clear"></td>
										</tr>
										<tr>
											<td width="100%" align="center"><a href="user.jsp">create
													a new account</a></td>
										</tr>

									</table>
								</form>
								<%}%>
							</td>
							
						</tr>
					</table>
					<div>
					<p align="center" style="font-size: medium">
						<font color="#666666" face="Comic Sans MS">Advertisements</font>
					</p> <img src="images/cocacola.jpg" alt="" />
					</div>
				</td>
			</tr>
		</table>
		<%
			int day = (new java.util.Date().getDay());
			String dayString = "";
			if (day == 0) {
				dayString = "Sunday";
			} else if (day == 1) {
				dayString = "Monday";
			} else if (day == 2) {
				dayString = "Tuesday";
			} else if (day == 3) {
				dayString = "Wednesday";
			} else if (day == 4) {
				dayString = "Thursday";
			} else if (day == 5) {
				dayString = "Friday";
			} else if (day == 6) {
				dayString = "Saturday";
			}
		%>
		<div align="center" style="font-size: medium">
			<font color="#666666" face="Comic Sans MS"> <%=dayString + "' s Schedule"%></font>
		</div>
		
		<table width="75%" border="3" align="center" cellpadding="4"
			cellspacing="8">
			<!-- column headers -->
			<tr>
				<th bgcolor="lightblue">Time</th>
				<th bgcolor="lightblue">Title</th>
				<th bgcolor="lightblue">Genre</th>
				<th bgcolor="lightblue">Duration</th>
			</tr>

			<%
				try {
					//Statement st=dc.con.createStatement();
					ResultSet rs=dc.st.executeQuery("SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='"
							+ dayString + "'");
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
					}
				} catch (Exception e) {
					out.println("</tr>");

			%>
			<script type="text/javascript">
				alert("can't load today's schedule")
			</script>
			<%
				}
			%>
		</table>
		<br>
		<div align="center" style="font-size: medium">
			<font color="#666666" face="Comic Sans MS">Top Release Movies</font>
		</div>
		<br>
		<table border="1" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td>
						<div align="center">
							<img src="images/release1.jpg" height="100" vspace="3" width="75" alt=""><br> <font color="#006666" face="Verdana, Arial, Helvetica, sans-serif" size="1"><a
								href="#">Movie description</a></font>
						</div>
					</td>
					<td width="4"><img src="" height="136" width="4" alt=""></td>
					<td>
						<div align="center">
							<img src="images/release2.jpg" height="100" vspace="3" width="75"
								alt=""><br> <font color="#006666"
								face="Verdana, Arial, Helvetica, sans-serif" size="1"><a
								href="#">Movie description</a></font>
						</div>
					</td>
					<td width="4"><img src="images/line_products.gif" height="136"
						width="4" alt=""></td>
					<td>
						<div align="center">
							<img src="images/release3.jpg" height="100" vspace="3" width="75"
								alt=""><br> <font color="#006666"
								face="Verdana, Arial, Helvetica, sans-serif" size="1"><a
								href="#">Movie description</a></font>
						</div>
					</td>
					<td width="4"><img src="images/release4.jpg" height="136"
						width="4" alt=""></td>
					<td>
						<div align="center">
							<img src="images/release5.jpg" height="100" vspace="3" width="75"
								alt=""><br> <font color="#006666"
								face="Verdana, Arial, Helvetica, sans-serif" size="1"><a
								href="#">Movie description</a></font>
						</div>
					</td>
				</tr>
			</tbody>
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
