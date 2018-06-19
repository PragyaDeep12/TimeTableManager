package com.pragya.timetable.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pragya.timetable.GenerateTTAlgo;
import com.pragya.timetable.dao.PeriodDao;
import com.pragya.timetable.model.Semester;

public class GenerateNewRoutine extends ActionSupport implements ServletRequestAware{
	HttpSession session; 
	String list;
	String tutorials;
	 public String getTutorials() {
		return tutorials;
	}
	public void setTutorials(String tutorials) {
		this.tutorials = tutorials;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	private ArrayList<Semester> semList;
	 public ArrayList<Semester> getSemList() {
		return semList;
	}
	public void setSemList(ArrayList<Semester> semList) {
		this.semList = semList;
	}
	public String newRoutine()
	 {
		 
		 try{
			PeriodDao dao= new PeriodDao();
			dao.deletePeriodTable();
			dao.deleteTeacherPeriod();
			semList=GenerateTTAlgo.generate();
			session.setAttribute("semList", semList);
			return "success";
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 return "fail";
	 }
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session=request.getSession();
	}
	public String getTutorialString()
	{try{
		System.out.println("tutorials"+this.getTutorials());
		
		ArrayList<Semester> sems=(ArrayList<Semester>)session.getAttribute("semList");
		String tutorialList[]=this.getTutorials().split(",");
		GenerateTTAlgo.fillSemTutorials(sems, tutorialList);
		return "success";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "fail";
	}
}
