package com.pragya.timetable.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pragya.timetable.dao.PeriodDao;
import com.pragya.timetable.dao.SubjectDao;
import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Subject;
import com.pragya.timetable.model.Teacher;

public class TeacherRegistrationAction extends ActionSupport implements ModelDriven<Teacher>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int tid;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}

	private Teacher teacher = new Teacher();
	private ArrayList<String> offDays;
	private ArrayList<String> days;
	private ArrayList< String> slist;
	private ArrayList< String> selectedSubject;
  

	public ArrayList<String> getSlist() {
		return slist;
	}
	public void setSlist(ArrayList<String> slist) {
		this.slist = slist;
	}
	public ArrayList<String> getSelectedSubject() {
		return selectedSubject;
	}
	public void setSelectedSubject(ArrayList<String> selectedSubject) {
		this.selectedSubject = selectedSubject;
	}
	public ArrayList<String> getOffDays() {
		return offDays;
	}
	public void setOffDays(ArrayList<String> offDays) {
		this.offDays = offDays;
	}



	public ArrayList<String> getDays() {
	return days;
}
	public String viewOffDays()
	{
		PeriodDao pdao= new PeriodDao();
		this.setDays(pdao.getWeekDays());
		return "success";
	}
public void setDays(ArrayList<String> days) {
	this.days = days;
}

	private List<Subject> subjectList;
	public String viewRegistration(){
		
		SubjectDao dao= new SubjectDao();
		this.setSubjectList(dao.selectAllSubject());
		return "success";
	}
	
	public String register(){
		TeacherDao dao= new TeacherDao();
		tid=dao.insert(teacher);
		if(tid!=-1)
		return "success";
		else
			return "fail";
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}
	public String teacherOffDays()
	{
		TeacherDao tdao = new TeacherDao();
		tdao.setTeacherOffDay(tid,offDays);
		for(String y:offDays)
			System.out.println(y);
		return "success";
	}
	public String viewSelectSubject()
	{
		SubjectDao sdao= new SubjectDao();
		slist=new ArrayList<>();
		for(Subject subject: sdao.selectAllSubject())
		{
			String sub=new String();
			sub=subject.getSubCode()+" "+subject.getName();
			slist.add(sub);
		}
		return "success";
	}
	public String setSubject()
	{
		TeacherDao tdao= new TeacherDao();
		if(tdao.setTeacherSubject(tid, selectedSubject))
		
		return "success";
		else
			return "fail";
	}
}
