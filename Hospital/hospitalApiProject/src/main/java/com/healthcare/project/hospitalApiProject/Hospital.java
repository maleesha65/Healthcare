package com.healthcare.project.hospitalApiProject;

public class Hospital {

	public String h_id;
	public String h_name;
	public String h_address;
	public String h_phone;
	public String h_email;
	public String getH_id() {
		return h_id;
	}
	public void setH_id(String h_id) {
		this.h_id = h_id;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	public String getH_phone() {
		return h_phone;
	}
	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}
	@Override
	public String toString() {
		return "Hospital [h_id=" + h_id + ", h_name=" + h_name + ", h_address=" + h_address + ", h_phone=" + h_phone
				+ ", h_email=" + h_email + "]";
	}
	public String getH_email() {
		return h_email;
	}
	public void setH_email(String h_email) {
		this.h_email = h_email;
	}
}
