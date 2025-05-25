package personClass;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Person {
	// fields: id, name, birthday, salary
	private String department;
	private double salary;

	// default constructor
	public Employee() {
		super();
		this.department = "";
		this.salary = 0.0;
	}

	// constructor with parameters
	public Employee(String id, String name, GregorianCalendar birthday,String department , double salary) {
		super(id, name, birthday);
		this.department = department;
		this.salary = salary;
	}

	// getters and setters
	public double getSalary() {return salary;}
	public void setSalary(double salary) {this.salary = salary;	}

	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	
	// Override of the abstract method from Person – 
	// prints employee-specific details to the console
	// Override of the toString method to include employee-specific details
	@Override
	public String toString() {
		return "Employee:\n" + super.toString() + "\ndepartment: " + department + "\nSalary: " + salary;
	}
	
	@Override
	public void printDetails() {
	    System.out.println(this.toString());
	}
	public void printDetailsOneLine()
	{
		System.out.println("Employee: " + getName() + ", ID: " + getId() + ", BirthDay: "
				+ getBirthday().get(Calendar.DAY_OF_MONTH) + "/" + (getBirthday().get(Calendar.MONTH) + 1) + "/"
				+ getBirthday().get(Calendar.YEAR) + ", department: " + department + ", Salary: " + salary);
    }

	

}
