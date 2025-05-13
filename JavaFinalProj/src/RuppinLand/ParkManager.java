package RuppinLand;
import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
import personClass.Person;

import dataStruct.PersonTree;


public class ParkManager {
    private PersonTree personTree;
    private LinkedList<Ride> attractions;
    //private Stack<Ticket> tickets;
    private Queue<Person> entryQueue;
    //private List<Department> departments;
    private boolean isOpen;
    private static Scanner scanner = new Scanner(System.in);
    
	public ParkManager() {
		this.personTree = new PersonTree();
		this.attractions = new LinkedList<>();
		//this.tickets = new Stack<>();
		this.entryQueue = new LinkedList<>();
		//this.departments = new LinkedList<>();
		this.isOpen = false;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Ruppin Land!");
		ParkManager parkManager = new ParkManager();
		parkManager.mainMenu();
	}

	public void mainMenu () {
		System.out.println("Welcome to Ruppin Land!");
		// get ID and show menu for employee or for visitor
		System.out.println("Please enter your ID:");
		int id = 0;
		try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a valid number.");
            return;
        }
		Person person = personTree.searchPerson(id);
		if (person == null) {
			System.out.println("Person not found. Please register first.");
			return;
		}
		//check if person is employee or visitor or manager
		//continue here..
	}

	public void visitorMenu(Person person) {
		System.out.println("Welcome " + person.getName() + "!");
		System.out.println("Please choose an option:");
		System.out.println("Please choose an option:");
		System.out.println("1. Get into line of attraction	2. Get out of line of attraction");
		System.out.println("3. Visitor stats		4. Check queue status");
		System.out.println("5. Change height		6. Change age");
		System.out.println("7. Exit");
		int choice = 0;
		try {
			choice = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid choice. Please enter a valid number.");
			return;
		}
		switch (choice) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
		
	}
	public void employeeMenu(Person person) {
		System.out.println("Welcome " + person.getName() + "!");
		System.out.println("Please choose an option:");
		System.out.println("1. Check queue status		2. Move queue");
		System.out.println("3. Check attraction status	4. fix attraction");
		System.out.println("5. Sell tickets			6. Exit");
		int choice = 0;
		try {
			choice = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid choice. Please enter a valid number.");
			return;
		}
		switch (choice) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

	public void managerMenu(Person person) {
		System.out.println("Welcome " + person.getName() + "!");
		System.out.println("Please choose an option:");
		System.out.println("1. Add new attraction		2. Add new department");
		System.out.println("3. Add new employee		4. Add new visitor");
		System.out.println("5. Close park			6. Change person data");
		System.out.println("7. Park stats			8. Exit");
		int choice = 0;
		try {
			choice = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid choice. Please enter a valid number.");
			return;
		}
		switch (choice) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}

	}
	
}
