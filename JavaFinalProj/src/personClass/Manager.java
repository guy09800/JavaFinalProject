package personClass;

import java.util.LinkedList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Manager extends Employee {
    // fields - list of employees
    private LinkedList<Employee> employeeList;

    // default constructor
    public Manager() {
        super();
        this.employeeList = new LinkedList<>();
    }

    // constructor with parameters
    public Manager(String id, String name, GregorianCalendar birthday,String role, double salary) {
        super(id, name, birthday, role, salary);
        this.employeeList = new LinkedList<>();
    }

    // getter and setter
    public LinkedList<Employee> getEmployeeList() {return employeeList;}

    public void setEmployeeList(LinkedList<Employee> employeeList) {this.employeeList = employeeList;}

    // Add an employee to the list
    public void addEmployee(Employee e) {employeeList.add(e);}

    // Remove an employee from the list
    public boolean removeEmployee(Employee e) {return employeeList.remove(e);}

    // Get the number of employees managed
    public int getNumberOfEmployees() {return employeeList.size();}

    // Helper method to format the employee list
    private String formatEmployeeList() {
        if (employeeList.isEmpty()) 
            return "No employees assigned.";

        StringBuilder sb = new StringBuilder();
        for (Employee e : employeeList) {
            sb.append("- ").append(e.getName())
              .append(" (").append(e.getdepartment()).append(")\n");
        }
        return sb.toString();
    }

    // Override toString
    @Override
    public String toString() {
        return "Manager:\n" + super.toString() +
               "\nEmployees:\n" + formatEmployeeList();
    }

    // Override abstract method from Person
    @Override
    public void printDetails() {
        System.out.println(this.toString());
    }
    
    
 
}
