package com.pragya.timetable;

import java.util.ArrayList;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.Subject;
import com.pragya.timetable.model.TeacherSubject;

public class GenerateTTAlgo3 {
	public static void generate(ArrayList<Semester> sems)
	{
		TeacherDao tdao= new TeacherDao();
		
		for(Semester sem:sems){
			ArrayList<TeacherSubject> tsList=unallotedSubject(sem);
			
			for(TeacherSubject ts:tsList)
			{
				int index=0;
				while(ts.getSubject().getAlclass()<ts.getSubject().getClasses()&& index<24)
				{
					//System.out.println("3rd algo entered: ");
						for(Period period:sem.getTimeTable())
						{
							if(period.getTime()<3)
							{
								
							if(tdao.chOffDay(ts.getTeacher(), period.getDay_id())&&period.isAlloted()==false)
							{
								
								if(tdao.chkFreePeriod(ts.getTeacher(), period))
								{
									period.setAlloted(true);
									ts.getSubject().setAlclass(ts.getSubject().getAlclass()+1);
									period.setSem(ts.getSubject().getSem());
									period.setSubject(ts.getSubject());
									period.setTeacher(ts.getTeacher());
									period.setTeacher_id(ts.getTeacher().getId());
									tdao.addIntoPeriodTable(period);
									System.out.println("allocated subject in3 rd algo: "+period.getSubject().getName());
									break;
									
								}
							}
							}
							index++;
						}
						
				}
		}
		}
	}
	public static ArrayList<TeacherSubject> unallotedSubject(Semester sem)
	{
		TeacherDao tdao= new TeacherDao();
		ArrayList<TeacherSubject> tsList= new ArrayList<>();
		for(Subject subject: sem.getSubList())
		{
			if(subject.getAlclass()!=subject.getClasses())
			{
				TeacherSubject ts= new TeacherSubject();
				ts.setSubject(subject);
				ts.setTeacher(tdao.getTeacher(subject.getId()));
				//System.out.println("Unalloted by frst algo"+subject.getName()+"unallocated class"+subject.getAlclass()+"\ttotal class"+subject.getClasses());
				//System.out.println("3rd algo \tSubject"+subject.getName()+"\t teacher"+ts.getTeacher().getId());
				tsList.add(ts);
			}
		}
		return tsList;
	}
	
}
