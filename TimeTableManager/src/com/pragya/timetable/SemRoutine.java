package com.pragya.timetable;

import java.util.ArrayList;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;

public class SemRoutine {
public static Semester generate(int semNumber)
{
	Semester semester= new Semester();
	initializePeriods(semester);
	TeacherDao dao= new TeacherDao();
	Semester sem=dao.getSemRoutine(semNumber);
	for(Period period:sem.getTimeTable())
	{
		for(Period p:semester.getTimeTable())
			if(p.getDay_id()==period.getDay_id()&&p.getTime()==period.getTime())
			{
				p.setSubject(period.getSubject());
				p.setTeacher_id(period.getTeacher_id());
				p.setId(period.getId());
				p.setDay(period.getDay());
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
