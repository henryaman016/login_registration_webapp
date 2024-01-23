package com.project.model;

import java.sql.ResultSet;

public interface DAOService {

public	void connectDB();

public boolean verifyCredential(String email, String password);

public void verifyUserCredential(String email, String password);

public ResultSet readStudentRegistration();

public void updateStudentRegistration(String email, String name);

public void deleteStudentRegistration(String email);

public void verifyStudentCredential(String name, String email, String date, String inquiry_table,
		String inquiry_discription);

public boolean verifyLoginStudentCredential(String email, String password);

public ResultSet readLoginRegistration();

}
