package personClass;

import java.util.Calendar;
import java.util.GregorianCalendar;

import dataStruct.PersonTree;

public class Employee extends Person {
	private String department;
	private double salary;

	public Employee() {
		super();
		department = "";
		salary = 0.0;
	}

	public Employee(String id, String name, GregorianCalendar birthday,String department , double salary) {
		super(id, name, birthday);
		this.department = department;
		this.salary = salary;
	}

	public double getSalary() {return salary;}
	public void setSalary(double salary) {this.salary = salary;	}
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	
	@Override
	public String toString() {return "Employee:\n" + super.toString() + "\ndepartment: " + department + "\nSalary: " + salary;}
	
	@Override
	public void printDetails() {System.out.println(this.toString());}
	
	public void printDetailsOneLine()
	{
		System.out.println("Employee: " + getName() + ", ID: " + getId() + ", BirthDay: "
				+ getBirthday().get(Calendar.DAY_OF_MONTH) + "/" + (getBirthday().get(Calendar.MONTH) + 1) + "/"
				+ getBirthday().get(Calendar.YEAR) + ", department: " + department + ", Salary: " + salary);
    }
	public static Employee createEmployee(PersonTree tree) {
		return null;
	}
}
