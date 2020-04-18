package com.appointment.service;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.appointment.model.Appointment;
import com.appointment.utils.DBconnection;

public class appointmentService {
	public String insertAppointment(Appointment app) {

		DBconnection connection = new DBconnection();
        String output = "";

        try {
            Connection con = connection.getConnection();

            if (con == null) {
                return "Error while connecting to the database for inserting.";
            }

            String query = " insert into apptable (`appID`,`patientName`,`phoneNo`,`email`,`address`,`issue`,`paymentID`,`docID`,`patientID`,`date`)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, app.getAppID());
            preparedStmt.setString(2, app.getPatientName());
            preparedStmt.setInt(3, app.getPhoneNo());
            preparedStmt.setString(4, app.getEmail());
            preparedStmt.setString(5, app.getAddress());
            preparedStmt.setString(6, app.getIssue());
            preparedStmt.setInt(7, app.getPaymentID());
            preparedStmt.setInt(8, app.getDocID());
            preparedStmt.setInt(9, app.getPatientID());
            preparedStmt.setString(10, app.getDate());
           


            preparedStmt.executeUpdate();
            con.close();
            output = "Inserted successfully";
            System.out.println("Doctor inserted successfully");

        } catch (Exception e) {
            output = "Error while inserting doctor details.";
            System.out.println("Error while inserting doctor");
            System.out.println(e.getMessage());
        }
        return output;
    }

    public String readAppointment() {
        DBconnection connection = new DBconnection();
        StringBuilder output = new StringBuilder();
        try {
            Connection con = connection.getConnection();

            if (con == null) {
                return "Error while connecting to the database for reading.";
            }

            output = new StringBuilder("<table border=\"1\"><tr><th>Appointment ID</th><th>patientName</th><th>Phone No</th><th>Email</th>" +
                    "<th>Address</th><th>message</th><th>payment ID</th><th>Doc ID</th><th>Patient ID</th>" +
                    "<th>Date</th><th>Update</th><th>Remove</th></tr>");
            String query = "select * from apptable";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String AppID =Integer.toString(rs.getInt("appID"));
                String patientName = rs.getString("patientName");
                String phoneNo = Integer.toString(rs.getInt("phoneNo"));
                String email = rs.getString("email");
                String Address = rs.getString("address");
                String issue = rs.getString("issue");
                String paymentID = Integer.toString(rs.getInt("paymentID"));
                String docID = Integer.toString(rs.getInt("docID"));
                String patientID = Integer.toString(rs.getInt("patientID"));
                String date = rs.getString("date");
               
                


                output.append("<tr><td>").append(AppID).append("</td>");
                output.append("<td>").append(patientName).append("</td>");
                output.append("<td>").append(phoneNo).append("</td>");
                output.append("<td>").append(email).append("</td>");
                output.append("<td>").append(Address).append("</td>");
                output.append("<td>").append(issue).append("</td>");
                output.append("<td>").append(paymentID).append("</td>");
                output.append("<td>").append(docID).append("</td>");
                output.append("<td>").append(patientID).append("</td>");
                output.append("<td>").append(date).append("</td>");
               


                output.append("<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\"></td></tr>");
            }

            output.append("</table>");
            System.out.println("Appointment retrieval Successful");
            con.close();
        } catch (Exception e) {
            output = new StringBuilder("Error while reading doctors.");
            System.out.println("Appointment retrieval Unsuccessful");
            System.err.println(e.getMessage());
        }
        return output.toString();

    }

    public Appointment readAppointment(String id) {
        DBconnection connection = new DBconnection();
        Appointment appointment = new Appointment();
        try {
            Connection con = connection.getConnection();

            if (con == null) {
                System.out.println("Error while connecting to the database for reading.");
            }

            String query = "select * from apptable where appID = '" + id + "'";
            assert con != null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                
                	appointment.setAppID(rs.getInt("appID"));
                	appointment.setPatientName(rs.getString("patientName"));
                	appointment.setPhoneNo(rs.getInt("phonrNo"));
                	appointment.setEmail(rs.getString("email"));
                	appointment.setAddress(rs.getString("address"));
                	appointment.setIssue(rs.getString("issue"));
                	appointment.setPaymentID(rs.getInt("paymentID"));
                	appointment.setDocID(rs.getInt("docID"));
                	appointment.setPatientID(rs.getInt("patientID"));
                	appointment.setDate(rs.getString("date"));
                    

                    System.out.println("Appointment retrieval Successful");
                    con.close();
                    return appointment;
                }
            


        } catch (Exception e) {
            System.out.println("Error while reading appointment. appointment retrieval Unsuccessful");
            System.err.println(e.getMessage());
        }
        System.out.println("No such appointment in system");
        return new Appointment();

    }


    public String updateAppointment(Appointment appointment) {
        DBconnection connection = new DBconnection();
        String output = "";
        try {
            Connection con = connection.getConnection();
            if (con == null) {
                return "Error while connecting to the database for updating.";
            }

            String query = "UPDATE apptable SET patientName=?, phoneNo=?, email=?, address=?, issue=?, paymentID=?, docID=?, patientID=?, date=? WHERE appID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, appointment.getPatientName());
            preparedStmt.setInt(2, appointment.getPhoneNo());
            preparedStmt.setString(3, appointment.getEmail());
            preparedStmt.setString(4, appointment.getAddress());
            preparedStmt.setString(5, appointment.getIssue());
            preparedStmt.setInt(6, appointment.getPaymentID());
            preparedStmt.setInt(7, appointment.getDocID());
            preparedStmt.setInt(8, appointment.getPatientID());
            preparedStmt.setString(9, appointment.getDate());
            preparedStmt.setInt(10, appointment.getAppID());
            

            preparedStmt.executeUpdate();
            con.close();
            output = "Updated successfully";
            System.out.println("Update successful on doctor");
        } catch (Exception e) {
            output = "Error while updating doctor.";
            System.out.println("Update unsuccessful on doctor");
            System.err.println(e.getMessage());
        }
        return output;
    }

    public String deleteItem(String appID) {
        DBconnection connection = new DBconnection();
        String output = "";

        try {
            Connection con = connection.getConnection();
            if (con == null) {
                return "Error while connecting to the database for deleting.";
            }

            String query = "delete from apptable where appID=?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, appID);
            preparedStmt.execute();
            con.close();
            output = "Deleted successfully";
            System.out.println("Doctor deleted successfully");
        } catch (Exception e) {
            output = "Error while deleting doctor.";
            System.err.println(e.getMessage());
            System.out.println("Doctor deletion error");
        }
        return output;
    }
		
		}
		
	
