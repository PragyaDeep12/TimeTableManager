package com.pragya.timetable;

import java.util.ArrayList;

import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.TeacherSubject;

public class GenerateTTAlgo2 {
	public static void generate(ArrayList<Semester> sems)
	{
		for(Semester sem:sems){
			//System.out.println("Entered");
			ArrayList<TeacherSubject> tsList=getSubTeachList((ArrayList<Period>)sem.getTimeTable());
			ArrayList<Period> perList= (ArrayList<Period>)sem.getTimeTable();
			for(TeacherSubject ts:tsList)
			{//System.out.println("Subject :"+ts.getSubject().getName());
				int index=0;
				if(index>23)
				{
					//System.out.println(" over index Subject:"+ts.getSubject().getName());
				}
				while(ts.getSubject().getAlclass()<ts.getSubject().getClasses() && index<24)
				{
				TeacherDao tdao= new TeacherDao();
				
				for(Period period:perList)
				{if(period.getTime()==2 && period.isAlloted()==false )
				{
					//System.out.println("#entered");
					if(perList.get(perList.indexOf(period)-1).getSubject()!=null)
					if(perList.get(perList.indexOf(period)-1).getSubject().getId()!=ts.getSubject().getId())
				{
						//System.out.println("#entered");
					if(tdao.chOffDay(ts.getTeacher(),period.getDay_id()))
					{
						if(tdao.chkFreePeriod(ts.getTeacher(),period))
						{
							period.setAlloted(true);
							ts.getSubject().setAlclass(ts.getSubject().getAlclass()+1);
							period.setTeacher(ts.getTeacher());
							period.setSubject(ts.getSubject());
							period.setTeacher_id(ts.getTeacher().getId());
							period.setSem(ts.getSubject().getSem());
							tdao.addIntoPeriodTable(period);
							System.out.println("allocated subject 2nd algo: "+period.getSubject().getName());
							break;
						}
					}
				}
				}
				index++;
				}
			}
			}
		}
		
	}
	
	public static ArrayList<TeacherSubject> getSubTeachList(ArrayList<Period> perlist)
	{
		ArrayList<TeacherSubject> tsList= new ArrayList<>();
		for(Period period:perlist)
		{
			if(period.isAlloted())
			{
				TeacherSubject ts= new TeacherSubject();
				ts.setSubject(period.getSubject());
				ts.setTeacher(period.getTeacher());
				//System.out.println("2nd algo \tSubject"+period.getSubject().getName()+"\t teacher"+period.getTeacher_id());
				tsList.add(ts);
				
			}
		}
		return tsList;
	}
}
