package com.pragya.timetable.model;

public class TeacherSubject {
private int tid;
private Teacher teacher;
private Subject subject;
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}
private int sid;
private String tname;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
private String sname;

}
