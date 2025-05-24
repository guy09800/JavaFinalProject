package RuppinLand;
import java.util.GregorianCalendar;

public class RollerCoaster extends Ride{
int speedLevel ;

	public RollerCoaster(String name, int minAge, int minHeight, int maxCapacity, int price, GregorianCalendar nextMaintenanceTime, int speedLevel) {
	    super(name, minAge, minHeight, maxCapacity, price, nextMaintenanceTime);
	    setSpeedLevel(speedLevel);
	    
	}

	public void setSpeedLevel(int speedLevel) {
	    if (speedLevel < 1 || speedLevel > 10) {
	        throw new IllegalArgumentException("Speed level must be between 1 and 10");
	    }
	    this.speedLevel = speedLevel;
	}
	
	public int getSpeedLevel() {
	    return speedLevel;
	}
}

