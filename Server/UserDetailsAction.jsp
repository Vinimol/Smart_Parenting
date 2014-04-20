<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
    
 <%
	try {
		//String myname = request.getParameter("myid");
		String myusername = request.getParameter("user");
		out.println(myusername);
		String myid = request.getParameter("myid");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent", "root","jilsa");
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from registration where register_id='"+myid+"'and approvalflag='"+1+"'");
		
		
		if(rs.next())
		{
			String registerid=rs.getString("register_id");
			String address=rs.getString("address");
			String phone=rs.getString("phone");
			String email=rs.getString("email");
			String loginid=rs.getString("login_id");
			String approvalflag=rs.getString("approval_flag");
			String name=rs.getString("name");
			}
	}
catch (Exception e)
	{
		
	
	}
	
	%> 