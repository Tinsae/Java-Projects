<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>
<%
DatabaseConnector dc=new DatabaseConnector();	
dc.init();
    if (request.getParameter("submit") != null) {
        try {
            String fullName = request.getParameter("name");
            String sex = request.getParameter("sex");
            long telephone = Long.parseLong(request.getParameter("telephone"));
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String confirmPass = request.getParameter("confirmPass");
            if (password.equals(confirmPass)) {
    			dc.st.executeUpdate
    			("INSERT INTO register VALUES('" + fullName + "','" + sex + "','" + telephone + 
    					"','" + userName + "','" + password + "','standard')");
    			dc.destroy();
%>
<script>
    alert('You are registered')
</script>
<%} else {%>   
<script>
    alert('Confirm Password Correctly');
</script> 
<%}

} catch (Exception e) {%>
<script>
    alert('Error Occurred');
</script> 
<%}
    }
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <title>User Registration</title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<link href="main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrap">
		<table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td id="logo" colspan="4"><img src="images/logo.png" alt="logo" /> <%
 	if (session.getAttribute("username") != null) {%>

					<form method="post" action="index.jsp">
						<div id="logInf" align="right">
							Logged in as: <label><%=session.getAttribute("username")%></label>						</div>
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
				<td colspan="1" id="content" >
					
					<form name="NewUser"  action="" method="post">
                                  <table style="font-size: 12px">
<p align="center" style="font-size: 16px; font-weight: bolder">New User Registration</p>                                   <tr>
                                    <td width="36%">Full Name</td>
                                    <td width="64%"><input type="text" name="name" id="fullName" size="50" /></td>
                                </tr>
                                <tr>
                                    <td>Sex</td>
                                    <td><input type="radio" name="sex" value="Male" size="10" />
                                        Male
                                        <input type="radio" name="sex" value="Female" size="10" />
                                        Female</td>
                                </tr>
                                <tr>
                                    <td>Telephone</td>
                                    <td><input type="text" name="telephone"
                                               id="telephone" size="50" /></td>
                                </tr>

                                <tr>
                                    <td>User Name</td>
                                    <td><input type="text" name="userName"
                                               id="userName" size="50" /></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type="password" name="password"
                                               id="password" size="50" /></td>
                                </tr>

                                <tr>
                                    <td>Confirm Password</td>
                                    <td><input type="password" name="confirmPass"
                                               id="confirmPass" size="50" /></td>
                                </tr>
                                <tr>
                                    <td id="submitcell"></td>
                                    <td id colspan="5"><input name="submit" type="submit"  value="Submit Form" /></td>
                                </tr>                           

                            </table>
                        </td>
                </form>
							
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
