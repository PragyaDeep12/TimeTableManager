package com.pragya.timetable;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;

public class GetTeacherRoutine {
	public static Semester getRoutine(int tid)
	{
		Semester sem= new Semester();
		Routine.initializePeriods(sem);
		TeacherDao tdao= new TeacherDao();
		Semester semester=tdao.getSemRoutineForTeacher(tid);
		for(Period period:semester.getTimeTable())
		{ System.out.println("subject outer loop"+period.getSubject().getName());
			for(Period p:sem.getTimeTable())
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
		return sem;		
	}
}
