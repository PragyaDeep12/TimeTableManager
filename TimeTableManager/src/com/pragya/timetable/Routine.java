package com.pragya.timetable;

import java.util.ArrayList;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;

public class Routine {
 public static ArrayList<Semester> generate()
 {	ArrayList<Semester> semester=new ArrayList<>();
	 TeacherDao tdao= new TeacherDao();
	Semester sems= tdao.getAllSemRoutine();
	Semester sem2= new Semester();
	sem2.setId(2);
	initializePeriods(sem2);
	Semester sem4= new Semester();
	sem4.setId(4);
	initializePeriods(sem4);
	Semester sem6= new Semester();
	sem6.setId(6);
	initializePeriods(sem6);
	Semester sem8= new Semester();
	sem8.setId(8);
	initializePeriods(sem8);
	Semester sem2plist= new Semester();
	sem2plist.setTimeTable(new ArrayList<>());
	Semester sem4plist= new Semester();
	sem4plist.setTimeTable(new ArrayList<>());
	Semester sem6plist= new Semester();
	sem6plist.setTimeTable(new ArrayList<>());
	Semester sem8plist= new Semester();
	sem8plist.setTimeTable(new ArrayList<>());
	for(Period period:sems.getTimeTable())
	{
		if(period.getSem()==2)
		{
			sem2plist.getTimeTable().add(period);
			
		}
		else if(period.getSem()==4)
		{
			sem4plist.getTimeTable().add(period);
			
		}
		else if(period.getSem()==6)
		{
			sem6plist.getTimeTable().add(period);
		
		}
		else 
		{
			sem8plist.getTimeTable().add(period);
			
		}
	}
	
	for(Period period:sem2plist.getTimeTable())
	{
		for(Period p:sem2.getTimeTable())
		{
			if(p.getDay_id()==period.getDay_id()&&p.getTime()==period.getTime())
			{
				p.setSubject(period.getSubject());
				p.setTeacher_id(period.getTeacher_id());
				p.setId(period.getId());
				p.setDay(period.getDay());
				
			}
		}
	}
	
	for(Period period:sem4plist.getTimeTable())
	{
		for(Period p:sem4.getTimeTable())
		{
			if(p.getDay_id()==period.getDay_id()&&p.getTime()==period.getTime())
			{
				p.setSubject(period.getSubject());
				p.setTeacher_id(period.getTeacher_id());
				p.setId(period.getId());
				p.setDay(period.getDay());
				
			}
		}
	}
	for(Period period:sem6plist.getTimeTable())
	{
		for(Period p:sem6.getTimeTable())
		{
			if(p.getDay_id()==period.getDay_id()&&p.getTime()==period.getTime())
			{
				p.setSubject(period.getSubject());
				p.setTeacher_id(period.getTeacher_id());
				p.setId(period.getId());
				p.setDay(period.getDay());
			}
		}
	}
	for(Period period:sem8plist.getTimeTable())
	{
		for(Period p:sem8.getTimeTable())
		{
			if(p.getDay_id()==period.getDay_id()&&p.getTime()==period.getTime())
			{
				p.setSubject(period.getSubject());
				p.setTeacher_id(period.getTeacher_id());
				p.setId(period.getId());
				p.setDay(period.getDay());
						
			}
		}
	}
	semester.add(sem8);
	semester.add(sem6);
	semester.add(sem4);
	semester.add(sem2);
	for(Semester sem:semester)
	{
		for(Period p:sem.getTimeTable())
		{if(p.getSubject()!=null)
			System.out.println("sem id: "+sem.getId()+"\t subject: "+p.getSubject().getName()+"\t day: "+p.getDay_id()+"\t time :"+p.getTime());
		}
	}
	return semester;
 }
 public static void initializePeriods(Semester sem )
	{
		int count=1;
		int time=1;
		int day_id=1;
		while(count!=25)
		{Period p=new Period();
			p= new Period();
			p.setTime(time);
			p.setDay_id(day_id);
			p.setAlloted(false);
			p.setSubject(null);
			
			p.setTeacher_id(0);
			time++;
			if(time==5)
			{day_id++;
				time=1;
			}
			sem.getTimeTable().add(p);
			count++;
		}
		
		
	}

}
