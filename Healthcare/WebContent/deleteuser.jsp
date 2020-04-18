<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

>
<%
String id=request.getParameter("d");
int no = Integer.parseInt(id);
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal", "root", "");
Statement stat = conn.createStatement();
stat.executeUpdate("delete from registration where id="+no+"");

response.sendRedirect("displayuser.jsp");
%>

<script>
	$(document).ready(function) {
		swal({
			  title: "Are you sure?",
			  text: "Once deleted, you will not be able to recover this imaginary file!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			    swal("Poof! Your imaginary file has been deleted!", {
			      icon: "success",
			    });
			  } else {
			    swal("Your imaginary file is safe!");
			  }
			});
	}
</script>