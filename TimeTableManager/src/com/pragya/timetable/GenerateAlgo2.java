package com.pragya.timetable;

import java.util.ArrayList;
import java.util.Random;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.Subject;
import com.pragya.timetable.model.Teacher;

public class GenerateAlgo2 {
	public static void algo2(ArrayList<Semester> sems)
	{
		ArrayList<Period> noTeacher= new ArrayList<>();
		for(Semester sem:sems)
		{ 
			for(Period p:sem.getTimeTable())
			{
				if(p.isAlloted()==false && p.getTime()<3)
				{
					noTeacher.add(p);			//list of periods with no teacher
				}
			}
			ArrayList<Period> notAlloted= new ArrayList<>();
			for(Period p:sem.getTimeTable())
			{
				if(p.getSubject()!=null)
				{
				if(p.getTeacher_id()==0)
				{
					notAlloted.add(p);
				}
				}
				
			}
			for(Period p:notAlloted)
			{
				for(Period period:noTeacher)
				{
					TeacherDao tdao= new TeacherDao();
					
					ArrayList<Teacher> tlist=tdao.getTeacherList(period.getDay_id(), p.getSubject().getId(), period.getTime());
					
					if(tlist.size()>0)
					{	System.out.println("enterees");
						int rand=new Random().nextInt(tlist.size());
						int tid=tlist.get(rand).getId();
						System.out.println();
						period.setSubject(p.getSubject());
						Subject sub=period.getSubject();
						p.setSubject(sub);
						period.setTeacher_id(tid);
						period.setId(p.getId());
						period.setAlloted(true);
						tdao.updateIntoPeriodTable(period);
						noTeacher.remove(period);
						noTeacher.add(p);
						break;
					}
				}
			}
		}
		
	}
}
