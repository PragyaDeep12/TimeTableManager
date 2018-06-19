package com.pragya.timetable;

import java.util.ArrayList;
import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;

public class GetRoutine {
 public static ArrayList<Semester> generate()
 {
	 	ArrayList<Semester> semester= new ArrayList<>();
		TeacherDao dao=new TeacherDao();
		Semester sems= (dao.getAllSemRoutine());
		Semester sem2=new Semester();
		sem2.setId(2);
		sem2.setTimeTable(new ArrayList<>());
		Semester sem4=new Semester();
		sem4.setId(4);
		
		sem4.setTimeTable(new ArrayList<>());
		Semester sem6=new Semester();
		sem6.setId(6);
		sem6.setTimeTable(new ArrayList<>());
		Semester sem8=new Semester();
		sem8.setId(8);
		sem8.setTimeTable(new ArrayList<>());
		for(Period period:sems.getTimeTable())
		{
			if(period.getSem()==2)
			{
				sem2.getTimeTable().add(period);
			}
			else if(period.getSem()==4)
			{
				sem4.getTimeTable().add(period);
				
			}
			else if(period.getSem()==6)
			{
				sem6.getTimeTable().add(period);
			}
			else
			{
				sem8.getTimeTable().add(period);
			}
		}
		System.out.println("periods in sem 2");
		for(Period period:sem2.getTimeTable())
		{
			System.out.println("subject->"+period.getSubject().getName()+"\tteacher-> id:"+period.getTeacher_id()+"\tname:  "+period.getTeacherName());
		}
		
		System.out.println("\n\nperiods in sem 4");
		for(Period period:sem4.getTimeTable())
		{
			System.out.println("subject->"+period.getSubject().getName()+"\tteacher-> id:"+period.getTeacher_id()+"\tname:  "+period.getTeacherName());
		}
		System.out.println("\n\nperiods in sem 6");
		for(Period period:sem6.getTimeTable())
		{
			System.out.println("subject->"+period.getSubject().getName()+"\tteacher-> id:"+period.getTeacher_id()+"\tname:  "+period.getTeacherName());
		}
		System.out.println("\n\nperiods in sem 8");
		for(Period period:sem8.getTimeTable())
		{
			System.out.println("subject->"+period.getSubject().getName()+"\tteacher-> id:"+period.getTeacher_id()+"\tname:  "+period.getTeacherName());
		}
		semester.add(sem8);
		semester.add(sem6);
		semester.add(sem4);
		semester.add(sem2);
		return semester;
	}
}
