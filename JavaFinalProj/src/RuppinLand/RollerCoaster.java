package RuppinLand;
import java.util.GregorianCalendar;
import java.util.Scanner;
import personClass.Employee;

public class RollerCoaster extends Ride{
int speedLevel ;


	public RollerCoaster(String name, int minAge, int minHeight, int maxCapacity, int price, GregorianCalendar nextMaintenanceTime, int speedLevel) {
	    super(name, minAge, minHeight, maxCapacity, price, nextMaintenanceTime);
		if (speedLevel < 1 || speedLevel > 3) {
			this.speedLevel = 1;
		}
	    this.speedLevel = speedLevel;
	    
	}
public void scene() throws Exception{
	Scanner scanner = new Scanner(System.in);
	System.out.println("Do you want to stay with current speed level? y/n");
	String change = scanner.nextLine();

	if (!change.equals("y") && !change.equals("n")) {
	    throw new Exception("Wrong input");
	} else if (change.equals("y")) {
	    int newSpeedLevel = 0;
	    while (newSpeedLevel < 1 || newSpeedLevel > 3) {
	        System.out.println("choose level between 1 to 3");
	        try {
	            newSpeedLevel = Integer.parseInt(scanner.nextLine());
	            if (newSpeedLevel < 1 || newSpeedLevel > 3) {
	                System.out.println("Bad input please choose another");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Bad input please choose another");
	        }
	    }
	    setSpeedLevel(newSpeedLevel);
	}
	switch (speedLevel) {
	case 1:
        printLine("🧓 Grandma boards the ride... slowly...");
        printLine("🐢 The wheels creak as the cart starts moving.");
        printLine("🎵 Elevator music starts playing.");
        printLine("😴 A squirrel overtakes us on foot.");
        printLine("📱 Visitors yawn, take selfies, and check emails.");
        break;
	case 2:
        printLine("⚡ The cart jolts forward!");
        printLine("🍟 Someone's fries fly into the air!");
        printLine("😂 Screams and laughter blend together.");
        printLine("📷 *Flash!* Your picture is now forever awkward.");
        printLine("😳 Visitors are nervously laughing and clinging to each other, Someone shouts 'IS THIS ONLY LEVEL 2?!'");
        break;
	case 3:
        printLine("🚀 3... 2... 1... BLAST OFF!");
        printLine("💨 Air whooshes past at warp speed!");
        printLine("😱 Someone’s wig just launched into orbit!");
        printLine("🎢 Loop-de-loops at light speed commence!");
        printLine("😱 Visitors are screaming, crying, and rethinking life.");
        break;
		
	}
			
	
}
	public void setSpeedLevel(int speedLevel) {
	    if (speedLevel < 1 || speedLevel > 3) {
	        throw new IllegalArgumentException("Speed level must be between 1 and 10");
	    }
	    this.speedLevel = speedLevel;
	}
	
	public int getSpeedLevel() {return speedLevel;}
}

