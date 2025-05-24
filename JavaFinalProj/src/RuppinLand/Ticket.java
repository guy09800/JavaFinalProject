package RuppinLand;
import java.util.Calendar;
import java.util.GregorianCalendar;// switch to gregorian GUY
import personClass.*;
import java.time.Duration;


public final class Ticket { // Final Class unless we want to inherit from this class.
    
    private String rideName;
    private double price;
    private GregorianCalendar buyDateTime;
    private GregorianCalendar playDateTime;

    // Constructor :
    
    public Ticket(String rideName, double price, GregorianCalendar buyDateTime, GregorianCalendar playDateTime) {
        if (rideName == null) {
            throw new IllegalArgumentException("ride cannot be null.");
        }
        if (buyDateTime == null) {
            throw new IllegalArgumentException("Date/time values cannot be null.");
        }
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");

        this.rideName = rideName;
        this.price = price;
        this.buyDateTime = buyDateTime;
        this.playDateTime = new GregorianCalendar(9999, Calendar.DECEMBER, 31);// a far year so until the play time it would be valid
    }
    
 // Copy Constructor:
    public Ticket(Ticket other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot copy from a null Ticket.");
        }

        this.rideName = other.rideName; // Deep Copy - ATTRACTION CLASS MUST HAVE COPY CTOR! 
        this.price = other.price;
        this.buyDateTime = other.buyDateTime;
        this.playDateTime = other.playDateTime;
    }


    // Methods : 
    
    // Check if ticket is valid -> Play time after purchase time.
    
    public boolean isValid() {
        return buyDateTime.compareTo(playDateTime)> 0;
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
        return "Ticket #" +" to " + rideName + " | Price: " + price + " | Buy: " + buyDateTime + " | Play: " + playDateTime;
    }

    // Getters:

    public String getRideName() {
        return rideName;
    }

    public double getPrice() {
        return price;
    }

    public GregorianCalendar getBuyDateTime() {
        return buyDateTime;
    }

    public GregorianCalendar getPlayDateTime() {
        return playDateTime;
    }

    // Setters :

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

    public void setBuyDateTime(GregorianCalendar buyDateTime) {
        if (buyDateTime == null) {
            throw new IllegalArgumentException("Buy date/time cannot be null.");
        }
        this.buyDateTime = buyDateTime;
    }

    public void setPlayDateTime(GregorianCalendar playDateTime) {
        if (playDateTime == null) {
            throw new IllegalArgumentException("Play date/time cannot be null.");
        }
        this.playDateTime = playDateTime;
    }
}

