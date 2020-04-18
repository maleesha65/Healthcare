<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Update User</title>
	<!-- Custom fonts for this template-->
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<!-- Custom styles for this template-->
	<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>


<body class="bg-gradient-primary">


<%
String host = "jdbc:mysql://localhost:3306/portal";
Connection conn = null;
Statement stat = null;
ResultSet res = null;
PreparedStatement stmt = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal", "root", "");
%>

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Update User Details</h1>
              </div>
              <form action="edituser.jsp" method="post">
              <%
              try {
         		stat = conn.createStatement();
         		String u = request.getParameter("u");
         		int num = Integer.parseInt(u);
         		String data = "select * from registration where id="+num+"";
         		res = stat.executeQuery(data);
         		while(res.next()) {
         		%>
         		<input type="hidden" name="id" value="<%=res.getString("id") %>">
              
              
              	<div class="form-group">
                  <input type="text" class="form-control form-control-user" name="name" value="<%=res.getString(2) %>">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" name="address" value="<%=res.getString(3) %>">
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="idno" value="<%=res.getString(4) %>">
                  </div>
                  <div class="col-sm-6">
                    <input type="date" class="form-control form-control-user" name="dob" value="<%=res.getString(5) %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="age" value="<%=res.getString(6) %>">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" name="sex" value="<%=res.getString(7) %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="phone" value="<%=res.getString(8) %>">
                  </div>
                  <div class="col-sm-6">
                    <input type="email" class="form-control form-control-user" name="email" value="<%=res.getString(9) %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" name="password" value="<%=res.getString(10) %>">
                  </div>
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" name="compassword" value="<%=res.getString(11) %>">
                  </div>
                  <hr><hr>
                </div>
               
                <hr>
                <input type="submit" class="btn btn-primary btn-user btn-block" value="Update Registration">
                <br>
                <hr>
                <a href="displayuser.jsp" class="btn btn-primary btn-user btn-block">Back</a>
                  
                <hr>
              </form>
              
              
               <%
              }
			    	conn.close();
			    	}
			    	catch (Exception e) {
			    		e.printStackTrace();
			    	}
			    	
			    %>
              <hr>
              
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

</body>
</html>

<%
		  String a = request.getParameter("id");
		  String b = request.getParameter("name");
		  String c = request.getParameter("idno");
		  String d = request.getParameter("address");
		  String e = request.getParameter("dob");
		  String f = request.getParameter("age");
		  String g = request.getParameter("sex");
		  String h = request.getParameter("phone");
		  String i = request.getParameter("email");
		  String j = request.getParameter("password");
		  String k = request.getParameter("compassword");
		  if(a!=null && b!=null && c!=null && d!=null && e!=null && f!=null && g!=null && h!=null && i!=null && j!=null && k!=null) {
			  String query = "update registration set name=?, idno=?, address=?, dob=?, age=?, sex=?, phone=?, email=?, password=?, compassword=? where id="+a+"";
			  stmt = conn.prepareStatement(query);
			  stmt.setString(1, b);
			  stmt.setString(2, c);
			  stmt.setString(3, d);
			  stmt.setString(4, e);
			  stmt.setString(5, f);
			  stmt.setString(6, g);
			  stmt.setString(7, h);
			  stmt.setString(8, i);
			  stmt.setString(9, j);
			  stmt.setString(10, k);
			  stmt.executeUpdate();
			  response.sendRedirect("displayuser.jsp");
			  
			  
		  }

%>
