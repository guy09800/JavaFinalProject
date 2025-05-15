package RuppinLand;
import java.time.LocalDateTime;
import personClass.*;
import java.time.Duration;

import personClass.Person;

public final class Ticket { // Final Class unless we want to inherit from this class.
    
    private int id;
    private Person person;
    private String rideName;
    private double price;
    private LocalDateTime buyDateTime;
    private LocalDateTime playDateTime;

    // Constructor :
    
    public Ticket(int id, Person person, String rideName, double price, LocalDateTime buyDateTime, LocalDateTime playDateTime) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        if (rideName == null) {
            throw new IllegalArgumentException("ride cannot be null.");
        }
        if (buyDateTime == null || playDateTime == null) {
            throw new IllegalArgumentException("Date/time values cannot be null.");
        }
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        
        this.id = id;
        this.person = person;
        this.rideName = rideName;
        this.price = price;
        this.buyDateTime = buyDateTime;
        this.playDateTime = playDateTime;
    }
    
 // Copy Constructor:
    public Ticket(Ticket other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot copy from a null Ticket.");
        }

        this.id = other.id;
        this.person = new Tourist(); // Deep Copy - PERSON CLASS MUST HAVE COPY CTOR!
        this.rideName = other.rideName; // Deep Copy - ATTRACTION CLASS MUST HAVE COPY CTOR! 
        this.price = other.price;
        this.buyDateTime = other.buyDateTime;
        this.playDateTime = other.playDateTime;
    }


    // Methods : 
    
    // Check if ticket is valid -> Play time after purchase time.
    
    public boolean isValid() {
        return playDateTime.isAfter(buyDateTime);
    }

    
    // Return how long is it between purchase and play time in minutes : 
    
    public long getDurationBetweenBuyAndPlayMinutes() {
        return Duration.between(buyDateTime, playDateTime).toMinutes();
    }
    

    // Apply Discount (Percentage Based %) : 
    
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            this.price = price * (1 - percent / 100);
        }
    }
    

    // toString method override – returns a readable summary of the ticket
    
    @Override // Annotation for compiler to override Object's toString().
    public String toString() {
        return "Ticket #" + id + " for " + person.getName() + " to " + rideName + 
               " | Price: " + price + " | Buy: " + buyDateTime + " | Play: " + playDateTime;
    }

    // Getters:
    
    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getRideName() {
        return rideName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getBuyDateTime() {
        return buyDateTime;
    }

    public LocalDateTime getPlayDateTime() {
        return playDateTime;
    }

    // Setters :
    
    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        this.person = person;
    }

	public void setRideName(String rideName) {
		if (rideName == null) {
			throw new IllegalArgumentException("Ride name cannot be null.");
		}
		this.rideName = rideName;
	}

    public void setPrice(double price) {
    	if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
    }

    public void setBuyDateTime(LocalDateTime buyDateTime) {
        if (buyDateTime == null) {
            throw new IllegalArgumentException("Buy date/time cannot be null.");
        }
        this.buyDateTime = buyDateTime;
    }

    public void setPlayDateTime(LocalDateTime playDateTime) {
        if (playDateTime == null) {
            throw new IllegalArgumentException("Play date/time cannot be null.");
        }
        this.playDateTime = playDateTime;
    }
}

