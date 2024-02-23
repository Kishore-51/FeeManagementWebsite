
package com.databasedao;

import java.sql.*;

import com.details.AccountantDetails;



import java.util.*;


public class AccountantDao {
	
	public static int save(AccountantDetails AD)
	{
		int status=0;
		try{
			Connection con=DataBaseConnection.getcon();
			PreparedStatement ps=con.prepareStatement("insert into fee_accountant(firstname, lastname, email, password, address,phonenumber, gender) values(?,?,?,?,?,?,?)");
			ps.setString(1,AD.getFirstname());
			ps.setString(2,AD.getLastname());
			ps.setString(3,AD.getEmail());
			ps.setString(4,AD.getPassword());
			ps.setString(5,AD.getAddress());
			ps.setLong(6,AD.getPhonenumber());
			ps.setString(7, AD.getGender());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{System.out.println(ex);
		ex.printStackTrace();
		}
		
		return status;
	}
	public static List<AccountantDetails> getAllRecords(){
		List<AccountantDetails> list=new ArrayList<AccountantDetails>();
		try{
			Connection con=DataBaseConnection.getcon();
			PreparedStatement ps=con.prepareStatement("select * from fee_accountant");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AccountantDetails bean=new AccountantDetails();
				//bean.setId(rs.getInt(1));
				bean.setFirstname(rs.getString(1));
				bean.setLastname(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setPhonenumber(rs.getLong(6));
				bean.setGender(rs.getString(7));
				list.add(bean);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list;
	}
	public static boolean validate(String email,String password){
		boolean status=false;
		try{
			Connection con=DataBaseConnection.getcon();
			PreparedStatement ps=con.prepareStatement("select * from fee_accountant where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	
	public static int delete(String email )
	{
		int status=0;
		try
		{
			Connection con=DataBaseConnection.getcon();
			PreparedStatement ps=con.prepareStatement("delete from fee_accountant where email=?");
			ps.setString(1,email);
			status=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception ex){System.out.println(ex);}
		return status;
	}

}

