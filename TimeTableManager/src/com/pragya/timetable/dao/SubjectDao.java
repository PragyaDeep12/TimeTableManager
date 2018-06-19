package com.pragya.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pragya.timetable.model.Subject;

public class SubjectDao {
	public Subject getSubjectFromId(int sub_id)
	{Subject subject= new Subject();
		Connection con= DBConnect.connect();
		PreparedStatement psmt= null;
		ResultSet rs= null;
		String qry2="select * from m_subject where id=?";
		try {
			psmt=con.prepareStatement(qry2);
			psmt.setInt(1, sub_id);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				
				subject.setId(sub_id);
				subject.setName(rs.getString("name"));
				 subject.setIfLab(rs.getInt("ifLab"));
				 subject.setClasses(rs.getInt("classes"));
				 subject.setSem(rs.getInt("sem"));
				 subject.setSubCode(rs.getString("sub_code"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}
	public List<Subject> selectAllSubject()
	{
		List<Subject> subjectList=new ArrayList<>();
		Connection con=DBConnect.connect();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			psmt=con.prepareStatement("select * from m_subject;");
			 rs=psmt.executeQuery();
			while(rs.next())
			{
				Subject sub=new Subject();
				sub.setId(rs.getInt("id"));
				sub.setName(rs.getString("name"));
				sub.setSubCode(rs.getString("sub_code"));
				sub.setYear(rs.getInt("year"));
				sub.setClasses(rs.getInt("classes"));
				sub.setSem(rs.getInt("sem"));
				sub.setIfLab(rs.getInt("ifLab"));
				subjectList.add(sub);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return subjectList;
	}
	public List<Subject> selectEvenSemOnlyTheory()
	{
		List<Subject> subjectList=new ArrayList<>();
		Connection con=DBConnect.connect();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			psmt=con.prepareStatement("select * from m_subject where sem in (2,4,6,8) and ifLab= 0");
			 rs=psmt.executeQuery();
			while(rs.next())
			{
				Subject sub=new Subject();
				sub.setId(rs.getInt("id"));
				sub.setName(rs.getString("name"));
				sub.setSubCode(rs.getString("sub_code"));
				sub.setYear(rs.getInt("year"));
				sub.setClasses(rs.getInt("classes"));
				sub.setSem(rs.getInt("sem"));
				sub.setIfLab(rs.getInt("ifLab"));
				subjectList.add(sub);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return subjectList;
	}
	
	public boolean insert(Subject sub)
	{
		boolean result=false;
		Connection con=DBConnect.connect();
		PreparedStatement psmt= null;
		try{
			psmt= con.prepareStatement("insert into m_subject (name, sub_code, sem, year, ifLab, classes) values (?,?,?,?,?,?);");
			psmt.setString(1, sub.getName());
			psmt.setString(2, sub.getSubCode());
			psmt.setInt(3, sub.getSem());
			psmt.setInt(4, sub.getYear());
			psmt.setInt(5, sub.getIfLab());
			psmt.setInt(6, sub.getClasses());
			psmt.executeUpdate();
			result=true;
		}
		catch(Exception e)
		{
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
}
