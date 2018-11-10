<%@page import="java.sql.*, java.util.*, Utilities.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <style>
            #mytable
            {
                border-width: thin; 
                border-style:dashed;
                width: 24%;
                height: 9%;
            }
            #mytable td
            {
                border-style:double;
                border-width: thin;
                background-image:url('images/tickpattern2.jpg');
                font-family:monospace;
                font-size:14;
            }
        </style>
        <script language="JavaScript">
            function printPage() {
                if (document.all) {
                    document.all.divButtons.style.visibility = 'hidden';
                    window.print();
                    document.all.divButtons.style.visibility = 'visible';
                } else {
                    document.getElementById('divButtons').style.visibility = 'hidden';
                    window.print();
                    document.getElementById('divButtons').style.visibility = 'visible';
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Displaying Ticket</title>
    </head>
    <body>
        
         <%if(session.getAttribute("username")!=null){%>
                   
        <table id="mytable" cellpadding="2" cellspacing="2">
            <tr>
            <td colspan=2 height="40%" width="40%"><img src="images/logo.png" width="100%" height="100%" alt="logo" /></td>
        </tr>
        <tr>
        <td width="30%" height="10%">Ticket No.</td>
        <td><%=session.getAttribute("ticketNo")%></td>
    </tr>
    <tr>
    <td width="26%" height="10%">Day/Time</td>
    <td><%=request.getParameter("daySelection") + "-" + request.getParameter("radiogroup1")%></td>
</tr>
<tr>
<td width="26%" height="10%">Film Title</td>
<td><%=request.getParameter("selectedTitle")%></td>
</tr>
</table>
<div align="left" id="divButtons"> 
    <input  type="image" onclick="printPage()"  src="images/print4.jpg">
    <a href="standard.jsp">Back</a>
</div>
          <%}
                 else{ 
               %>
               <script>
                   var r=confirm("You have to Login");
               if(r==true)
               window.open('index.jsp');
               </script>
               <%}%>
               
               
</body>
</html>
<%
    try {
        if (request.getParameter("reserveSubmit") != null)
        {
            if(session.getAttribute("username")!=null){
        		DatabaseConnector dc=new DatabaseConnector();	
        		dc.init();
            String day = request.getParameter("daySelection");
            String time = request.getParameter("radiogroup1");
            String theticket = request.getParameter("noOfTickets");
            String payment = request.getParameter("paymentType");
			
			Statement st = dc.con.createStatement();
            int k = st.executeUpdate("INSERT INTO reserve(UserName,Day,Time,NumberOfTickets,PaymentType) VALUES('" + session.getAttribute("username") + "','" + day + "','" + time + "','" + theticket + "','" + payment + "')");
            if (k > 0) {
%>
<script>
    alert('Film Successfully Reserved');</script>
    <%
            }  }         
    }
    } catch (Exception e) {
    %>
<script>
    alert(<%=e.getMessage()%> + 'some error occurred!!');</script>
    <%}%>

