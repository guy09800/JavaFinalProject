package RuppinLand;

import java.util.Date;
import java.util.Queue;

import personClass.Person;

public abstract class Ride implements Attraction {
	String name;
	int minAge;
	int minHeight;
	int maxCapacity;
	int currentCapacity;
	Queue<Person> queue;
	Date nextMaintenanceTime;
	
	
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

	public void setNextMaintenanceTime(Date nextMaintenanceTime) {
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

	public Date getNextMaintenanceTime() {
		return nextMaintenanceTime;
	}
	
}
