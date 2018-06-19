package com.pragya.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.pragya.timetable.model.TeacherSubject;

public class TSDao {
	public ArrayList<TeacherSubject> getTSListEvenSemTheory()
	{
		ArrayList<TeacherSubject> list= new ArrayList<>();
		Connection con= DBConnect.connect();
		ResultSet rs=null;
		PreparedStatement ps= null;
		try{
			String qry="select t.teacher_id 'teacher_id', t.name 'teacher_name',s.id 'subject_id' ,s.name 'subject_name' from m_teacher t, m_subject s, teacher_subject ts where t.teacher_id =ts.tcode and s.id=ts.subcode and s.sem in (2,4,6,8) and s.ifLab=0; ";
			ps= con.prepareStatement(qry);
			rs=ps.executeQuery();
			while(rs.next())
			{
				TeacherSubject ts= new TeacherSubject();
						ts.setSid(rs.getInt("subject_id"));
						ts.setTname(rs.getString("teacher_name"));
						ts.setSname(rs.getString("subject_name"));
						ts.setTid(rs.getInt("teacher_id"));
						list.add(ts);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnect.closeConnection(con);
			
		}
		return list;
	}
}
