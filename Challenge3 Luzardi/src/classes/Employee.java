package classes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.mysql.cj.xdevapi.Statement;

import dataBase.Conection;

public class Employee {

String	fname;
String lastname ;
	int salary;
	String phone ;
	String email ;
	int jobPos ;
	int state ;
	int since;
	
	public Employee(String	fname,String lastname ,int salary,String phone ,	String email ,int jobPos ,int state ,int since)
	{
		this.fname = fname;
		this.lastname = lastname;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.since = since;
	}
	public Employee()
	{
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getJobPos() {
		return jobPos;
	}

	public void setJobPos(int jobPos) {
		this.jobPos = jobPos;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getSince() {
		return since;
	}

	public void setSince(int since) {
		this.since = since;
	}
	
}
