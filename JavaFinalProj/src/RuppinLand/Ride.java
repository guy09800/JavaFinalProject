package RuppinLand;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Queue;

import personClass.Person;

public abstract class Ride{
	String name;
	int minAge;
	int minHeight;
	int maxCapacity;
	int currentCapacity;
	int price;
	Queue<Person> queue;
	GregorianCalendar nextMaintenanceTime;
	boolean isOpen;
	
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		this.name = name;
	}

	public void setMaxCapacity(int maxCapacity) {
		if (maxCapacity <= 0) {
			throw new IllegalArgumentException("Max capacity must be greater than 0");
		}
		this.maxCapacity = maxCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		if (currentCapacity < 0 || currentCapacity > maxCapacity) {
			throw new IllegalArgumentException("Current capacity must be between 0 and max capacity");
		}
		this.currentCapacity = currentCapacity;
	}

	public Queue<Person> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Person> queue) {
		if (queue == null) {
			throw new IllegalArgumentException("Queue cannot be null");
		}
		this.queue = queue;
	}

	public void setMinAge(int minAge) {
		if (minAge < 0) {
			throw new IllegalArgumentException("Minimum age cannot be negative");
		}
		this.minAge = minAge;
	}

	public void setMinHeight(int minHeight) {
		if (minHeight < 0) {
			throw new IllegalArgumentException("Minimum height cannot be negative");
		}
		this.minHeight = minHeight;
	}

	public void setNextMaintenanceTime(GregorianCalendar nextMaintenanceTime) {
		if (nextMaintenanceTime == null) {
			throw new IllegalArgumentException("Next maintenance time cannot be null");
		}
		this.nextMaintenanceTime = nextMaintenanceTime;
	}

	public String getName() {
		return name;
	}

	public int getMinAge() {
		return minAge;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public GregorianCalendar getNextMaintenanceTime() {
		return nextMaintenanceTime;
	}

	public void printDetails() {
		System.out.println("Ride Name: " + name);
		System.out.println("Minimum Age: " + minAge);
		System.out.println("Minimum Height: " + minHeight);
		System.out.println("Max Capacity: " + maxCapacity);
		System.out.println("Current Capacity: " + currentCapacity);
		System.out.println("Next Maintenance Time: " + nextMaintenanceTime.getTime());
		System.out.println("Is Open: " + isOpen);
	}

	public boolean isOpen() {
		return isOpen;
	}
	
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		this.price = price;
	}
	
}
