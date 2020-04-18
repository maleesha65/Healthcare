package com.appointment.model;

public class Appointment {
	private int appID;
	private String patientName;
	private int phoneNo;
	private String email;
	private String address;
	private String issue;
	private String date;
	private int paymentID;
	private int docID;
	private int patientID;
	
	
	
	 public int getAppID() {
		return appID;
	}



	public void setAppID(int appID) {
		this.appID = appID;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public int getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getIssue() {
		return issue;
	}



	public void setIssue(String issue) {
		this.issue = issue;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getPaymentID() {
		return paymentID;
	}



	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}



	public int getDocID() {
		return docID;
	}



	public void setDocID(int docID) {
		this.docID = docID;
	}



	public int getPatientID() {
		return patientID;
	}



	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}



	@Override
	    public String toString() {
	        return "Doctor{" +
	                "appID='" + appID + '\'' +
	                ", fullName='" + patientName + '\'' +
	                ", phoneNo='" + phoneNo + '\'' +
	                ", email='" + email + '\'' +
	                ", address='" + address + '\'' +
	                ", issue='" + issue + '\'' +
	                ", date=" + date +
	                ", hospitalID='" + paymentID + '\'' +
	                ", docID='" + docID + '\'' +
	                ", patientID='" + patientID + '\'' +
	                '}';
	    }
	
	
		
}


