package dataBase;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classes.*;
 
public class dbController {
    private Conection conection;
    private Employee emp;
    private Connection con;
     
    public dbController(){
    	conection = new Conection();
        emp = new Employee();
    }
    
    
    
     
    public void insert(String	fname,String lastname ,int salary,String phone ,	String email ,int jobPos ,int state , int since){
        PreparedStatement ps;
        String sql;
    
        emp.setFname(fname);
        emp.setLastname(lastname);
        emp.setSalary(salary);
        emp.setPhone(phone);
        emp.setEmail(email);
        emp.setJobPos(jobPos);
        emp.setState(state);
        emp.setSince(since);
      
        try{
            con = conection.getConnection();
            sql = "insert into employees(	fname, lastname , salary, phone , email , jobPos , state , since) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, emp.getFname());
            ps.setString(2, emp.getLastname());
            ps.setInt(3, emp.getSalary());
            
            ps.setString(4, emp.getPhone());
            ps.setString(5, emp.getEmail());
            ps.setInt(6, emp.getJobPos());
    
            ps.setInt(7, emp.getState());
            ps.setInt(8, emp.getSince());
          
            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
    }
    
    
    
    public void selectEmployeesWithConditions(int state) {
    	Connection con = conection.getConnection();
    	
    
    	
    	try {
    		//this select is for catch the state name from the other table
    		   String statename ="";
    		   String sqL = "select sname \r\n"
    	 		   		+ "from states s\r\n"
    	 		   		+ "where s.id = " + state+";";
    	 		   PreparedStatement stmt =  con.prepareStatement(sqL);
    	 		   ResultSet res = stmt.executeQuery(sqL);
    	 		  while (res.next())
    	 			  statename = res.getString("sname");
    	 		 
    	 		//this select is for catch employees that reach the conditions
    		   String sql = "select fname, lastname, phone, email, jobPos, state \r\n"
    		   		+ "from employees e\r\n"
    		   		+ "where e.salary >70000 and e.since >10 and e.since <15 and state = " + state+";";
    		   PreparedStatement stmtt =  con.prepareStatement(sql);
    		   ResultSet rs = stmtt.executeQuery(sql);

    		   while (rs.next()) {
    			
    		   System.out.println( "Name: " + rs.getString("fname") + "\n LastName: " + rs.getString("lastname") + "\n Phone " + rs.getString("phone") + "\n Email: " + rs.getString("email")+ "\n JobPosition Num: " + rs.getInt("jobPos") + "\n State :  "+statename+ " \n");
    		}
    		  
    		  rs.close();
    		  stmt.close();
    		}
    		catch (Exception e) {
    		  e.printStackTrace();
    		}
    		}
    
    //Select the states with <70.000 salary average
    public void selectStatesAVG() {
    	Connection con = conection.getConnection();
    	
        	try {
    	
    		   String sql = "SELECT sname, state , AVG(salary) as \"Salary Average\"\r\n"
    		   		+ "    FROM employees e\r\n"
    		   		+ "  join states s on (s.id = e.state)\r\n"
    		   		+ "   GROUP BY state\r\n"
    		   		+ "   having (AVG(salary)>70000);";
    		   PreparedStatement stmtt =  con.prepareStatement(sql);
    		   ResultSet rs = stmtt.executeQuery(sql);

    		   while (rs.next()) {
    			
    		   System.out.println( "Name: " + rs.getString("sname") + ",  Salary Average: " + rs.getString("Salary Average"));
    		}
    		  
    		  rs.close();
    		  stmtt.close();
    		}
    		catch (Exception e) {
    		  e.printStackTrace();
    		}
    		}
    
    
    
}
