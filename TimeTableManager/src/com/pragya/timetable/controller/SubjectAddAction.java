package com.pragya.timetable.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pragya.timetable.dao.SubjectDao;
import com.pragya.timetable.model.Subject;

public class SubjectAddAction extends ActionSupport implements ModelDriven<Subject>{
	private Subject sub=new Subject();
	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public String addSubject(){
		SubjectDao dao= new SubjectDao();
		if(dao.insert(sub))
		return "success";
		else
			return "fail";
		
	}

	@Override
	public Subject getModel() {
		// TODO Auto-generated method stub
		return sub;
	}
}
