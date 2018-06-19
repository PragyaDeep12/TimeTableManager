package com.pragya.timetable.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pragya.timetable.GetTeacherRoutine;
import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Teacher;

public class TeacherRoutine extends ActionSupport implements ServletRequestAware{
	private ArrayList<Teacher> tList;
	private int tid;
	HttpSession session;
	private boolean noData;
	public boolean isNoData() {
		return noData;
	}
	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	public ArrayList<Teacher> gettList() {
		return tList;
	}
	public void settList(ArrayList<Teacher> tList) {
		this.tList = tList;
	}
	public String selectTeacher()
	{
		TeacherDao tdao= new TeacherDao();
		this.settList(tdao.getTeacherList());
		if(tList.size()>0)
		{
			session.setAttribute("tList", tList);
			setNoData(true);
		}
		else setNoData(false);
		return "success";
	}
	public String viewRoutine()
	{System.out.println("get tid"+tid);
		session.setAttribute("tRoutine", GetTeacherRoutine.getRoutine(tid));
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session=request.getSession();
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
}
