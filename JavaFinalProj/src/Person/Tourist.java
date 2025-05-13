package Person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Stack; 

public class Tourist extends Person {
	// fields: height visit stack
	private double height;
	private Stack<GregorianCalendar> visitStack;
	
	// default constructor
	public Tourist() {
		super();
		this.height = 0.0;
		this.visitStack = new Stack<GregorianCalendar>();
	}
	
	// constructor with parameters
	public Tourist(String id, String name, GregorianCalendar birthday, double height) {
		super(id, name, birthday);
		this.height = height;
		this.visitStack = new Stack<GregorianCalendar>();
	}
	
	// getters and setters
	public double getHeight() {return height;}
	public void setHeight(double height) {this.height = height;}
	
	public Stack<GregorianCalendar> getVisitStack() {return visitStack;}
	public void setVisitStack(Stack<GregorianCalendar> visitStack) {this.visitStack = visitStack;}
	

	
	// Override of the abstract method from Person –
	// prints tourist-specific details to the console
	// Override of the toString method to include tourist-specific details
	@Override
	public String toString() {
		return "Tourist:\n" + super.toString() + "\nHeight: " + height + "\nVisit Stack: " + getFormattedVisits();
	}
	
	@Override
	public void printDetails() {
		System.out.println(this.toString());
	}
	
	// method to check if the tourist is lowest than a given height
	public boolean isLowerThan(double height) {return this.height < height;}
	
	
	///----- methods to manage the visit stack -----///
	
	
	// method to check if the stack is empty	
	public boolean isVisitStackEmpty() {return visitStack.isEmpty();}
	
	// method to add a visit to the stack
	public void addVisit(GregorianCalendar date) {visitStack.push(date);}
	
	
	// method to remove a visit from the stack
	public GregorianCalendar removeVisit() {
		if (!visitStack.isEmpty()) 
			return visitStack.pop();
		 else {
			System.out.println("No visits to remove.");
			return null;
		}
	}
	
	// method to get the last visit
	public GregorianCalendar getLastVisit() {
		if (!visitStack.isEmpty()) 
			return visitStack.peek();
		 else {
			System.out.println("No visits recorded.");
			return null;
		}
	}
	// method to get the first visit
	public GregorianCalendar getFirstVisit() {
		if (!visitStack.isEmpty())
			return visitStack.firstElement();
		else {
			System.out.println("No visits recorded.");
			return null;
		}
	}
	
	// method to get the number of visits
	public int getNumberOfVisits() {return visitStack.size();}
	
	// method to clear all visits
	public void clearVisits() {visitStack.clear();}
	
	// method to print all visits
	public void printAllVisits() {
		if (!visitStack.isEmpty()) {
			System.out.println("Visits:");
			for (GregorianCalendar visit : visitStack) {
				System.out.println(visit);
			}
		} else {
			System.out.println("No visits recorded.");
		}
	}
	
	// Helper method to format the visit stack into a readable string
	// This method is used in toString() instead of printing directly
	private String getFormattedVisits() {
	    // If the stack is empty, return a message indicating no visits
	    if (visitStack.isEmpty()) 
		     return "No visits recorded.";
		 

	    // Use a StringBuilder for efficient string construction
	    StringBuilder sb = new StringBuilder("Visits:\n");

	    // Loop through each visit in the stack (from bottom to top)
	    for (GregorianCalendar visit : visitStack) 
	        // Append each visit's date in readable format with a bullet point
            sb.append("- ").append(visit.getTime()).append("\n");
		    

	  // Return the complete formatted visit list as a string
	   return sb.toString();
		}

	
	
	


}
