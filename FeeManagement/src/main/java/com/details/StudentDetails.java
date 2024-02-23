package com.details;

public class StudentDetails {
	private int rollno,coursefee,paid,due;
	private String name,email,sex,course,address;
	private long phonenumber;
	
	public StudentDetails()
	{
		super();
		
	}

	public StudentDetails(String name,String email, String sex, String course, int coursefee, int paid, String address, long phonenumber)
	{
		super();
		this.name=name;
		this.email=email;
		this.sex=sex;
		this.course=course;
		this.coursefee=coursefee;
		this.paid=paid;
		
		this.address=address;
		this.phonenumber=phonenumber;
	}
	public StudentDetails(int rollno, String name,String email, String sex, String course, int coursefee, int paid, String address, long phonenumber,int due)
	{
		super();
		this.rollno=rollno;
		this.name=name;
		this.email=email;
		this.sex=sex;
		this.course=course;
		this.coursefee=coursefee;
		this.paid=paid;
		
		this.address=address;
		this.phonenumber=phonenumber;
		this.due=due;
	}
	
	public int getRollno()
	{
		return rollno;
	}
	public void setRollno(int rollno)
	{
		this.rollno=rollno;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getCourse()
	{
		return course;
	}
	public void setCourse(String course)
	{
		this.course=course;
		
	}
	public int getCoursefee()
	{
		return coursefee;
	}
	public void setCoursefee(int coursefee)
	{
		this.coursefee=coursefee;
	}
	public int getPaid()
	{
		return paid;
	}
	public void setPaid(int paid)
	{
		this.paid=paid;
		
	}
	
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public long getPhonenumber()
	{
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber)
	{
		this.phonenumber=phonenumber;
	}
	public int getDue()
	{
		return due;
	}
	public void setDue(int due)
	{
		this.due=due;
	}

}
