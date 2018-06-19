package com.pragya.timetable.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import com.pragya.timetable.GetRoutine;
import com.pragya.timetable.Routine;
import com.pragya.timetable.SemRoutine;
import com.pragya.timetable.model.Semester;

public class ViewRoutineAction extends ActionSupport implements ServletRequestAware{
	int sem;
	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	HttpSession session;
	public String viewRoutine()
	{
		ArrayList<Semester> semester= new ArrayList<>();
		semester= Routine.generate();
		
		session.setAttribute("list", semester);
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session= request.getSession();
	}
	public String viewSemRoutine()
	{
		try{
		ArrayList<Semester> semester= new ArrayList<>();
		Semester sem= SemRoutine.generate(getSem());
		semester.add(sem);
		session.setAttribute("list", semester);
		return "success";
		}
		
	catch (Exception ex)
		{
		ex.printStackTrace();
		}
		return "failed";
	}
}
