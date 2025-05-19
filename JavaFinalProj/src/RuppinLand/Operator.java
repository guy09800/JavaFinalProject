package RuppinLand;

import dataStruct.PersonTree;
import dataStruct.TreeNode;
import personClass.Employee;
import personClass.Tourist;

public class Operator implements department {

    private String name;

    // Constructor
    public Operator(String name) {
        this.name = name;
    }

    // Getter
    @Override
    public String getName() {
        return name;
    }

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
	
    @Override
    public void handleCustomer(Tourist tourist, Ride ride) {
        System.out.println("Operator is assisting tourist " + tourist.getName() + " with queue and ride entry.");
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

