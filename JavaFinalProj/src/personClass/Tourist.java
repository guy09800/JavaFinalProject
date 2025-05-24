package personClass;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Stack;
import RuppinLand.*;

public class Tourist extends Person {
	private double height;
	private Stack<Ticket> ticketStack;
	
	// default constructor
	public Tourist() {
		super();
		this.height = 0.0;
		this.ticketStack = new Stack<Ticket>();
	}
	
	// constructor with parameters
	public Tourist(String id, String name, GregorianCalendar birthday, double height) {
		super(id, name, birthday);
		this.height = height;
		this.ticketStack = new Stack<Ticket>();
	}
	
	// getters and setters
	public double getHeight() {return height;}
	 public void setHight(double height) {
			if (height < 0) {
				throw new IllegalArgumentException("Height cannot be negative");
			}
			this.height = height;
	 }
	public void setHeight(double height) {this.height = height;}
	
	public Stack<Ticket> getticketStack() {return ticketStack;}
	public Tourist setticketStack(Stack<Ticket> ticketStack) {
		this.ticketStack = ticketStack;
		return this;
		}
	
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

	public void printDetailsOneLine() {
		// Print all tourist details in a single line
		System.out.println("Tourist: " + getName() + ", ID: " + getId() + ", BirthDay: "
				+ getBirthday().get(Calendar.DAY_OF_MONTH) + "/" + (getBirthday().get(Calendar.MONTH) + 1) + "/"
				+ getBirthday().get(Calendar.YEAR) + ", Height: " + height + ", Age: " + getAge());
	}
	
	
	// method to check if the tourist is lowest than a given height
	public boolean isLowerThan(double height) {return this.height < height;}
	
	
	///----- methods to manage the visit stack -----///
	
	
	// method to check if the stack is empty	
	public boolean isticketStackEmpty() {return ticketStack.isEmpty();}
	
	// method to add a visit to the stack
	public void addVisit(Ticket ticket) {ticketStack.push(ticket);}
	
	
	// method to remove a visit from the stack
	public Ticket removeVisit() {
		if (!ticketStack.isEmpty()) 
			return ticketStack.pop();
		 else {
			System.out.println("No visits to remove.");
			return null;
		}
	}
	
	// method to get the last visit
	public Ticket getLastVisit() {
		if (!ticketStack.isEmpty()) 
			return ticketStack.peek();
		 else {
			System.out.println("No visits recorded.");
			return null;
		}
	}
	// method to get the first visit
	public Ticket getFirstVisit() {
		if (!ticketStack.isEmpty())
			return ticketStack.firstElement();
		else {
			System.out.println("No visits recorded.");
			return null;
		}
	}
	
	// method to get the number of visits
	public int getNumberOfVisits() {return ticketStack.size();}
	
	// method to clear all visits
	public void clearVisits() {ticketStack.clear();}
	
	// method to print all visits
	public void printAllVisits() {
		if (!ticketStack.isEmpty()) {
			System.out.println("Visits:");
			for (Ticket visit : ticketStack) {
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
	    if (ticketStack.isEmpty()) 
		     return "No visits recorded.";
		 

	    // Use a StringBuilder for efficient string construction
	    StringBuilder sb = new StringBuilder("Visits:\n");

	    // Loop through each visit in the stack (from bottom to top)
	    for (Ticket visit : ticketStack) 
	        // Append each visit's date in readable format with a bullet point
            sb.append("- ").append(visit.getBuyDateTime()).append("\n");
		    

	  // Return the complete formatted visit list as a string
	   return sb.toString();
		}

}
