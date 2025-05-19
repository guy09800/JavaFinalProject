package RuppinLand;
import java.security.PublicKey;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

import personClass.Employee;
import personClass.Person;
import personClass.Tourist;
import dataStruct.PersonTree;


public class Main {
    private PersonTree employeeTree;
    private PersonTree visitorsTree;
    private LinkedList<Ride> attractions;
    private List<Object> departments;
    private boolean isOpen;
    private static Scanner scanner = new Scanner(System.in);
    
	public Main() {
		this.employeeTree = new PersonTree();
		this.visitorsTree = new PersonTree();
		this.attractions = new LinkedList<>();
		this.departments = new LinkedList<>();
		this.isOpen = false;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Ruppin Land!");
		//create new departments
		
		// create new 10 tourist
		Main main = new Main();
		Tourist t1 = new Tourist("1", "Alice", new GregorianCalendar(2000, 1, 1), 1.75);
		Tourist t2 = new Tourist("2", "Bob", new GregorianCalendar(1995, 2, 2), 1.80);
		Tourist t3 = new Tourist("3", "Charlie", new GregorianCalendar(1990, 3, 3), 1.65);
		Tourist t4 = new Tourist("4", "David", new GregorianCalendar(1985, 4, 4), 1.70);
		Tourist t5 = new Tourist("5", "Eve", new GregorianCalendar(1980, 5, 5), 1.60);
		Tourist t6 = new Tourist("6", "Frank", new GregorianCalendar(1975, 6, 6), 1.85);
		Tourist t7 = new Tourist("7", "Grace", new GregorianCalendar(1970, 7, 7), 1.55);
		Tourist t8 = new Tourist("8", "Heidi", new GregorianCalendar(1965, 8, 8), 1.90);
		Tourist t9 = new Tourist("9", "Ivan", new GregorianCalendar(1960, 9, 9), 1.50);
		Tourist t10 = new Tourist("10", "Judy", new GregorianCalendar(1955, 10, 10), 1.95);
		// add tourists to the tree
		main.visitorsTree.addPerson(t1);
		main.visitorsTree.addPerson(t2);
		main.visitorsTree.addPerson(t3);
		main.visitorsTree.addPerson(t4);
		main.visitorsTree.addPerson(t5);
		main.visitorsTree.addPerson(t6);
		main.visitorsTree.addPerson(t7);
		main.visitorsTree.addPerson(t8);
		main.visitorsTree.addPerson(t9);
		main.visitorsTree.addPerson(t10);
		
		// create 10 employees
		Employee e1 = new Employee("11", "Kathy", new GregorianCalendar(1990, 1, 1), "Managment", 100);
		Employee e2 = new Employee("12", "Leo", new GregorianCalendar(1985, 2, 2), "Reception", 80);
		Employee e3 = new Employee("13", "Mallory", new GregorianCalendar(1980, 3, 3), "Reception", 90);
		Employee e4 = new Employee("14", "Nina", new GregorianCalendar(1975, 4, 4), "Technician", 70);
		Employee e5 = new Employee("15", "Oscar", new GregorianCalendar(1970, 5, 5), "Operator", 60);
		Employee e6 = new Employee("16", "Peggy", new GregorianCalendar(1965, 6, 6), "Operator", 85);
		Employee e7 = new Employee("17", "Quentin", new GregorianCalendar(1960, 7, 7), "Operator", 75);
		Employee e8 = new Employee("18", "Rupert", new GregorianCalendar(1955, 8, 8), "Managment", 110);
		Employee e9 = new Employee("19", "Sybil", new GregorianCalendar(1950, 9, 9), "Technician", 65);
		Employee e10 = new Employee("20", "Trent", new GregorianCalendar(1945, 10, 10), "Reception", 55);
		// add employees to the tree
		main.employeeTree.addPerson(e1);
		main.employeeTree.addPerson(e2);
		main.employeeTree.addPerson(e3);
		main.employeeTree.addPerson(e4);
		main.employeeTree.addPerson(e5);
		main.employeeTree.addPerson(e6);
		main.employeeTree.addPerson(e7);
		main.employeeTree.addPerson(e8);
		main.employeeTree.addPerson(e9);
		main.employeeTree.addPerson(e10);
		//show all the tourists
		System.out.println("Tourists:");
		main.visitorsTree.printAll();
		//show all the employees
		System.out.println("Employees:");
		main.employeeTree.printAll();
		main.mainMenu();
		
			
	}

	public void mainMenu () {
		while (true) {
			System.out.println("Please enter your ID or 0 to exit:");
			String id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("Are you sure you want to exit? (y/n)");
				String answer = scanner.nextLine();
				if (answer.equals("y")) {
					System.out.println("Goodbye!");
					return;
				} else {continue;}
			}
			Employee employee = (Employee) employeeTree.searchPerson(Integer.parseInt(id));
			if (employee != null) {
				switch (employee.getRole()) {
                    case "Managment":
                    	managmentMenu(employee);
                        break;
                    case "Technician":
                        technicianMenu(employee);
                        break;
                    case "Operator":
                        operatorMenu(employee);
                        break;
                    case "Reception":
                        receptionMenu(employee);
                        break;
                    default:
                        System.out.println("Invalid role.");
                }
            } else {
				System.out.println("Employee not found.");
			}
		}
	}
	public void managmentMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			break;
		}
	}

	public void technicianMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			break;
		}
	}
	public void operatorMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			break;
		}
	}
	public void receptionMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			break;
		}
	}

}