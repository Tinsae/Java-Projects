<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <title>User Registration</title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<link href="main.css" rel="stylesheet" type="text/css" />
  <script language="javascript">
function checkemail(str) {
	var r1 = new RegExp("(@.*@)|(\\.\\.)|(@\\.)|(^\\.)");
  var r2 = new RegExp("^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,3}|[0-9]{1,3})(\\]?)$");
  var isOK = !r1.test(str) && r2.test(str);
  if (!isOK)
  	alert('Invalid Email!');
  return isOK;
 }
</script>
</head>
<body>
	<div id="wrap">
		<table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td id="logo" colspan="4"><img src="images/logo.png" alt="logo" /> <%
 	if (session.getAttribute("username") != null) {%>

					<form method="post" action="index.jsp">
						<div id="logInf" align="right">
							Logged in as: <label><%=session.getAttribute("username")%></label>
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


</ul>
			<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
    </script>		
				</td>
			</tr>
			
			<tr>
				<td colspan="1" id="content" >
					<br>
<p align="center" style="font-size: 16px; font-weight: bolder">Contact Us Here
								</p>				
					<table  cellpadding="0" cellspacing="0" style="border-collapse: collapse"  width="100%" id="AutoNumber1" height="234">
    <tr>
      <td width="100%" height="234"  align="center" valign="top">
      <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="40%" id="AutoNumber2" bgcolor="#FFFFFF" >
        <tr>
          <td width="100%">
          <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber3" height="1" bgcolor="#FFFFFF" >

            <tr>
              <td width="100%" bgcolor="#FFFFFF" height="1" align="left" valign="top">
<form METHOD="post" 
      ACTION="http://localhost:8080/myapp/contactservlet"
      Name="myForm" action="#" onSubmit="return checkemail(this.f2.value)">
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber4" bgcolor="#F0F0F0" height="154">
  <tr>
    <td width="100%" align="center" height="127">&nbsp;<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber5" height="99">
      <tr>
        <td width="100%" height="23">
        <font face="Comic Sans MS" color="#666666" size="2">&nbsp; Name : </font>
    <font face="Arial" color="#666666"><b>
<INPUT TYPE="text" name="f1" size="26"/></b></font></td>
      </tr>
      <tr>
        <td width="100%" height="43">
        <font face="Comic Sans MS" size="2" color="#666666">&nbsp; Email : </font>
    <font face="Arial" color="#666666"><b>
<INPUT TYPE="text" name="f2" size="26"/></b></font></td>
      </tr>
      <tr>
        <td width="100%" height="33">
        <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber6">
          <tr>
            <td width="100%">
        <font face="Comic Sans MS" size="2" color="#666666">Comments :</font></td>
          </tr>
        </table>
        <p align="center">
        <font face="Comic Sans MS" size="2" color="#666666">&nbsp;</font><font face="Arial" color="#666666"><textarea name="f3" rows="15" cols="50"></textarea></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td width="100%" align="center" height="27">

<input type="submit" value="Send"/>&nbsp; <INPUT TYPE="reset" value="Clear"></td>

  </tr>
</table>
					
                        </td>
        
							
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
