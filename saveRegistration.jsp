<%--
    Document   : saveRegistration
    Created on : 
    Author     : vyakhya
--%>
<%@ page language="java" %>
<%@ page import="java.sql.*"%>

<!-- Import the data connectivity to save your data in tables.  -->

<html>
    <head>
             <title>Failed</title>
             <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
             <meta http-equiv="refresh" content="0;URL=http://localhost:8080/saveRegistration.jsp">
             </head>
             <body bgcolor="#CCCCFF" text="#000000">

<%
    session.setAttribute("mysession", request.getParameter("eno"));
// comment
// create connection
		Connection con=null;
		Statement state=null;
		ResultSet result=null;
                PreparedStatement ps=null;

    // try is exception handling codes, error dealing
	try
		{

            String connectionURL = "jdbc:mysql://localhost:8080/mydata";
            	// call the class  "sun.jdbc.odbc.JdbcOdbcDriver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
			// :MYCONN  is declared at Admistrative tool
        con = DriverManager.getConnection(connectionURL, "root", "");
// now create the statement
			state=con.createStatement();
                       
// get the data from the previous page with help of request keyword.

	String uname=request.getParameter("textfield");
		String eno=request.getParameter("textfield2");
		String event=request.getParameter("textfield3");
		String eid=request.getParameter("textfield4");
	String phone=request.getParameter("textfield5");
                 String dob1 = request.getParameter("select1");
                 String dob2= request.getParameter("select2");
                 String dob3 = request.getParameter("select3");
	String uemail=request.getParameter("textfield7");
	String address=request.getParameter("text");
	String eamt=request.getParameter("textfield9");
System.out.println(eno);
if((uemail.length()==0)||(eno.length()==0)||(uname.length()==0))
            {

            
           }

            else
             {



// create insert statement
             

String str="INSERT INTO reg VALUES('"+uname+"','"+eno+"','"+event+"',"+eid+","+phone+","+dob1+",'"+dob2+"',"+dob3+",'"+uemail+"','"+address+"',"+eamt+")";
                        ps= con.prepareStatement(str);

// execute
     int i=ps.executeUpdate();
     if(i==1)
       {
        
         }

%>




<p>&nbsp; </p>

<%

// <p><font size="4">The Information has been added successfully.</font></p>
             }
	}
        catch(Exception e)
		{
			out.println(e);
		}
		
    finally
      {
response.sendRedirect("payment_gateway.html");
     con.close();
    }
   
%>
</body>
</html>
