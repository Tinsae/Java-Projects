<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>
<%
	DatabaseConnector dc = new DatabaseConnector();
	dc.init();
	if (request.getParameter("filmSubmit") != null) {
		String filmTitle = request.getParameter("filmTitle");
		String genre = request.getParameter("genre");
		String duration = request.getParameter("duration");
		String rank = request.getParameter("rank");
		try {

			int i = dc.st
					.executeUpdate("INSERT INTO film(FilmTitle,Genre,Duration,Rank) VALUES('"
							+ filmTitle
							+ "','"
							+ genre
							+ "','"
							+ duration + "','" + rank + "')");
			if (i > 0) {%>
			<script>
			alert("Film Successfully Inserted");
			</script>
			<% 
			} else {%>
				<script>
			alert("Film Not Inserted");
			</script>
			<% 
			}
	} catch (Exception e) {
			e.printStackTrace();
		}
	}

	if (request.getParameter("scheduleSubmit") != null) {
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String filmID = request.getParameter("filmID");
		try {
			int i = dc.st.executeUpdate("INSERT INTO schedule VALUES('"
					+ day + "','" + time + "','" + filmID + "')");
			if (i > 0) {
%>
<script>
	alert("new schedule inserted")
</script>
<%
	} else {
%>
<script>
	alert("new schedule not inserted");
</script>
<%
	}
		} catch (Exception e) {
%>
<script>
	alert("Error!!");
</script>
<%
	}
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <title>User Registration</title>
        <script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
        <link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
        
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <script src="selectDay.js"></script>
   
       
        
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
							Logged in as: <label><%=session.getAttribute("username")%></label>
							<input style="background-color:#CCC; font-size:10px; border:none" name="logoff" type="submit" value="Log Off" />
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
				</td>
			</tr>
			<tr>
				<td colspan="1" id="content" >
				<br>
				<br>
				<div id="TabbedPanels1" class="TabbedPanels">
  <ul class="TabbedPanelsTabGroup">
    <li class="TabbedPanelsTab" tabindex="0">Manage Films</li>
    <li class="TabbedPanelsTab" tabindex="0">Manage Schedules</li>
    <li class="TabbedPanelsTab" tabindex="0">Manage Halls</li>
</ul>
  <div class="TabbedPanelsContentGroup">
    <div class="TabbedPanelsContent">
     <form name="Add new Film" action="" method="post">
			
		<table id=schedule style="font-size:12" cellspacing=8>		
							<tr>
								<td width="36%" nowrap="nowrap">Film Title</td>
								<td width="64%"><input type="text" name="filmTitle"
									id="filmTitle" size="30" /></td>
							</tr>
							<tr>
								<td>Genre</td>
								<td><select name="genre" id="genre">
										<option selected>Action</option>
										<option>Romance</option>
										<option>Suspense</option>
										<option>Horror</option>
										<option>Comedy</option>
										<option>Tragedy</option>
										<option>Other</option>

								</select></td>
							</tr>
							<tr>
								<td>Duration</td>
								<td><input type="text" name="duration" id="duration"
									size="10" /></td>
							</tr>
							<tr>
								<td>Rank</td>
								<td><select name="rank" id="rank">
										<option selected>A</option>
										<option>B</option>
										<option>C</option>
								</select></td>
							</tr>
							<tr>
								<td>														<input style="background-color:#CCC; font-size:12px; border:none" name="filmReset" type="reset" value="Reset" />
								</td>
								<td>
																						<input style="background-color:#CCC; font-size:12px; border:none" name="filmSubmit" type="submit" value="Send" />
						
									</td>
							</tr>
						</table>
				
			</form>
    
    
    
    
    </div>
    <div class="TabbedPanelsContent">
    
    		<form name="Add new Schedule" method="post">

		<table id=schedule style="font-size:12" cellspacing=8>		
						<tr>
							<td width="36%" nowrap="nowrap">Day</td>
							<td width="64%"><select name="day">
									<option>Monday</option>
									<option>Tuesday</option>
									<option>Wednesday</option>
									<option>Thursday</option>
									<option>Friday</option>
									<option>Saturday</option>
									<option>Sunday</option>
							</select></td>
						</tr>
						<tr>
							<td>Time</td>
							<td><input type="text" name="time" id="time" size="10" /></td>
						</tr>
						<tr>
							<td>Film Title</td>
							<td><select name="filmID" id="filmID">
									<c:forEach var="row" items="${films.rows}">
										<option value="${row.FilmID}">${row.FilmTitle}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>							<input style="background-color:#CCC; font-size:12px; border:none" name="scheduleSubmit" type="reset" value="Reset" />
							</td>
							<td colspan="5">
														<input style="background-color:#CCC; font-size:12px; border:none" name="scheduleSubmit" type="submit" value="Go" />
							
							
							</td>
						</tr>
					</table>
			</form>
    
    
    
    
    
    
    </div>
    <div class="TabbedPanelsContent">HERE</div>
</div>
</div>


	
			<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
  

</script>				
				
									</td>		
				<td rowspan="2">
				here
					</td>
						</tr>
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
