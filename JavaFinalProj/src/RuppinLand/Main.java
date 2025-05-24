package RuppinLand;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

import personClass.Employee;
import personClass.Person;
import personClass.Tourist;
import dataStruct.PersonTree;

public class Main {
    private PersonTree employeeTree;
    private PersonTree visitorsTree;
    private boolean isOpen;
    private static LinkedList<Ride> attractions;
    private static List<Object> departments;
    private static Scanner scanner = new Scanner(System.in);
    
    
    // Constructor : 
    
	public Main() {
		this.employeeTree = new PersonTree();
		this.visitorsTree = new PersonTree();
		this.attractions = new LinkedList<>();
		this.departments = new LinkedList<>();
		this.isOpen = false;
	}

	
	// Main : 
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		// create new departments:
	    Technician technician = new Technician("Technician");
	    Operator operator = new Operator("Operator");
	    Reception reception = new Reception("Reception");
	    Management management = new Management("Management");
	    // Add departments to the list
	    departments.add(technician);
	    departments.add(operator);
	    departments.add(reception);
	    departments.add(management);
		// create new 6 attractions:
		attractions.add(new RollerCoaster("Black Mamba", 10, 120, 20, 50, new GregorianCalendar(2024, 5, 1), 8));
		attractions.add(new RollerCoaster("Anaconda", 7, 115, 15, 30, new GregorianCalendar(2024, 7, 7), 5));
		attractions.add(new FerrysWheel("Giant Wheel", 5, 100, 10, 20, new GregorianCalendar(2024, 6, 15)));
		attractions.add(new FerrysWheel("Sky Wheel", 6, 110, 12, 25, new GregorianCalendar(2024, 8, 20)));
		attractions.add(new HauntedHouse("Ghost House", 12, 130, 25, 40, new GregorianCalendar(2024, 4, 10), 7));
		attractions.add(new HauntedHouse("Scary Mansion", 14, 140, 30, 60, new GregorianCalendar(2024, 3, 5), 9));
		//create 3 ticket stacks for the attractions:
		Stack<Ticket> ticketStack1 = new Stack<>();
		Stack<Ticket> ticketStack2 = new Stack<>();
		Stack<Ticket> ticketStack3 = new Stack<>();
		// add to the stack tickets with the last paramater the time of now:
		ticketStack1.add(new Ticket("Black Mamba", 50, new GregorianCalendar(), new GregorianCalendar()));
		ticketStack1.add(new Ticket("Sky Wheel", 20, new GregorianCalendar(), new GregorianCalendar()));
		ticketStack1.add(new Ticket("Ghost House", 40, new GregorianCalendar(), null));
		ticketStack2.add(new Ticket("Anaconda", 30, new GregorianCalendar(), new GregorianCalendar()));
		ticketStack2.add(new Ticket("Giant Wheel", 25, new GregorianCalendar(), new GregorianCalendar()));
		ticketStack2.add(new Ticket("Scary Mansion", 60, new GregorianCalendar(), null));
		ticketStack3.add(new Ticket("Black Mamba", 50, new GregorianCalendar(), new GregorianCalendar()));
		ticketStack3.add(new Ticket("Anaconda", 30, new GregorianCalendar(), new GregorianCalendar()));
		ticketStack3.add(new Ticket("Ghost House", 40, new GregorianCalendar(), null));
		// create new 10 tourists:
		main.visitorsTree.addPerson(new Tourist("1", "Alice", new GregorianCalendar(2000, 1, 1), 1.75).setticketStack(ticketStack1));
		main.visitorsTree.addPerson(new Tourist("2", "Bob", new GregorianCalendar(1995, 2, 2), 1.80).setticketStack(ticketStack2));
		main.visitorsTree.addPerson(new Tourist("3", "Charlie", new GregorianCalendar(1990, 3, 3), 1.65).setticketStack(ticketStack3));
		main.visitorsTree.addPerson(new Tourist("4", "David", new GregorianCalendar(1985, 4, 4), 1.70));
		main.visitorsTree.addPerson(new Tourist("5", "Eve", new GregorianCalendar(1980, 5, 5), 1.60));
		main.visitorsTree.addPerson(new Tourist("6", "Frank", new GregorianCalendar(1975, 6, 6), 1.85));
		main.visitorsTree.addPerson(new Tourist("7", "Grace", new GregorianCalendar(1970, 7, 7), 1.55));
		main.visitorsTree.addPerson(new Tourist("8", "Heidi", new GregorianCalendar(1965, 8, 8), 1.90));
		main.visitorsTree.addPerson(new Tourist("9", "Ivan", new GregorianCalendar(1960, 9, 9), 1.50));
		main.visitorsTree.addPerson(new Tourist("10", "Judy", new GregorianCalendar(1955, 10, 10), 1.95));
		// create 10 employees:
		main.employeeTree.addPerson(new Employee("11", "Kathy", new GregorianCalendar(1990, 1, 1), "Management", 100));
		main.employeeTree.addPerson(new Employee("12", "Leo", new GregorianCalendar(1985, 2, 2), "Reception", 80));
		main.employeeTree.addPerson(new Employee("13", "Mallory", new GregorianCalendar(1980, 3, 3), "Reception", 90));
		main.employeeTree.addPerson(new Employee("14", "Nina", new GregorianCalendar(1975, 4, 4), "Technician", 70));
		main.employeeTree.addPerson(new Employee("15", "Oscar", new GregorianCalendar(1970, 5, 5), "Operator", 60));
		main.employeeTree.addPerson(new Employee("16", "Peggy", new GregorianCalendar(1965, 6, 6), "Operator", 85));
		main.employeeTree.addPerson(new Employee("17", "Quentin", new GregorianCalendar(1960, 7, 7), "Operator", 75));
		main.employeeTree.addPerson(new Employee("18", "Rupert", new GregorianCalendar(1955, 8, 8), "Management", 110));
		main.employeeTree.addPerson(new Employee("19", "Sybil", new GregorianCalendar(1950, 9, 9), "Technician", 65));
		main.employeeTree.addPerson(new Employee("20", "Trent", new GregorianCalendar(1945, 10, 10), "Reception", 55));
	    // add for 5 person 2 or 3 or 4 ticket in each one ticket stack:
		
