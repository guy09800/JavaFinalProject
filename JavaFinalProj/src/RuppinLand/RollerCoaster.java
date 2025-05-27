package RuppinLand;
import java.util.GregorianCalendar;
import java.util.Scanner;
import personClass.Employee;

public class RollerCoaster extends Ride{
int speedLevel ;


	public RollerCoaster(String name, int minAge, int minHeight, int maxCapacity, int price, GregorianCalendar nextMaintenanceTime, int speedLevel) {
	    super(name, minAge, minHeight, maxCapacity, price, nextMaintenanceTime);
	    setSpeedLevel(speedLevel);
	    
	}
public void scene() throws Exception{
	Scanner scanner = new Scanner(System.in);
    System.out.println("Do you want to stay with current speed level? y/n");
	String change = scanner.nextLine();
	if (change != "y" || change != "n") {
		throw new Exception("Wrong input");
	} else if(change == "y") {
		int newSpeedLevel = 0;
		while(newSpeedLevel < 1 || newSpeedLevel >3) {
			newSpeedLevel = scanner.nextInt();
			System.out.println("choose level between 1 to 3");
			System.out.println("Bad input please choose another");
		}
			setSpeedLevel(newSpeedLevel);
	}
	switch (speedLevel) {
	case 1:
        printLine("🧓 Grandma boards the ride... slowly...");
        printLine("🐢 The wheels creak as the cart starts moving.");
        printLine("🎵 Elevator music starts playing.");
        printLine("😴 A squirrel overtakes us on foot.");
        printLine("Cart Getting back to the start line, Visitors looking bored....");
        break;
	case 2:
        printLine("⚡ The cart jolts forward!");
        printLine("🍟 Someone's fries fly into the air!");
        printLine("😂 Screams and laughter blend together.");
        printLine("📷 *Flash!* Your picture is now forever awkward.");
        printLine("Cart Getting back to the start line, Visitors looking joyfull....");
        break;
	case 3:
        printLine("🚀 3... 2... 1... BLAST OFF!");
        printLine("💨 Air whooshes past at warp speed!");
        printLine("😱 Someone’s wig just launched into orbit!");
        printLine("🎢 Loop-de-loops at light speed commence!");
        printLine("Cart Getting back to the start line, Visitors looking terrified....");
        break;
		
	}
			
	
}
	public void setSpeedLevel(int speedLevel) {
	    if (speedLevel < 1 || speedLevel > 10) {
	        throw new IllegalArgumentException("Speed level must be between 1 and 10");
	    }
	    this.speedLevel = speedLevel;
	}
	
	public int getSpeedLevel() {return speedLevel;}
}

