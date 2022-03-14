package app;

import java.util.Scanner;

import dataBase.Conection;
import dataBase.dbController;

public class Main {

	public static void main(String[] args) {
		//DataBase controller
		dbController dbc = new dbController();
		
		//insert Employees to the database
		//insertData();

//select employees with a salary of more than 70.000, more than 10 years of antiquity and less to 15 in the state you pick
System.out.println("----------------------------------------------------------------------------- \n");
System.out.println("Employees with <70.000 salary in this state\n");
dbc.selectEmployeesWithConditions(4); // 4 is the number of the state i choose

//select states with <70.000 salary average
System.out.println("----------------------------------------------------------------------------- \n");
System.out.println("States with a salary average over 70.000");
dbc.selectStatesAVG();;



	}
	
	public static void insertData()
	{
		String	fname;
		String lastname ;
			int salary;
			String phone ;
			String email ;
			int jobPos ;
			int state ;
			int since;
			int flag=1;
			dbController dbc = new dbController();
		
		Scanner scan = new Scanner(System.in);
		
			
		while(flag ==1)
		{
		System.out.println("[Load Employees] \n");
		System.out.println("\n First Name: ");
		fname = scan.nextLine();
		System.out.println("\n Last Name: ");
		lastname = scan.nextLine();
		System.out.println("\n Salary Ammount: ");
		salary = scan.nextInt();
		scan.nextLine();
		System.out.println("\n Phone Number: ");
		phone = scan.nextLine();
		System.out.println("\n Email: ");
		email = scan.nextLine();
		System.out.println("\n Job Number: ");
		jobPos = scan.nextInt();
		System.out.println("\n State Number: ");
		state = scan.nextInt();
		scan.nextLine();
		System.out.println("\n Antiquity (in years): ");
		since = scan.nextInt();
		
		dbc.insert(fname, lastname, salary, phone, email, jobPos, state, since);
		System.out.println("To continue loading employees insert 1, else insert 0");
		flag= scan.nextInt();
		}
	}

}