		System.out.println("Welcome to Ruppin Land!");
		main.mainMenu();
		
	}
	
	public void mainMenu () {
		while (true) {
			
			System.out.println("Please enter your ID or 0 to exit:");
			String id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("Are you sure you want to exit? (y/n)");
				String answer = scanner.nextLine();
				if (answer.equals("y")) {
					System.out.println("Goodbye!");
					return;
				} else {continue;}
			}
			
			Employee employee = (Employee) employeeTree.searchPerson(Integer.parseInt(id));
			if (employee != null) {
				switch (employee.getdepartment()) {
                    case "Management":
                    	ManagementMenu(employee);
                        break;
                    case "Technician":
                        technicianMenu(employee);
                        break;
                    case "Operator":
                        operatorMenu(employee);
                        break;
                    case "Reception":
                        receptionMenu(employee);
                        break;
                    default:
                        System.out.println("Invalid role.");
                }
            } else {
				System.out.println("Employee not found.");
			}
		}
	}

	public void ManagementMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			break;
		}
	}

	public void technicianMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			System.out.println("Please enter the ride name:");
			//print all attractions names
			for (Ride ride : attractions) {
				System.out.println(ride.getName());
			}
			String rideName = scanner.nextLine();
			Ride ride = null;
			for (Ride r : attractions) {
				if (r.getName().equals(rideName)) {
					ride = r;
					break;
				}
			}
			if (ride == null) {
				System.out.println("Ride not found.");
				continue;
			}
			while(true)
			{
				System.out.println("1. Open ride	4. Get ride details");
				System.out.println("2. Close ride	5. Get complaint from tourist");
				System.out.println("3. Fix ride    6. Print All Technicians");
				System.out.println("7. Exit");
				
                int choice = scanner.nextInt();
                scanner.nextLine();
				switch (choice) {
				case 1:
					ride.setOpen(true);
					System.out.println("Ride " + ride.getName() + " is now open.");
					break;
				case 2:
					ride.setOpen(false);
					System.out.println("Ride " + ride.getName() + " is now closed.");
					break;
				case 3:
					//get from user next maintenance time
					System.out.println("Please enter the next maintenance time (yyyy-mm-dd):");
					String date = scanner.nextLine();
					String[] dateParts = date.split("-");
					int year = Integer.parseInt(dateParts[0]);
					int month = Integer.parseInt(dateParts[1]) - 1; // Month is 0-based in GregorianCalendar
					int day = Integer.parseInt(dateParts[2]);
					GregorianCalendar nextMaintenanceTime = new GregorianCalendar(year, month, day);
					ride.setNextMaintenanceTime(nextMaintenanceTime);
					System.out.println("Ride " + ride.getName() + " is under maintenance.");
					break;
				case 4:
					ride.printDetails();
					break;
				case 5:
				    System.out.println("Please enter the tourist ID:");
				    String touristId = scanner.nextLine();
				    Tourist tourist = (Tourist) visitorsTree.searchPerson(Integer.parseInt(touristId));
				    if (tourist == null) {
				        System.out.println("Tourist not found.");
				        break;
				    }
				 // Find the Technician instance in the departments list
				    Technician technician = null;
				    for (Object obj : departments) {
				        if (obj instanceof Technician) {
				            technician = (Technician) obj;
				            break;
				        }
				    }

				    if (technician != null) {
				        technician.handleCustomer(tourist, ride);
				    }
				    else {
				        System.out.println("Technician department not found.");
				    }
				    break;
				case 6:
				    // Find the Technician instance in the departments list
				    Technician sometechnician = null;

				    for (Object obj : departments) {
				        if (obj instanceof Technician) {
				            sometechnician = (Technician) obj;
				            break;
				        }
				    }

				    if (sometechnician != null) {
				    	
				        System.out.println("Would you like to print in a single line? (Y/N)");
				        
				        String YNchoice = scanner.nextLine().trim().toUpperCase();
				        
				        if (YNchoice.startsWith("N")) {
				            sometechnician.printDetails(employeeTree);
				        } else if (YNchoice.startsWith("Y")) {
				            sometechnician.printDetailsOneLine(employeeTree);
				        } else {
				            System.out.println("Invalid choice. Returning to menu.");
				        }
				    }
				    
				    else {
				        System.out.println("Technician department not found.");
				    }
				    
				    break;
				case 7:
			        System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice.");
				}
			}
		}
	}
		
	
	public void operatorMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			System.out.println("Please enter the ride name:");
			//print all attractions names
			for (Ride ride : attractions) {
				System.out.println(ride.getName());
			}
			String rideName = scanner.nextLine();
			Ride ride = null;
			for (Ride r : attractions) {
				if (r.getName().equals(rideName)) {
					ride = r;
					break;
				}
			}
			if (ride == null) {
				System.out.println("Ride not found.");
				continue;
			}
			while(true)
			{
				//print the menu 1.sell ticket 2. move the queue 3. get person from the queue 4. close ride 5. open ride 6. get ride details 7. exit
				System.out.println("1. Sell ticket	5. Open ride");
				System.out.println("2. Move the queue	6. Get ride details");
				System.out.println("3. Get person from the queue	7. Exit");
				System.out.println("4. Close ride");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					//get from user the tourist id
					System.out.println("Please enter the tourist id:");
					String touristId = scanner.nextLine();
					Tourist tourist = (Tourist) visitorsTree.searchPerson(Integer.parseInt(touristId));
					if (tourist == null) {
						System.out.println("Tourist not found.");
						continue;
					}
					// trying to add tourist to line
					try {
                    ride.addToLine(tourist);
					} catch( Exception e ) {
						continue;
					}
					//sell the ticket
					tourist.addVisit(new Ticket(ride.getName(), ride.getPrice(), new GregorianCalendar(), null));
					
					break;
				case 2:
					//move the queue
					if (ride.queue.isEmpty()) {
						System.out.println("Queue is empty.");
						continue;
					}
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
					return;
				default:
					System.out.println("Invalid choice.");
					break;
				}
			}
		}
	}
	public void receptionMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			break;
		}
	}

}