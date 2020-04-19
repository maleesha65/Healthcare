package com.healthcare.project.hospitalApiProject;

import java.util.ArrayList;

import java.util.List;
import java.sql.*;



public class HospitalRepository {
	
	Connection con =null;
	List<Hospital> Hospital;
	public HospitalRepository() {
		
		String url ="jdbc:mysql://localhost:3306/hospital?serverTimezone=UTC";
		String username ="root";
		String password="";
		try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
						
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		Hospital = new ArrayList<>();
		
		Hospital h1 = new Hospital();
		h1.h_id="h1";
		h1.h_name="Hemas";
		h1.h_address="Kandy road Colomboo";
		h1.h_phone="0112349804";
		h1.h_email="hemas@gmail.com";

		Hospital h2 = new Hospital();
		h2.h_id="h2";
		h2.h_name="Appalo";
		h2.h_address="Colomboo road Kurunegala";
		h2.h_phone="0374569808";
		h2.h_email="appalo@gmail.com";
		
		Hospital h3 = new Hospital();
		h3.h_id="h3";
		h3.h_name="Lanka";
		h3.h_address="Kandy road Colomboo";
		h3.h_phone="0112254678";
		h3.h_email="lanka@gmail.com";
		
		Hospital.add(h1);
		Hospital.add(h2);
		Hospital.add(h3);
		
	}
	
	public List<Hospital> getAllHospital(){
		return Hospital;
	}
	
	public Hospital createHospital(Hospital h1) {
		String insertsql = "INSERT INTO `hospital_table`(`h_id`, `h_name`, `h_address`, `h_phone`, `h_email`) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement hs = con.prepareStatement(insertsql);
			hs.setString(1, h1.h_id);
			hs.setString(2, h1.h_name);
			hs.setString(3, h1.h_address);
			hs.setString(4, h1.h_phone);
			hs.setString(5, h1.h_email);
			
			hs.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		Hospital.add(h1);
		System.out.println(Hospital);
		return h1;
	}
	
	public com.healthcare.project.hospitalApiProject.Hospital updateHospital(Hospital h1) {
		String sql = "UPDATE `hospital_table` SET `h_name`=?,`h_address`=?,`h_phone`=?,`h_email`=? WHERE `h_id`=?";
		try {
			PreparedStatement hs = con.prepareStatement(sql);
			hs.setString(1, h1.h_name);
			hs.setString(2, h1.h_address);
			hs.setString(3, h1.h_phone);
			hs.setString(4, h1.h_email);
			hs.setString(5, h1.h_id);
			
			hs.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return h1;
}
	public com.healthcare.project.hospitalApiProject.Hospital deleteHospital(Hospital h1) {
		String sql = "DELETE FROM `hospital_table` WHERE `h_id`=?";
		try {
			PreparedStatement hs = con.prepareStatement(sql);
			
			hs.setString(1, h1.h_id);
			 
			
			hs.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return h1;
		
	
}

}
