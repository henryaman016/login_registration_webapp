package com.project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAOServiceImpl implements DAOService {
private Connection con;
private Statement stmnt;
	@Override
	public void connectDB() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_documents_10","root","Aman@1998");
		stmnt = con.createStatement();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public boolean verifyCredential(String email, String password) {
	try {
		ResultSet result = stmnt.executeQuery("select * from loginAdmin where email='"+email+"' and password='"+password+"'");
return	result.next();
	} catch (Exception e) {
		// TODO Auto-generated catch bloc
		e.printStackTrace();
	}
		
		return false;
	}

	@Override
	public void verifyUserCredential(String email, String password) {
		// TODO Auto-generated method stub
		
		try {
			
			 stmnt.executeUpdate("insert into studentLogin values('"+email+"','"+password+"')");
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public ResultSet readStudentRegistration() {
		// TODO Auto-generated method stub
		
		try {
			ResultSet result = stmnt.executeQuery("select * from studentInquiry");
		return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateStudentRegistration(String email, String name) {
		// TODO Auto-generated method stub
		try {
			
			 stmnt.executeUpdate("update studentInquiry SET name='"+name+"' where email='"+email+"'");
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteStudentRegistration(String email) {
		// TODO Auto-generated method stub
		try {
			
			 stmnt.executeUpdate("DELETE FROM studentInquiry WHERE email='"+email+"'");
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void verifyStudentCredential(String name, String email, String date, String inquiry_table,
			String inquiry_discription) {
		// TODO Auto-generated method stub
		
		try {
			
			 stmnt.executeUpdate("insert into studentInquiry values('"+name+"','"+email+"','"+date+"','"+inquiry_table+"','"+inquiry_discription+"' )");
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public boolean verifyLoginStudentCredential(String email, String password) {
	
		try {
			ResultSet result = stmnt.executeQuery("select * from studentLogin where email='"+email+"' and password='"+password+"'");
	return	result.next();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ResultSet readLoginRegistration() {
		// TODO Auto-generated method stub
		

		try {
			ResultSet result = stmnt.executeQuery("select * from studentLogin");
		return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
