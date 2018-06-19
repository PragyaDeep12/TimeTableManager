package com.pragya.timetable;
import java.util.ArrayList;
import java.util.Random;

import com.pragya.timetable.dao.SubjectDao;
import com.pragya.timetable.dao.TSDao;
import com.pragya.timetable.dao.TeacherDao;
import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.Subject;
import com.pragya.timetable.model.Teacher;
import com.pragya.timetable.model.TeacherSubject;

public class GenerateTimetable {
public static void  generate(){
			SubjectDao dao = new SubjectDao();
			TeacherDao tdao = new TeacherDao();
			ArrayList<Semester> sems = new ArrayList<>();
			Semester sem2 = new Semester();
			Semester sem4 = new Semester();
			Semester sem6 = new Semester();
			Semester sem8 = new Semester();
			ArrayList<Subject> sem2Subject = new ArrayList<Subject>();
			ArrayList<Subject> sem4Subject = new ArrayList<Subject>();
			ArrayList<Subject> sem6Subject = new ArrayList<Subject>();
			ArrayList<Subject> sem8Subject = new ArrayList<Subject>();
			ArrayList<Subject> subjectList = (ArrayList<Subject>) dao.selectEvenSemOnlyTheory();
			ArrayList<TeacherSubject> list = new ArrayList<>();
			TSDao tsdao = new TSDao();
			list = tsdao.getTSListEvenSemTheory();
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
			try {
				for (Semester sem : sems) {
					int index = 0;

					int allotment = 1;
					while (allotment == 1) {
						allotment = 0;
						ArrayList<Period> perList = (ArrayList<Period>) sem.getTimeTable();

						int i = perList.size();
						for (Subject sub : sem.getSubList()) {
							if (i == index)
								break;

							else {

								if (sub.getClasses() != 0)//
								{
									while (perList.get(index).getTime() > 2) {
										index++;
									}
									perList.get(index).setSubject(sub);

									perList.get(index).setSem(sub.getSem());
									int subid = perList.get(index).getSubject().getId();
									int dayid = perList.get(index).getDay_id();
									int time = perList.get(index).getTime();
									ArrayList<Teacher> tList = tdao.getTeacherList(dayid, subid, time);
									
									if(tList.size()>0)
									{
									int rand=new Random().nextInt(tList.size());
									int tid=tList.get(rand).getId();
									perList.get(index).setTeacher_id(tid);
									perList.get(index).setAlloted(true);
									tdao.addIntoPeriodTable(perList.get(index));
									}
									else
									{
										System.out.println("noteacer selected");
										int tid=0;
										perList.get(index).setTeacher_id(tid);
										tdao.addIntoPeriodTable(perList.get(index));
									}
								}

								sub.setClasses(sub.getClasses() - 1);
								if (sub.getClasses() != 0) {
									allotment = 1;

								}
								System.out.println("subject:" + sub.getName() + "\nindex: " + index + "\tperiod day:"
										+ perList.get(index).getDay_id() + "\ttime:" + perList.get(index).getTime());
								index++;
							}
						}

					}
					for (int x = index; x < 24; x++) {
						sem.getTimeTable().get(x).setSubject(null);
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			for (Semester sem : sems) {
				for (Period p : sem.getTimeTable()) {
					if (p.getSubject() != null)
						System.out.println("p->sub\t" + p.getSubject().getName() + "\tof sem->\t" + p.getSem()
								+ "\t day_id->\t" + p.getDay_id() + "\t time\t" + p.getTime());
				}

			}

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
				time++;
				if(time==5)
				{day_id++;
					time=1;
				}
				sem.getTimeTable().add(p);
				count++;
			}
			
			System.out.println("sem timetable size"+sem.getTimeTable().size());
		}

	}



