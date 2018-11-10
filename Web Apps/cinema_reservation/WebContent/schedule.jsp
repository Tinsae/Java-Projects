<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <title>User Registration</title>
        
        <script src="SpryAssets/SpryAccordion.js" type="text/javascript"></script>
<link href="SpryAssets/SpryAccordion.css" rel="stylesheet" type="text/css" />
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
    </script>						</td>
			</tr>
			
			<tr>
				
				
				<td colspan="1" id="content" >
						<br>
<p align="center" style="font-size: 16px; font-weight: bolder">Weekly Schedule
				
				<div id="Accordion1" class="Accordion" tabindex="0">
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Monday</div>
    <div class="AccordionPanelContent"> <table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Monday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
    </div>
  </div>
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Tuesday</div>
    <div class="AccordionPanelContent">  <table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Tuesday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
		</table></div>
  </div>
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Wednesday</div>
    <div class="AccordionPanelContent">
      <table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Wednesday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
    </div>
  </div>
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Thursday</div>
    <div class="AccordionPanelContent"><table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Thursday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
    </div>
  </div>
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Friday</div>
    <div class="AccordionPanelContent"><table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Friday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
		</table>     </div>
  </div>
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Saturday</div>
    <div class="AccordionPanelContent"><table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Saturday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
		</table></div>
  </div>
  <div class="AccordionPanel">
    <div class="AccordionPanelTab">Sunday</div>
    <div class="AccordionPanelContent"><table id="schedule" width="75%" border="1" align="center" cellpadding="4"
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
					DatabaseConnector dc=new DatabaseConnector();
					dc.init();
					//Statement st=dc.con.createStatement();
					String query= "SELECT schedule.Time, film.FilmTitle, film.Genre,film.Duration FROM schedule INNER JOIN film ON schedule.FilmID=film.filmID WHERE schedule.Day='Sunday'";

					ResultSet rs=dc.st.executeQuery(query);
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < 5; i++) {
							out.println("<td>");
							out.print(rs.getObject(i).toString().trim());
							out.println("</td>");
						}
						out.println("</tr>");
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
		</table></div>
  </div>
</div>
<script type="text/javascript">
var Accordion1 = new Spry.Widget.Accordion("Accordion1");
</script>


                    </td>

                </tr>

            </table>
					
							
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
