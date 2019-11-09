package com.LTI.College_Proj.Model;

public class CustomerBean {
	protected int id;
	protected String fname;
	protected String lname;
	protected String address;
	protected String city;
	protected String state;
	protected String zipcode;
	protected String email;
	public CustomerBean(){}
	public CustomerBean(int id, String fname, String lname, String address, String city, String state,
			String zipcode, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}
	public CustomerBean(String fname, String lname, String address, String city, String state, String zipcode,
			String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerBean [customer_id=" + id + ", fname=" + fname + ", lname=" + lname + ", address="
				+ address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", email=" + email + "]";
	}
	
}
