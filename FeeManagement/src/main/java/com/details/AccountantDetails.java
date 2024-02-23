package com.details;



public class AccountantDetails {
	
		private int id;
		private long phonenumber;
		private String firstname, lastname, email, password, address, gender;

		public AccountantDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AccountantDetails(String firstname, String lastname, String email, long phonenumber,  String address, String password, String gender) {
			super();
			this.firstname=firstname;
			this.lastname = lastname;
			this.email = email;
			this.phonenumber=phonenumber;
			this.address = address;
			this.password = password;
			this.gender = gender;
		}

		public AccountantDetails(int id,String firstname, String lastname, String email, long phonenumber,  String address, String password, String gender) {
			super();
			this.id = id;
			this.firstname=firstname;
			this.lastname = lastname;
			this.email = email;
			this.phonenumber=phonenumber;
			this.address = address;
			this.password = password;
			this.gender = gender;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(long phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
	}



