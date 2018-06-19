package com.pragya.timetable.controller;

public class AdminLoginAction {
	String id;
	String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String adminLogin()
	{
		if(this.getId().equals("admin")&& this.getPassword().equals("admin"))
		return "success";
		else
			return "false";
	}
}
