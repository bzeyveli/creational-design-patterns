package com.example.creationaldesignpatterns.builder.entity;

public class User {

	private int tckn; 
	private String lastName; 
	private String surName; 
	private String email; 
	private String phone; 

	public User() {

	}

	public User(UserBuilder builder) {
		this.tckn  = builder.tckn;
		this.lastName = builder.lastName;
		this.surName = builder.surName;
		this.phone  = builder.phone;
		this.email  = builder.email;
	}

	public int getTckn() {
		return tckn;
	}

	public void setTckn(int tckn) {
		this.tckn = tckn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "User [tckn=" + tckn + ", lastName=" + lastName + ", surName=" + surName + ", email=" + email
				+ ", phone=" + phone + "]";
	}


	public static class UserBuilder {

		private int tckn;
		private String lastName;
		private String surName;
		private String email;
		private String phone;

	

		public UserBuilder tckn(int tckn) {
			this.tckn = tckn;
			return this;
		}

		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder surName(String surName) {
			this.surName = surName;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		//user 
		public User build() {
			return new User(this);
		}

	}

}
