package com.pragya.timetable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.Convert;

import com.pragya.timetable.dao.SubjectDao;
import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.Subject;
import com.pragya.timetable.model.Teacher;

public class GenerateTTAlgo1 {
	public static void generate(ArrayList<Semester> sems){
	TeacherDao tdao= new TeacherDao();
	
	for(Semester sem:sems)
	{ System.out.println("sem number:"+sem.getId());
		int i=0;
		int index=0;
		i=sem.getTimeTable().size();
		ArrayList<Period> perlist=(ArrayList<Period>)sem.getTimeTable();
		
		for(Subject subject:sem.getSubList())
		{
			
			if(subject.getClasses()>0)
			{System.out.println("subject from this sem"+subject.getName());
				while(perlist.get(index).getTime()>1)
				{
					index++;
				}

				System.out.println("period time"+perlist.get(index).getTime()+"alloted:"+perlist.get(index).isAlloted());
				if(perlist.get(index).isAlloted()==false)
				{
					System.out.println("period time"+perlist.get(index).getTime());
			ArrayList<Teacher> tlist=tdao.getTeacherList(perlist.get(index).getDay_id(),subject.getId(),perlist.get(index).getTime());
			if(tlist.size()>0)
			{
				int rand=new Random().nextInt(tlist.size());
				int tid=tlist.get(rand).getId();
				perlist.get(index).setTeacher_id(tid);
				Teacher teacher= new Teacher();
				teacher=tlist.get(rand);
				subject.setAlclass(1);
				System.out.println(subject.getName()+"  "+subject.getSem()+"semester first algo");
				perlist.get(index).setSem(subject.getSem());
				perlist.get(index).setSubject(subject);
				perlist.get(index).setTeacher(teacher);
				perlist.get(index).setAlloted(true);
				
				tdao.addIntoPeriodTable(perlist.get(index));
				index++;
			}
			
			}
				else
				{
					index++;
				}
		}
		
		}
		int [] unallocated=unallotedFirst(perlist);
		for(Subject subject:sem.getSubList())
		{
			if(subject.getAlclass()<1)
			{
				for(int allocate:unallocated)
				{
					if(allocate!=0)
					{
						ArrayList<Teacher> tlist=tdao.getTeacherList(perlist.get(allocate).getDay_id(),subject.getId(),perlist.get(allocate).getTime());
						if(tlist.size()>0)
						{
							int rand=new Random().nextInt(tlist.size());
							int tid=tlist.get(rand).getId();
							perlist.get(allocate).setTeacher_id(tid);
							Teacher teacher= new Teacher();
							teacher=tlist.get(rand);
							
							subject.setAlclass(1);
							perlist.get(allocate).setSem(subject.getSem());
							perlist.get(allocate).setTeacher(teacher);
							perlist.get(allocate).setAlloted(true);
							perlist.get(allocate).setSubject(subject);
							perlist.get(allocate).setAlloted(true);
							tdao.addIntoPeriodTable(perlist.get(allocate));
							allocate=0;
							break;
						}
					}
				}
			}
		}
		for(Subject subject:sem.getSubList())
		{
			if(subject.getAlclass()<1)
			{int ind=0;
			while(ind<24)
			{
				if(perlist.get(ind).getTime()==2 && !perlist.get(ind).isAlloted())
				{
					ArrayList<Teacher> tlist=tdao.getTeacherList(perlist.get(ind).getDay_id(),subject.getId(),perlist.get(ind).getTime());
					if(tlist.size()>0)
					{
						int rand=new Random().nextInt(tlist.size());
						int tid=tlist.get(rand).getId();
						perlist.get(ind).setTeacher_id(tid);
						Teacher teacher= new Teacher();
						teacher=tlist.get(rand);
						subject.setAlclass(1);
						
						perlist.get(ind).setSem(subject.getSem());
						perlist.get(ind).setTeacher(teacher);
						perlist.get(ind).setAlloted(true);
						perlist.get(ind).setSubject(subject);
						perlist.get(ind).setAlloted(true);
						tdao.addIntoPeriodTable(perlist.get(ind));
						
						break;
					}
					else
						ind++;
					
				}
				else
					ind++;
					
				}
			}
		}
		
		
	}
	
	GenerateTTAlgo2.generate(sems);
	for(Semester sem: sems)
	{
		System.out.println("Sem id:"+sem.getId());
		for(Period period:sem.getTimeTable())
		{
			if(period.isAlloted())
			{
				System.out.println("subject :"+period.getSubject().getName()+"\t teacher:"+period.getTeacher().getName()+"\t time"+period.getTime()+"\t day "+period.getDay_id());
			}
		}
	}
	GenerateTTAlgo3.generate(sems);
	
	}
	public static int[] unallotedFirst(ArrayList<Period> perlist)
	{
		int [] unallocated=new int [6];
		
		int i=0;
		for(;i<6;i++)
		{
			unallocated[i]=0;
		}
		i=0;
		int index=1;
		while(index<24)
		{
		while(perlist.get(index).getTime()>1 )
		{if(index<24-1)
			index++;
		else break;
		}
		if(!perlist.get(index).isAlloted())
		{
			System.out.println("value of i:"+i);
			unallocated[i]=index;
			i++;
		}
		index++;
		}
		return unallocated;
	}
	
	
}
