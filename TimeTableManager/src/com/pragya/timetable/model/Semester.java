package com.pragya.timetable.model;

import java.util.ArrayList;
import java.util.List;


public class Semester {
	private int id;
	private List<Subject> subList;
	private List<Period> timeTable= new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Subject> getSubList() {
		return subList;
	}
	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
	public List<Period> getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(List<Period> timeTable) {
		this.timeTable = timeTable;
	}
	

}
