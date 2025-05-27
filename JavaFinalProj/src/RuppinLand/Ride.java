package RuppinLand;
import personClass.*;
import java.util.GregorianCalendar;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;



public abstract class Ride{
	String name;
	int minAge;
	int minHeight;
	int maxCapacity;
	int price;
	int totalMoneyMadeToday = 0;
	Queue<Tourist> queue;
	GregorianCalendar nextMaintenanceTime;
	boolean isOpen = false;
	
	public Ride(String name, int minAge, int minHeight, int maxCapacity, int price, GregorianCalendar nextMaintenanceTime) {
		setName(name);
		setMinAge(minAge);
		setMinHeight(minHeight);
		setMaxCapacity(maxCapacity);
		setPrice(price);
		setNextMaintenanceTime(nextMaintenanceTime);
		this.queue = new LinkedList<Tourist>();
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {throw new IllegalArgumentException("Name cannot be null or empty");}
		
		this.name = name;
	}

	public void setMaxCapacity(int maxCapacity) {
		if (maxCapacity <= 0) {throw new IllegalArgumentException("Max capacity must be greater than 0");}
		
		this.maxCapacity = maxCapacity;
	}

	public int getMaxCapacity() {return maxCapacity;}
	public void  printQueue() {
		if (queue.isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			System.out.print(name + " Queue: ");
			for (Tourist tourist : queue) {
				System.out.print(tourist.getName() + " <- ");
			}
			System.out.println("end (" + queue.size() + " tourists in queue)");
		}
	}

	public void setQueue(Queue<Tourist> queue) {
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
		if (minHeight < 0) {throw new IllegalArgumentException("Minimum height cannot be negative");}
		this.minHeight = minHeight;
	}

	public void setNextMaintenanceTime(GregorianCalendar nextMaintenanceTime) {
		if (nextMaintenanceTime == null) {throw new IllegalArgumentException("Next maintenance time cannot be null");}
		this.nextMaintenanceTime = nextMaintenanceTime;
	}

	public String getName() {return name;}
	public int getMinAge() {return minAge;}
	public int getMinHeight() {return minHeight;}
	public GregorianCalendar getNextMaintenanceTime() {return nextMaintenanceTime;}

	public void printDetails() {
		System.out.println("Ride Name: " + name);
		System.out.println("Minimum Age: " + minAge);
		System.out.println("Minimum Height: " + minHeight);
		System.out.println("Max Capacity: " + maxCapacity);
		System.out.println("Next Maintenance Time: " + nextMaintenanceTime.getTime());
		System.out.println("Is Open: " + isOpen);
	}

	public boolean isOpen() {return isOpen;}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
		if (!isOpen) {
            //for each tourist in the queue, remove them and delete his last ticket in the stack
			while (!queue.isEmpty()) {
				Tourist tourist = queue.remove();
                if (!tourist.getticketStack().isEmpty()) {
                    tourist.getticketStack().pop();
                    System.out.println("Removed ticket for " + tourist.getName() + " as the ride is closed.");
                }
			}
		}
    }
	public int getPrice() {return price;}

	public void setPrice(int price) {
		if (price < 0) {throw new IllegalArgumentException("Price cannot be negative");}
		this.price = price;
	}
	
	public void addToLine(Tourist tourist) throws Exception {
		//check if ride is open
		if (!isOpen()) 
			throw new Exception("Ride " + getName() + " is closed.");
		// check if visitor is at the right age
		if (tourist.getAge() < getMinAge()) 
			throw new Exception("Tourist " + tourist.getName() + " is not old enough for ride " + getName() + ".");
		// check if visitor is at the right height
		if (tourist.getHeight() < getMinHeight()) 
			throw new Exception("Tourist " + tourist.getName() + " is not tall enough for ride "+ getName() + ".");
		// check if visitor is already at the queue
		if (queue.contains(tourist))
			throw new Exception("Visitor is already in queue...");
		// check if queue is full
		if (queue.size() >= maxCapacity)
			throw new Exception("Queue is full, cannot add tourist " + tourist.getName() + " to ride " + getName() + ".");
		// check if the top ticket in the tourist's stack is null if it is that mean he stand in other ride queue
		if (!tourist.getticketStack().isEmpty() && tourist.getticketStack().peek() == null )
			throw new Exception("Tourist " + tourist.getName() + " stand in another ride queue");
		//adding to queue
		queue.add(tourist);
		System.out.println("Visitor has been added to queue");
		totalMoneyMadeToday += price;
		return;
	}

	public void operate(){
		
		if (queue.isEmpty())
				System.out.println("Queue is empty, no tourists to move forward");
			
		for (int i = 0; i <= maxCapacity; i++) {
				 Tourist tourist =queue.remove();
				 Ticket ticket = tourist.getticketStack().peek();
				 ticket.setPlayDateTime(new GregorianCalendar());
		}
	}
    public void removeFromQueue(Tourist tourist) {
        if (tourist == null) {
        	return;
        }
		if (queue.contains(tourist)) {
			queue.remove(tourist);
			System.out.println("Tourist " + tourist.getName() + " has been removed from the queue.");
			if (!tourist.getticketStack().isEmpty()) {
				tourist.getticketStack().pop();
				System.out.println("Ticket for " + tourist.getName() + " has been removed from their stack.");
				totalMoneyMadeToday -= price;
			}
		} else {
			System.out.println("Tourist " + tourist.getName() + " is not in the queue.");
		}
    }
    public int howMuchMoneyMadeToday() {
    	return 0;
    
    }
}
