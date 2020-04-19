package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {
	//A common method to connect to the DB
			public Connection connect()
			 {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");

			 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/punsala", "root", "");
			 
			//For testing
			 System.out.print("Successfully connected"); 
			 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
			 }
			
			
			
			public String insertDoctorDetails(String Phone, String Address, String Specialization, String Email, String Name)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
			 // create a prepared statement
			 String query = " insert into doctors(`DocID`,`DocPhone`,`DocAddress`,`DocSpecialization`,`DocEmail`,`DocName`)"
			 + " values (?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, Phone);
			 preparedStmt.setString(3, Address);
			 preparedStmt.setString(4, Specialization);
			 preparedStmt.setString(5, Email);
			 preparedStmt.setString(6, Name);
			
			 
			// execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Inserted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while inserting the Doctor";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			
			
			public String readDoctorDetails()
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 // Prepare the html table to be displayed
			 output = "<table border=\"1\"><tr>Doctor ID<th>  Phone </th><th> Address </th><th> Specialization </th><th> Email </th><th> Name </th><th>Update</th><th>Remove</th></tr>";
			 String query = "select * from doctors";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
				 String DID = Integer.toString(rs.getInt("DocID"));
				 String Phone = rs.getString("DocPhone");
				 String Address = rs.getString("DocAddress");
				 String Specialization = rs.getString("DocSpecialization");		
				 String Email = rs.getString("DocEmail");
				 String Name = rs.getString("DocName");
				
			 // Add into the html table
				 output += "<tr><td>" + Phone + "</td>";
				 output += "<td>" + Address + "</td>";
				 output += "<td>" + Specialization + "</td>";
				 output += "<td>" + Email + "</td>";
				 output += "<td>" + Name + "</td>";
				 
			 // buttons
			 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\">"
			 + "<input name=\"DID\" type=\"hidden\" value=\"" + DID
			 + "\">" + "</form></td></tr>";
			 }
			 con.close();
			 // Complete the html table
			 output += "</table>";
			 }
			 catch (Exception e)
			 {
			 output = "Error while reading the Doctor";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 
			
		

			public String updateDoctorDetails(String ID, String Phone, String Address, String Specialization, String Email, String Name)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE doctors SET DocPhone=?,DocAddress=?,DocSpecialization=?,DocEmail=?,DocName=?WHERE DocID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, Phone);
			 preparedStmt.setString(2, Address);
			 preparedStmt.setString(3, Specialization);
			 preparedStmt.setString(4, Email);
			 preparedStmt.setString(5, Name);
			 preparedStmt.setInt(6,Integer.parseInt(ID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while updating the Doctor";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			
			
		
			
			public String deleteDoctorDetails(String ID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from doctors where DocID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(ID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the Doctor";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 
	}
