package com.pragya.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pragya.timetable.model.Period;

public class PeriodDao {
	public Period getPeriod(int id)
	{
		Period period= new Period();
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		ResultSet rs2= null;
		ResultSet rs3=null;
		
		String qry="select * from period where id=?;";
		try {
			psmt= con.prepareStatement(qry);
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				period.setId(id);
				period.setDay_id(rs.getInt("day_id"));
				period.setSem(rs.getInt("sem"));
				period.setTime(rs.getInt("time"));
				String qry2="select day from day_of_week where day_id=?";
				psmt=con.prepareStatement(qry2);
				psmt.setInt(1, period.getDay_id());
				rs2=psmt.executeQuery();
				while(rs2.next())
				{
					period.setDay(rs2.getString("day"));
				}
				int sub_id;
				sub_id=rs.getInt("sub_id");
				SubjectDao sdao= new SubjectDao();
				
				period.setSubject(sdao.getSubjectFromId(sub_id));
				String qry3="select * from teacher_period where period_id=?";
				psmt=con.prepareStatement(qry3);
				psmt.setInt(1, period.getId());
				rs3=psmt.executeQuery();
				while(rs3.next())
				{
					period.setTeacher_id(rs3.getInt("teacher_id"));
				}
				TeacherDao tdao= new TeacherDao();
				period.setTeacher(tdao.getTeacherFromId(period.getTeacher_id()));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnect.closeConnection(con);
		}
		return period;
	}
	public boolean deletePeriodTable()
	{ boolean result=false;
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		String qry="delete from period";
		try {
			psmt=con.prepareStatement(qry);
			psmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnect.closeConnection(con);
		}
		return result;
		
	}
	public boolean deleteTeacherPeriod()
	{
		boolean result=false;
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		String qry="delete from teacher_period";
		try {
			psmt=con.prepareStatement(qry);
			psmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnect.closeConnection(con);
		}
		return result;
		
		
	}
	public static String getDayFromId(int id)
	{
		String result=null;
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs=null;
		String qry="select day from day_of_week where day_id=?";
		try {
			psmt=con.prepareStatement(qry);
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				result=rs.getString("day");
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
		return result;
	}
	public static ArrayList<String> getWeekDays()
	{
		ArrayList<String> weekdays=new ArrayList<String>();
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		String qry="select * from day_of_week";
		try {
			psmt=con.prepareStatement(qry);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				weekdays.add(rs.getString("day"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
		}
		return weekdays;
	}


}
