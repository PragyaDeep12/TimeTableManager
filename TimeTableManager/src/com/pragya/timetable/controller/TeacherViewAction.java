package com.pragya.timetable.controller;

import java.util.ArrayList;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Teacher;

public class TeacherViewAction {
	private ArrayList<Teacher> tlist;
	private boolean noData;
	public boolean isNoData() {
		return noData;
	}
	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	public ArrayList<Teacher> getTlist() {
		return tlist;
	}
	public void setTlist(ArrayList<Teacher> tlist) {
		this.tlist = tlist;
	}
	public String viewTeachers()
	{
		TeacherDao tdao= new TeacherDao();
		tlist=tdao.getTeacherList();
		if(tlist.size()!=0)
			noData=true;
		else noData=false;
		return "success";
		
		
	}
}
