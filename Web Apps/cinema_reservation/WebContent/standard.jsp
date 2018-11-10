<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,Utilities.*"%>
<%
	LinkedList<Integer> ll = new LinkedList<Integer>();
    for (Integer i = 0; i <= 9; i++) {
        ll.add(i);
    }
    String ticket = "Mor-";
    Collections.shuffle(ll);
    Iterator it = ll.iterator();
    while (it.hasNext()) {
        ticket = ticket + it.next().toString();
    }
    session.setAttribute("ticketNo", ticket);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <title>User Registration</title>
        <script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <script src="selectDay.js"></script>
   
        <script type="text/javascript">
	function calculatePrice() {
		var rate = 30;
		var x = document.getElementById("noOfTickets").selectedIndex;
		if (x == 1)
			document.getElementById("priceCell").innerHTML = "ETB " + x * rate;
		else if (x == 2)
			document.getElementById("priceCell").innerHTML = "ETB " + x * rate;
		else if (x === 3)
			document.getElementById("priceCell").innerHTML = "ETB " + x * rate;
		else if (x === 4)
			document.getElementById("priceCell").innerHTML = "ETB " + x * rate;
		else
			document.getElementById("priceCell").innerHTML = "ETB ??";
	}
	
	function setTitle(str)
	{
		var item=document.getElementById(str).innerHTML;
		document.getElementById("selectedTitle").value=item;
	}
	
</script>
        
<link href="main.css" rel="stylesheet" type="text/css" />
</head>
<body>
                 <%if(session.getAttribute("username")!=null){%>

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
			<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
    </script>		
				</td>
			</tr>
			<tr>
				<td colspan="1" id="content" >
					<form name="mainForm" action="ticket.jsp" method="post">
					
						<table  style="background-color: #CCCCB2; font-size:12" width=80% border="1" align="center">
							<p align="center" style="font-size: 16px; font-weight: bolder">Reserve
								Film</p>
							<tr>
								<td width="auto">Day</td>
								<td width="auto" height="auto">
								<select name="daySelection" size="1" id="daySelection" onchange="showSchedule(this.value)">
										<option value="-1" selected="selected">Select..</option>
										<option value="Monday">Monday</option>
										<option value="Tuesday">Tuesday</option>
										<option value="Wednesday">Wednesday</option>
										<option value="Thursday">Thursday</option>
										<option value="Friday">Friday</option>
										<option value="Saturday">Saturday</option>
										<option value="Sunday">Sunday</option>
								</select> 
							</tr>
							</table>
		<br/>
		<div style="font-size:12">
		You Selected: <input style="border:none; font-weight:bolder" name="selectedTitle" type="text" id="selectedTitle" value="Noting"/>
		</div>
		<table id="resultTable" style="font-size:12;" width="75%" border="1" align="center" cellpadding="4" cellspacing="4">
		<br></br>
																			
		</table>				
								<br></br>
				
		<table id=schedule style="font-size:12" cellspacing=8>		
					
					<tr>
						<td>No of Tickets</td>		
						<td><select length=10 name="noOfTickets" id="noOfTickets"
							onchange="calculatePrice()">
								<option  value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
						</select></td>
					</tr>
					<tr>
						<td>Price</td>
						<td id="priceCell">###</td>
					</tr>
					<tr>
						<td>Payment Type</td>
						<td><select name="paymentType" id="paymentType">
								<option value="Mobile ">Sim Card</option>
								<option value="Visa Card">Visa Card</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" id="reserveSubmit" name="reserveSubmit" value="Submit Form" /></td>
					</tr>
				
			
			</form>
		</table>
					
					</td>		
				<td rowspan="2">
				here
					</td>
						</tr>
					</table>
					
		</table>

		
	</div>
	<%
		} else {
	%>
	<script>
		var r = confirm("You have to Login First");
		if (r == true)
			window.open('index.jsp');
	</script>
	<%
		}
	%>
</body>
</html>
<%
	if (request.getParameter("logoff") != null) {
		session.setAttribute("username", null);
		response.sendRedirect("index.jsp");

	}

%>
