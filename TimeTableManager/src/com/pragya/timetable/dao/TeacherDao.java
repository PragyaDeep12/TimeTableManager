package com.pragya.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pragya.timetable.model.Period;
import com.pragya.timetable.model.Semester;
import com.pragya.timetable.model.Subject;
import com.pragya.timetable.model.Teacher;
import com.pragya.timetable.model.TeacherSubject;



public class TeacherDao {
	
	public Semester getSemRoutineForTeacher(int tid)
	{
		Semester sem = new Semester();
		sem.setTimeTable(new ArrayList<Period>());
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		ResultSet rs2= null;
		ResultSet rs5= null;
		String qry="select p.id , p.sem,p.time, p.day_id, p.sub_id from period p, m_teacher t, teacher_period tp  where tp.teacher_id= t.teacher_id and tp.period_id = p.id and t.teacher_id=?";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, tid);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Period p= new Period();
				p.setId(rs.getInt("id"));
				p.setSem(rs.getInt("sem"));
				p.setDay_id(rs.getInt("day_id"));
				p.setTime(rs.getInt("time"));
				int sid=rs.getInt("sub_id");
				
				String qry2="select * from m_subject where id=?";
				psmt=con.prepareStatement(qry2);
				psmt.setInt(1, sid);
				rs2=psmt.executeQuery();
				while(rs2.next())
				{
					Subject subject= new Subject();
					subject.setId(sid);
					subject.setName(rs2.getString("name"));
					 subject.setIfLab(rs2.getInt("ifLab"));
					 subject.setClasses(rs2.getInt("classes"));
					 subject.setSem(rs2.getInt("sem"));
					 subject.setSubCode(rs2.getString("sub_code"));
					p.setSubject(subject); 
				}
				String qry5="select day from day_of_week where day_id=?";
				psmt=con.prepareStatement(qry5);
				psmt.setInt(1, p.getDay_id());
				rs5=psmt.executeQuery();
				while(rs5.next())
				{
					p.setDay(rs5.getString("day"));
					System.out.println("day:"+p.getDay());
				}
				sem.getTimeTable().add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnect.closeConnection(con);
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sem;
	}
	
	public ArrayList<Teacher> getTeacherList()
	{
		ArrayList<Teacher> tList= new ArrayList<>();
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		String qry="Select * from m_teacher where name not in ('no teacher')";
		try {
			psmt= con.prepareStatement(qry);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Teacher teacher= new Teacher();
				teacher.setName(rs.getString("name"));
				teacher.setId(rs.getInt("teacher_id"));
				teacher.setEmail(rs.getString("email"));
				teacher.setPhone(rs.getString("phone"));
				tList.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnect.closeConnection(con);
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tList;
	}
	public Teacher getTeacherFromId(int tid)
	{
		Teacher teacher= new Teacher();
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		String qry4="select * from m_teacher where teacher_id=?";
		try {
			psmt=con.prepareStatement(qry4);
			psmt.setInt(1,tid);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				
				teacher.setId(rs.getInt("teacher_id"));
				teacher.setEmail(rs.getString("email"));
				teacher.setPhone(String.valueOf(rs.getInt("phone")));
				teacher.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	public Teacher getTutorialTeacher()
	{
		Teacher teacher= new Teacher();
		Connection  con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		String qry="select * from m_teacher where name='no teacher'";
		try {
			psmt=con.prepareStatement(qry);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				
				teacher.setId(rs.getInt("teacher_id"));
				teacher.setName(rs.getString("name"));
				teacher.setEmail(rs.getString("email"));
				teacher.setPhone(String.valueOf(rs.getInt("phone")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		return teacher;
		
	}
	public Subject getTutorialSubject()
	{
		Subject subject= new Subject();
		Connection  con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		String qry="select * from m_subject where name='tutorial'";
		try {
			psmt=con.prepareStatement(qry);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				subject.setId(rs.getInt("id"));
				subject.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		return subject;
	}
	public Teacher getTeacher(int subid)
	{
		Teacher teacher= new Teacher();
		Connection  con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		String qry="select distinct(t.teacher_id), t.name, t.phone, t.email from m_teacher t, period p, teacher_period tp where tp.period_id=p.id and t.teacher_id=tp.teacher_id and p.sub_id=?";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, subid);
			rs=psmt.executeQuery();
			if(rs.next())
			{
									
					teacher.setId(rs.getInt("teacher_id"));
					teacher.setName(rs.getString("name"));
					teacher.setEmail(rs.getString("email"));
					teacher.setPhone(rs.getString("phone"));
					
				
			}
			else
				return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		return teacher;
		
	}
	public boolean chkFreePeriod(Teacher teacher, Period period)
	{
		Connection  con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		String qry="select count(*) from teacher_period tp, period p where tp.period_id=p.id and tp.teacher_id=? and p.day_id=? and p.time=?";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, teacher.getId());
			psmt.setInt(2, period.getDay_id());
			psmt.setInt(3, period.getTime());
			rs=psmt.executeQuery();
			while(rs.next())
			{
				if(rs.getInt("count(*)")>0)
				{
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		return true;
		
	}
	public boolean chOffDay(Teacher teacher, int day)
	{
		Connection  con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		String qry= "select day_id from off_days where teacher_id=? and day_id=?;";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, teacher.getId());
			psmt.setInt(2, day);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		return true;
	}
	public  ArrayList<Teacher> getTeacherList(int day_id,int subId,int time) {
		
		ArrayList<Teacher> tList=new ArrayList<>();
		Connection  con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		PreparedStatement psmt2=null;
		ResultSet rs2=null;
		try{
			
			 String qry="select t.teacher_id, t.name from m_teacher t, m_subject s, teacher_subject ts,off_days od where t.teacher_id=ts.tcode and s.id=ts.subcode and t.teacher_id = od.teacher_id and od.day_id not in (?) and s.id=? and t.teacher_id != 0;";
			psmt= con.prepareStatement(qry);
			psmt.setInt(1, day_id);
			psmt.setInt(2, subId);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Teacher teacher=new Teacher();
				teacher.setId(rs.getInt("teacher_id"));
				teacher.setName(rs.getString("name"));
				String qry2="select count(*) 'count' from teacher_period, period where period.id=teacher_period.period_id and period.day_id=? and period.time=? and teacher_period.teacher_id = ?;";
				
				
				psmt2=con.prepareStatement(qry2);
				psmt2.setInt(1, day_id);
				psmt2.setInt(2, time);
				psmt2.setInt(3, teacher.getId());
				rs2=psmt2.executeQuery();
				int count=1;
				while(rs2.next()){
				count=rs2.getInt("count");
				
				}
				if(count==0)
				{
					tList.add(teacher);
				}
			}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				psmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnect.closeConnection(con);
		}
		return tList;

	}
	public int insert(Teacher teacher)
	{

		 int result = -1;
		 Connection con=DBConnect.connect();
		 PreparedStatement psmt=null;
		 try{
			 
			 psmt= con.prepareStatement("insert into m_teacher (name, email,phone) values (?, ? ,?);");
			 psmt.setString(1, teacher.getName());
			 psmt.setString(2, teacher.getEmail());
			 psmt.setString(3, teacher.getPhone());
			 psmt.executeUpdate();
			 psmt=con.prepareStatement("select max(teacher_id) from m_teacher");
			 ResultSet rs= psmt.executeQuery();
			 while(rs.next())
			 {
				 result=rs.getInt(1);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("error");
			 e.printStackTrace();
		 }
		 finally {
			 try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		 
		 return result;
		 
			}
	
	public boolean setTeacherOffDay(int tid, ArrayList<String> days)
	{
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		String qry="select day_id from day_of_week where day=?;";
		String qry2="insert into off_days values (?,?);";
		boolean result=false;
		try {
		for(String day:days)
		{ 
			
				psmt=con.prepareStatement(qry);
				psmt.setString(1, day);
				rs=psmt.executeQuery();
				while(rs.next())
				{
					int dayid=rs.getInt("day_id");
					psmt=con.prepareStatement(qry2);
					psmt.setInt(1, tid);
					psmt.setInt(2, dayid);
					psmt.executeUpdate();
				}
			
			
			
		}
		result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
		}
		finally {
			try {
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
			
		}
		return result;
	}
	
	public boolean setTeacherSubject(int tid, ArrayList<String> subjects)
	{
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs=null;
		String qry="insert into teacher_subject (tcode,subcode) values (?,?);";
		String qry2="select id from m_subject where sub_code=?;";
		boolean result=false;
		try {
		for(String subject:subjects)
		{ 
			String [] subcode=subject.split(" ");
				psmt=con.prepareStatement(qry2);
				
				psmt.setString(1, subcode[0]);
						rs=psmt.executeQuery();
				while(rs.next())
				{
					int sub=rs.getInt("id");
					psmt=con.prepareStatement(qry);
					psmt.setInt(1, tid);
					psmt.setInt(2, sub);
					psmt.executeUpdate();
				}
					
			
			
			result=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
		}
		finally {
			try {
				rs.close();
				psmt.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
			
		}
		return result;
	}
	public boolean updateIntoPeriodTable(Period period)
	{
		boolean result= false;
		Connection con=DBConnect.connect();
		PreparedStatement psmt=null;
		String qry="update period set time=? ,day_id=? where id=?";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, period.getTime());
			psmt.setInt(2, period.getDay_id());
			psmt.setInt(3, period.getId());
			psmt.executeUpdate();
			String qry3="update teacher_period set teacher_id=? where period_id=?;";
			
				result=false;
				psmt=con.prepareStatement(qry3);
				psmt.setInt(1, period.getTeacher_id());
				psmt.setInt(2, period.getId());
				psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int addIntoPeriodTable(Period period)
	{
		boolean result= false;
		Connection con=DBConnect.connect();
		PreparedStatement psmt=null;
		String qry="select max(id) 'maxid' from period";
		ResultSet rs=null;
		try {
			psmt=con.prepareStatement(qry);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				period.setId(rs.getInt("maxid")+1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String qry2="insert into period (id,sem,time,sub_id,day_id) values (?,?,?,?,?)";
		try {
			psmt=con.prepareStatement(qry2);
			psmt.setInt(1, period.getId());
			psmt.setInt(2, period.getSem());
			psmt.setInt(3, period.getTime());
			psmt.setInt(4, period.getSubject().getId());
			psmt.setInt(5, period.getDay_id());
			psmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String qry3="insert into teacher_period (teacher_id,period_id) values (?,?);";
		try {
			result=false;
			psmt=con.prepareStatement(qry3);
			psmt.setInt(1, period.getTeacher_id());
			psmt.setInt(2, period.getId());
			psmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period.getId();
	}
	public Semester getSemRoutine(int semid)
	{
		Semester sem= new Semester();
		sem.setTimeTable(new ArrayList<>());
		Connection con= DBConnect.connect();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		String qry="select * from period where sem=?";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, semid);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Period period= new Period();
				period.setId(rs.getInt("id"));
				period.setDay_id(rs.getInt("day_id"));
				period.setSem(semid);
				period.setTime(rs.getInt("time"));
				String qry5="select day from day_of_week where day_id=?";
				psmt=con.prepareStatement(qry5);
				psmt.setInt(1, period.getDay_id());
				rs5=psmt.executeQuery();
				while(rs5.next())
				{
					period.setDay(rs5.getString("day"));
					System.out.println("day:"+period.getDay());
				}
				
				int subId=rs.getInt("sub_id");
				
				String qry2="select * from m_subject where id=?";
				psmt=con.prepareStatement(qry2);
				psmt.setInt(1, subId);
				rs2=psmt.executeQuery();
				while(rs2.next())
				{
					Subject subject= new Subject();
					subject.setId(subId);
					subject.setName(rs2.getString("name"));
					 subject.setIfLab(rs2.getInt("ifLab"));
					 subject.setClasses(rs2.getInt("classes"));
					 subject.setSem(rs2.getInt("sem"));
					 subject.setSubCode(rs2.getString("sub_code"));
					period.setSubject(subject); 
				}
				String qry3="select * from teacher_period where period_id=?";
				psmt=con.prepareStatement(qry3);
				psmt.setInt(1, period.getId());
				rs3=psmt.executeQuery();
				while(rs3.next())
				{
					period.setTeacher_id(rs3.getInt("teacher_id"));
				}
				sem.getTimeTable().add(period);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sem;
		
	}
	public Semester getAllSemRoutine()
	{
		Semester sems=new Semester();
		sems.setTimeTable(new ArrayList<>());
		Connection con= DBConnect.connect();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		String qry="select * from teacher_period";
		try {
			psmt=con.prepareStatement(qry);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				Period period=new Period();
				period.setId(rs.getInt("period_id"));
				period.setTeacher_id(rs.getInt("teacher_id"));
				String qry2="select day_id,sub_id,sem,time from period where id=?";
				psmt=con.prepareStatement(qry2);
				psmt.setInt(1, period.getId());
				rs2=psmt.executeQuery();
				while(rs2.next())
				{
					Subject subject= new Subject();
					period.setDay_id(rs2.getInt("day_id"));
					period.setSubject(subject);
					period.getSubject().setId(rs2.getInt("sub_id"));
					period.setSem(rs2.getInt("sem"));
					period.setTime(rs2.getInt("time"));
					String qry5="select day from day_of_week where day_id=?";
					psmt=con.prepareStatement(qry5);
					psmt.setInt(1, period.getDay_id());
					rs5=psmt.executeQuery();
					while(rs5.next())
					{
						period.setDay(rs5.getString("day"));
					}
					
										
				}
				
				String qry3="select name from m_teacher where teacher_id=?;";
				psmt=con.prepareStatement(qry3);
				psmt.setInt(1, period.getTeacher_id());
				rs3=psmt.executeQuery();
				while(rs3.next())
				{
					period.setTeacherName(rs3.getString("name"));
				}
				
				
				
				String qry4="select name from m_subject where id=?";
				psmt=con.prepareStatement(qry4);
				psmt.setInt(1, period.getSubject().getId());
				rs4=psmt.executeQuery();
				while(rs4.next())
				{
					period.getSubject().setName(rs4.getString("name"));;
				}
				sems.getTimeTable().add(period);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sems;
	}

}
