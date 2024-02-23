package com.databasedao;

import com.details.StudentDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public static int save(StudentDetails SD)
	{
		int status=0;
		try {
		Connection con=DataBaseConnection.getcon();
		PreparedStatement ps=con.prepareStatement("Insert into studentdetails (name,email,sex,course,course_fee,paid,address,phonenumber)values(?,?,?,?,?,?,?,?)");
		ps.setString(1, SD.getName());
		ps.setString(2, SD.getEmail());
		ps.setString(3, SD.getSex());
		ps.setString(4, SD.getCourse());
		ps.setInt(5, SD.getCoursefee());
		ps.setInt(6, SD.getPaid());
		
		ps.setString(7, SD.getAddress());
		ps.setLong(8, SD.getPhonenumber());
		status=ps.executeUpdate();
		con.close();
		}
		catch(Exception ex)
		{System.out.println(ex);
		ex.printStackTrace();
		}
		return status;
		
	}
	
	public static List<StudentDetails> getAllRecords()
	{
		List<StudentDetails> list=new ArrayList<StudentDetails>();
		try
		{
			Connection con=DataBaseConnection.getcon();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM STUDENTDETAILS");
			while(rs.next())
			{
				StudentDetails SD=new StudentDetails();
				SD.setRollno(rs.getInt(1));
				SD.setName(rs.getString(2));
				SD.setEmail(rs.getString(3));
				SD.setSex(rs.getString(4));
				SD.setCourse(rs.getString(5));
				SD.setCoursefee(rs.getInt(6));
				SD.setPaid(rs.getInt(7));
				SD.setAddress(rs.getString(8));
				SD.setPhonenumber(rs.getLong(9));
				SD.setDue(rs.getInt(10));
				list.add(SD);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list;
		}
	
	public static StudentDetails getRecordByRollno(int rollno)
	{
		StudentDetails SD=new StudentDetails();
		try
		{
			Connection con=DataBaseConnection.getcon();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM STUDENTDETAILS WHERE ROLLNO=?");
			ps.setInt(1, rollno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				SD.setRollno(rs.getInt(1));
				SD.setName(rs.getString(2));
				SD.setEmail(rs.getString(3));
				SD.setSex(rs.getString(4));
				SD.setCourse(rs.getString(5));
				SD.setCoursefee(rs.getInt(6));
				SD.setPaid(rs.getInt(7));
				
				SD.setAddress(rs.getString(8));
				SD.setPhonenumber(rs.getLong(9));
				SD.setDue(rs.getInt(10));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return SD;
			
		}
	
	public static StudentDetails getRecordByName(String name)
	{
		StudentDetails SD=new StudentDetails();
		try
		{
			Connection con=DataBaseConnection.getcon();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM STUDENTDETAILS WHERE Name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				SD.setRollno(rs.getInt(1));
				SD.setName(rs.getString(2));
				SD.setEmail(rs.getString(3));
				SD.setSex(rs.getString(4));
				SD.setCourse(rs.getString(5));
				SD.setCoursefee(rs.getInt(6));
				SD.setPaid(rs.getInt(7));
				SD.setAddress(rs.getString(8));
				SD.setPhonenumber(rs.getLong(9));
				SD.setDue(rs.getInt(10));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return SD;
			
		}
	

public static List<StudentDetails> getAllRecordsByDue(int due)
{
	List<StudentDetails> list=new ArrayList<StudentDetails>();
	try
	{
		Connection con=DataBaseConnection.getcon();
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM STUDENTDETAILS WHERE DUE >=?");
		stmt.setInt(1, due);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			StudentDetails SD=new StudentDetails();
			SD.setRollno(rs.getInt(1));
			SD.setName(rs.getString(2));
			SD.setEmail(rs.getString(3));
			SD.setSex(rs.getString(4));
			SD.setCourse(rs.getString(5));
			SD.setCoursefee(rs.getInt(6));
			SD.setPaid(rs.getInt(7));
			SD.setAddress(rs.getString(8));
			SD.setPhonenumber(rs.getLong(9));
			SD.setDue(rs.getInt(10));
			list.add(SD);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
	}

public static int Update(int rollno,int feepay,int paid)
{
	int status =0;
	
	try
	{
		Connection con=DataBaseConnection.getcon();
		PreparedStatement ps=con.prepareStatement("UPDATE STUDENTDETAILS SET PAID=? WHERE ROLLNO=?");
		ps.setInt(1, paid+feepay);
		ps.setInt(2, rollno);
		ps.executeUpdate();
		
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return status;
		
	}




}
		
	


