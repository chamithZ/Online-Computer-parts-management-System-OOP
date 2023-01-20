package webpro;

import java.sql.Connection;

public class Customer {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String email;
	private String phone;
	private String 	state;
	private String country;
	private String password;
	
	public Customer(String fname,int id,String lname,String address,String email,String phone,String state,String country,String password) {

		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.address=address;
		this.email=email;
		this.phone=phone;
		this.state=state;
		this.country=country;
		this.password=password;
	}
	public Customer(String email,String password) {

		this.email=email;
		this.password=password;
	}

	

	public int getId() {
		return id;
	}


	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}

	public String getAddress() {
		return address;
	}


	public String getEmail() {
		return email;
	}


	public String getPhone() {
		return phone;
	}


	public String getState() {
		return state;
	}


	public String getCountry() {
		return country;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", email=" + email + ", password=" + password + "]";
	}
	
}
