package com.pragya.timetable.model;

import java.util.List;


public class Teacher {
	private String name;
	private int id;
	private String email;
	private String phone;
	
	
	private List<Subject> subList;
	private List<Period> teacherTable;
	public List<Period> getTeacherTable() {
		return teacherTable;
	}
	public void setTeacherTable(List<Period> teacherTable) {
		this.teacherTable = teacherTable;
	}
	public List<Subject> getSubList() {
		return subList;
	}
	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	


}
