<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Registered Users</title>
	<!-- Custom fonts for this template-->
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<!-- Custom styles for this template-->
	<link href="css/sb-admin-2.min.css" rel="stylesheet">
	<style>
	
		.button {
		 background-color: #4CAF50;
		 border: none;
		 color: white;
		 padding: 10px 20px;
		 text-align: center;
		 text-decoration: none;
		 display: inline-block;
		 font-size: 12px;
		 margin: 4px 2px;
		 transition-duration: 0.8s;
		 cursor: pointer;
		 font-weight: bold;
		 border-radius: 8px;
		}

		.button1 {
		 background-color: white; 
		 color: black; 
		 border: 2px solid #4CAF50;
		}
		
		.button1:hover {
		 background-color: #4CAF50;
		 color: white;
		}
		
		.button3 {
		 background-color: white; 
		 color: black; 
		 border: 2px solid #f44336;
		}
		
		.button3:hover {
		 background-color: #f44336;
		 color: white;
		}
	
	</style>
	
</head>
<body>
<div class="container-fluid">
<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Registered Users</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                   <thead>
                    <tr>
	                    <td>ID</td>
	                    <td>NAME</td>
	                    <td>ID NUMBER</td>
	                    <td>ADDRESS</td>
	                    <td>DATE OF BIRTH</td>
	                    <td>AGE</td>
	                    <td>SEX</td>
	                    <td>PHONE NUMBER</td>
	                    <td>EMAIL ADDRESS</td>
	                    <td>UPDATE</td>
	                    <td>DELETE</td>
                    </tr>
                   </thead>
                   
                   		<% 
                   		try {
                   			Class.forName("com.mysql.jdbc.Driver").newInstance();
                   			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal", "root", "");
                   			String QuerySql = " select id, name, idno, address, dob, age, sex, phone, email from registration";
                   			Statement stm = conn.createStatement();
                   			ResultSet rs = stm.executeQuery(QuerySql);
                   			while(rs.next()) {
                   				%>
                   				<tr>
                   				<td><%=rs.getInt(1) %></td>
                   				<td><%=rs.getString(2) %></td>
                   				<td><%=rs.getString(3) %></td>
                   				<td><%=rs.getString(4) %></td>
                   				<td><%=rs.getString(5) %></td>
                   				<td><%=rs.getString(6) %></td>
                   				<td><%=rs.getString(7) %></td>
                   				<td><%=rs.getString(8) %></td>
                   				<td><%=rs.getString(9) %></td>
                   				<td>
                   					<a href='edituser.jsp?u=<%=rs.getInt(1) %>' class="button button1">UPDATE</a>
                   				</td>
                   				<td>
                   					<a href='deleteuser.jsp?d=<%=rs.getInt(1) %>' class="button button3">DELETE</a>
                   				</td>
                   				</tr>
                   				<%
                   			}
                   		}
                   		catch(Exception e) {
                   			out.println("Exception : "+e.getMessage());
                   			e.printStackTrace();
                   		}
                   		
                   		%>
                   		
                   	
                   
                </table>
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

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>
</body>
</html>