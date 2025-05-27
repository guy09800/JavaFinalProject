package personClass;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Stack;
import RuppinLand.*;

public class Tourist extends Person {
	private double height;
	private int[] parkingPlace; 
	private Stack<Ticket> ticketStack;
	
	public Tourist() {
		super();
		height = 0.0;
		parkingPlace = null;
		ticketStack = new Stack<Ticket>();
	}
	
	public Tourist(String id, String name, GregorianCalendar birthday, double height) {
		super(id, name, birthday);
		this.height = height;
		ticketStack = new Stack<Ticket>();
	}
	
	public Tourist(String id, String name, GregorianCalendar birthday, double height, int[] parkingPlace) {
		super(id, name, birthday);
		this.height = height;
		this.parkingPlace = parkingPlace;
		ticketStack = new Stack<Ticket>();
	}
	
	public double getHeight() {return height;}
	public void setHight(double height) {
		if (height < 0) { throw new IllegalArgumentException("Height cannot be negative");}
		
		this.height = height;
	 }
	
	public void setHeight(double height) {this.height = height;}
	public Stack<Ticket> getticketStack() {return ticketStack;}
	public Tourist setticketStack(Stack<Ticket> ticketStack) {
		this.ticketStack = ticketStack;
		return this;
		}
	
	@Override
	public String toString() {return "Tourist:\n" + super.toString() + "\nHeight: " + height + "\nVisit Stack: " + getFormattedVisits();}
	
	@Override
	public void printDetails() {System.out.println(this.toString());}

	public void printDetailsOneLine() {
		System.out.println("Tourist: " + getName() + ", ID: " + getId() + ", BirthDay: "
				+ getBirthday().get(Calendar.DAY_OF_MONTH) + "/" + (getBirthday().get(Calendar.MONTH) + 1) + "/"
				+ getBirthday().get(Calendar.YEAR) + ", Height: " + height + ", Age: " + getAge());
	}
	
	public boolean isLowerThan(double height) {return this.height < height;}
	public boolean isticketStackEmpty() {return ticketStack.isEmpty();}
	public void addToStack(Ticket ticket) {ticketStack.push(ticket);}
	
	public Ticket removeVisit() {
		if (!ticketStack.isEmpty()) 
			return ticketStack.pop();
		 else {
			System.out.println("No visits to remove.");
			return null;
		}
	}
	
	public Ticket getLastVisit() {
		if (!ticketStack.isEmpty()) 
			return ticketStack.peek();
		 else {
			System.out.println("No visits recorded.");
			return null;
		}
	}
	
	public Ticket getFirstVisit() {
		if (!ticketStack.isEmpty())
			return ticketStack.firstElement();
		else {
			System.out.println("No visits recorded.");
			return null;
		}
	}
	
	public int getNumberOfVisits() {return ticketStack.size();}
	
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
	private String getFormattedVisits() {
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
	public int[] getParkingPlace() {
		return parkingPlace;
	}

	public void setParkingPlace(int row, int col) {
		this.parkingPlace = new int[] {row, col};
	}

}
