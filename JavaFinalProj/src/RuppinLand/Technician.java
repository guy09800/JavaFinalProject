package RuppinLand;

import java.util.Scanner;

import personClass.Tourist;
import personClass.Employee;
import dataStruct.*;

public class Technician implements department {
	
	private String name;
	
	// Constructor : 
	
    public Technician(String name) {
        this.name=name;
    }
    
    // Getter :
    
	@Override 
	public String getName() {
		return name;
	}

	
	// Class Methods : 

    @Override
	public void printDetails(PersonTree employeeTree) {
    	
	    System.out.println(this.name + " Department - Full Employee Details:");
	    
	    boolean OneLine = false; 
	    
	    employeeTree.printByDepartment(this.name,OneLine);
	    
	}

	@Override
	public void printDetailsOneLine(PersonTree employeeTree) {
		
	    System.out.println(this.name + " Department - One-Line Employee Summaries:");
	    
	    boolean OneLine = true;
	    
	    employeeTree.printByDepartment(this.name,OneLine);
	    
	}
	
	
	public void handleCustomer(Tourist tourist, Ride ride) {
		 Scanner scanner = new Scanner(System.in);
	System.out.println("what is the complaint?");
    String complaint = scanner.nextLine();
    System.out.println("choose if the to close the ride or not");
    System.out.println("1. yes	2. no");
    int choice2 = scanner.nextInt();
    scanner.nextLine();
	if (choice2 == 1) {
		ride.setOpen(false);
		System.out.println("Ride " + ride.getName() + " is now closed.");
	} else if (choice2 == 2) {
		System.out.println("Ride " + ride.getName() + " is still open.");
	} else {
		System.out.println("Invalid choice.");
    }
	}
	
	@Override
	public void closeRide(Ride ride) {
		ride.setOpen(false);
	}

	@Override
	public void openRide(Ride ride) {
		ride.setOpen(true);
	}

}
