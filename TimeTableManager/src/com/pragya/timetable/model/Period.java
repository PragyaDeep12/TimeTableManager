package com.pragya.timetable.model;


public class Period {
	 private int id;
	 private int sem;
	 private int time;
	 private int day_id;
	 private String day;
	 private Subject subject;	
	 private int teacher_id;
	 private String teacherName;
	 private boolean alloted;
	 private Teacher teacher;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public boolean isAlloted() {
		return alloted;
	}
	public void setAlloted(boolean alloted) {
		this.alloted = alloted;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	 public int getDay_id() {
			return day_id;
		}
		public void setDay_id(int day_id) {
			this.day_id = day_id;
		}

}
