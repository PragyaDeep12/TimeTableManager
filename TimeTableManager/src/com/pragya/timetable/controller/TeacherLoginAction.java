package com.pragya.timetable.controller;

public class TeacherLoginAction {
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	public String login()
	{
		
		if(this.getPassword().equals("1234"))
			return "success";
		else return "fail";
		
	}
}
