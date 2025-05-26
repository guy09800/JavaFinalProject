package RuppinLand;

import java.util.GregorianCalendar;

public class HauntedHouse extends Ride{

	int scareLevel ;
	
	public HauntedHouse(String name, int minAge, int minHeight, int maxCapacity, int price,
			GregorianCalendar nextMaintenanceTime, int scareLevel) {
		super(name, minAge, minHeight, maxCapacity, price, nextMaintenanceTime);
		setScareLevel(scareLevel);
	}

	public void setScareLevel(int scareLevel) {
		if (scareLevel < 1 || scareLevel > 10) {
			throw new IllegalArgumentException("Scare level must be between 1 and 10");
		}
		this.scareLevel = scareLevel;
	}

	public int getScareLevel() {return scareLevel;}

}
