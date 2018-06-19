package com.pragya.timetable.model;



public class Subject {
	private int id;
	private String subCode;
	private String name;
	private int ifLab;
	public int getIfLab() {
		return ifLab;
	}
	
	private int year;
	private int sem;
	private int classes;
	private int alclass;
	public int getAlclass() {
		return alclass;
	}
	public void setAlclass(int alclass) {
		this.alclass = alclass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int isIfLab() {
		return ifLab;
	}
	public void setIfLab(int ifLab) {
		this.ifLab = ifLab;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public int getClasses() {
		return classes;
	}
	public void setClasses(int classes) {
		this.classes = classes;
	}

}
