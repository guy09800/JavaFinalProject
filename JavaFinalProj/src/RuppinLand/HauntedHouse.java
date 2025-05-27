package RuppinLand;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class HauntedHouse extends Ride{

	int scareLevel ;
	
	public HauntedHouse(String name, int minAge, int minHeight, int maxCapacity, int price,
			GregorianCalendar nextMaintenanceTime, int scareLevel) {
		super(name, minAge, minHeight, maxCapacity, price, nextMaintenanceTime);
		if (scareLevel < 1 || scareLevel > 3) {
			this.scareLevel = 1;
		}
	    this.scareLevel = scareLevel;
	    
	}
	public void scene() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to stay with current scare level? y/n");
		String change = scanner.nextLine();

		if (!change.equals("y") && !change.equals("n")) {
		    throw new Exception("Wrong input");
		} else if (change.equals("y")) {
		    int newScareLevel = 0;
		    while (newScareLevel < 1 || newScareLevel > 3) {
		        System.out.println("choose level between 1 to 3");
		        try {
		        	newScareLevel = Integer.parseInt(scanner.nextLine());
		            if (newScareLevel < 1 || newScareLevel > 3) {
		                System.out.println("Bad input please choose another");
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("Bad input please choose another");
		        }
		    }
		    setScareLevel(newScareLevel);
		}
		switch (scareLevel) {
		case 1:
            printLine("🕯️ You enter a dimly lit room... the walls creak.");
            printLine("💀 A plastic skeleton gently sways from the ceiling.");
            printLine("📼 A recording plays: 'Boo... I guess?'.");
            printLine("😴 Someone sneezes in the distance. That’s it.");
            printLine("🙂 Visitors giggle and check their phones.");
	        break;
		case 2:
			   printLine("🔦 The lights flicker as you step inside.");
               printLine("🖼️ A portrait's eyes follow you... or do they?");
               printLine("🧹 Suddenly, a broom falls over and scares everyone.");
               printLine("🧸 A creepy doll whispers, 'Wanna play?'");
               printLine("😬 Visitors huddle together and whisper, 'Okay... that was weird.'");
	        break;
		case 3:
            printLine("🚪 The door slams shut behind you. Locked!");
            printLine("🧊 A cold hand grabs your shoulder—no one's there.");
            printLine("😱 A ghost screams from the ceiling. Upside-down.");
            printLine("🪞 You look in the mirror and see... your own grave.");
            printLine("😵 Visitors scream, run in circles, and one drops their popcorn.");
	        break;
		}
			
		}

	public void setScareLevel(int scareLevel) {
		if (scareLevel < 1 || scareLevel > 3) {
			throw new IllegalArgumentException("Scare level must be between 1 and 3");
		}
		this.scareLevel = scareLevel;
	}

	public int getScareLevel() {return scareLevel;}

}
