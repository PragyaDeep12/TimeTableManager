package com.pragya.timetable;

import java.util.ArrayList;
import java.util.Scanner;

import com.pragya.timetable.dao.PeriodDao;
import com.pragya.timetable.dao.SubjectDao;
import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.Subject;

public class GenerateTTAlgo {
 public static  ArrayList<Semester> generate()
 {SubjectDao dao = new SubjectDao();
	TeacherDao tdao = new TeacherDao();
	ArrayList<Semester> sems = new ArrayList<>();
	Semester sem2 = new Semester();
	sem2.setId(2);
	
	Semester sem4 = new Semester();
	sem4.setId(4);
	
	Semester sem6 = new Semester();
	sem6.setId(6);
	Semester sem8 = new Semester();
	sem8.setId(8);
	ArrayList<Subject> sem2Subject = new ArrayList<Subject>();
	ArrayList<Subject> sem4Subject = new ArrayList<Subject>();
	ArrayList<Subject> sem6Subject = new ArrayList<Subject>();
	ArrayList<Subject> sem8Subject = new ArrayList<Subject>();
	ArrayList<Subject> subjectList = (ArrayList<Subject>) dao.selectEvenSemOnlyTheory();
	
	for (Subject s : subjectList)
	{
		if (s.getSem() == 2) {
			sem2Subject.add(s);
			// System.out.println("subject in 2nd sem:"+s.getName());
		} else if (s.getSem() == 4) {
			sem4Subject.add(s);
		} else if (s.getSem() == 6) {
			sem6Subject.add(s);
		} else {
			sem8Subject.add(s);
		}

	}
	sem2.setSubList(sem2Subject);
	sem4.setSubList(sem4Subject);
	sem6.setSubList(sem6Subject);
	sem8.setSubList(sem8Subject);
	sems.add(sem8);
	sems.add(sem6);
	sems.add(sem4);
	sems.add(sem2);
	for (Semester sem : sems) {
		initializePeriods(sem);
		

	}
	
	 return sems;
 }
 public static void fillSemTutorials(ArrayList<Semester> sems, String [] tutorialList)
 {
	 int i=0;
	 for(Semester sem:sems)
	 {
		 //System.out.println("entered"+tutorialList[i].substring(1));
		 fillTutorials(sem,tutorialList[i].substring(1));
		 i++;
	 }
	 for(Semester sem:sems)
	 {
		 System.out.println("for sem"+sem.getId());
		 for(Period p:sem.getTimeTable())
		 {
			 System.out.println(p.isAlloted()+"shows allotment");
		 }
	 }
	 
	 GenerateTTAlgo1.generate(sems);
 }
 public static void fillTutorials(Semester sem,String tutoiral)
	{
		TeacherDao tdao= new TeacherDao();
		
		String [] tuList=(tutoiral.split(" "));
		for(String s:tuList)
		{if(!s.equals("")){
			int index=Integer.parseInt(s);
			sem.getTimeTable().get(index).setAlloted(true);
			sem.getTimeTable().get(index).setSem(sem.getId());
			
			sem.getTimeTable().get(index).setTeacher(tdao.getTutorialTeacher());
			sem.getTimeTable().get(index).setSubject(tdao.getTutorialSubject());
			sem.getTimeTable().get(index).setTeacher_id(sem.getTimeTable().get(index).getTeacher().getId());
			tdao.addIntoPeriodTable(sem.getTimeTable().get(index));
		}
	}
	}
	public static void initializePeriods(Semester sem )
	{System.out.println("initializing periods"+sem.getId());
		//sem.setTimeTable(new ArrayList<>());
		PeriodDao pdao= new PeriodDao();
		int count=1;
		int time=1;
		int day_id=1;
		while(count!=25)
		{Period p=new Period();
			//System.out.println("periods set to false");
			
			p= new Period();
			p.setTime(time);
			p.setDay_id(day_id);
			p.setDay(pdao.getDayFromId(day_id));
			p.setAlloted(false);
			time++;
			if(time==5)
			{day_id++;
				time=1;
			}
			sem.getTimeTable().add(p);
			count++;
		}
		
		//System.out.println("sem timetable size"+sem.getTimeTable().size()+sem.getTimeTable().get(0).getDay_id());
	}

}
