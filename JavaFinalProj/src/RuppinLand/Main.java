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
    private static Scanner scanner = new Scanner(System.in);
    private Technician technicians;
    private Operator operators;
    private Reception receptionists;
    private Management managements;
    private static LinkedList<DaySummary> DaysSummary;
    
	public Main() {
		this.employeeTree = new PersonTree();
		this.visitorsTree = new PersonTree();
		this.attractions = new LinkedList<>();
		this.technicians = new Technician("Technician");
		this.operators = new Operator("Operator");
		this.receptionists = new Reception("Reception", 100);
		this.managements =new Management("Management");
		this.isOpen = false;
		this.DaysSummary = new LinkedList<>();
	}

	public static void main(String[] args) {
		
		Main main = new Main();
		main.setIsOpen(true);
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
		// add to the stack tickets:
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
		main.visitorsTree.addPerson(new Tourist("1", "Alice", new GregorianCalendar(2000, 1, 1), 175).setticketStack(ticketStack1));
		main.visitorsTree.addPerson(new Tourist("2", "Bob", new GregorianCalendar(1995, 2, 2), 180).setticketStack(ticketStack2));
		main.visitorsTree.addPerson(new Tourist("3", "Charlie", new GregorianCalendar(1990, 3, 3), 165).setticketStack(ticketStack3));
		main.visitorsTree.addPerson(new Tourist("4", "David", new GregorianCalendar(1985, 4, 4), 170));
		main.visitorsTree.addPerson(new Tourist("5", "Eve", new GregorianCalendar(1980, 5, 5), 160));
		main.visitorsTree.addPerson(new Tourist("6", "Frank", new GregorianCalendar(1975, 6, 6), 185));
		main.visitorsTree.addPerson(new Tourist("7", "Grace", new GregorianCalendar(1970, 7, 7), 155));
		main.visitorsTree.addPerson(new Tourist("8", "Heidi", new GregorianCalendar(1965, 8, 8), 190));
		main.visitorsTree.addPerson(new Tourist("9", "Ivan", new GregorianCalendar(1960, 9, 9), 185));
		main.visitorsTree.addPerson(new Tourist("318265378", "Idan", new GregorianCalendar(1997, 10, 3), 105));
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
		
		System.out.println("Welcome to Ruppin Land!");
		main.mainMenu();
		
	}
	
	public void mainMenu () {
		while (true) {
			System.out.println("Hello Employee, Please enter your ID or 0 to exit the system:");
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
				switch (employee.getDepartment()) {
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
            System.out.println(
                    "1. Add new ride\t\t\t\t\t7. Print all employees\n" +
                    "2. Remove ride\t\t\t\t\t8. Print all tourists\n" +
                    "3. Add new employee\t\t\t\t9. Move employee to another department\n" +
                    "4. Remove employee\t\t\t\t10. How much money the park made today\n" +
                    "5. Print all rides\t\t\t\t11. Show Stats\n" +
                    "6. Print all tourists in the park now\n12. Exit\n"
                );
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Please enter the ride name:");
                    String rideName = scanner.nextLine();
                    System.out.println("Please enter the ride type (RollerCoaster, FerrysWheel, HauntedHouse):");
                    String rideType = scanner.nextLine();
                    System.out.println("Please enter the minimum age:");
                    int minAge = scanner.nextInt();
                    System.out.println("Please enter the minimum height:");
                    int minHeight = scanner.nextInt();
                    System.out.println("Please enter the max capacity:");
                    int maxCapacity = scanner.nextInt();
                    System.out.println("Please enter the price:");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    GregorianCalendar nextMaintenanceTime = new GregorianCalendar();
                    nextMaintenanceTime.add(GregorianCalendar.MONTH, 1);
					switch (rideType) {
					case "RollerCoaster":
						System.out.println("Please enter the speed:");
						int speed = scanner.nextInt();
						attractions.add(new RollerCoaster(rideName, minAge, minHeight, maxCapacity, price, nextMaintenanceTime, speed));
						break;
					case "FerrysWheel":
						attractions.add(new FerrysWheel(rideName, minAge, minHeight, maxCapacity, price, nextMaintenanceTime));
						break;
					case "HauntedHouse":
						System.out.println("Please enter the scare level:");
						int scareLevel = scanner.nextInt();
						attractions.add(new HauntedHouse(rideName, minAge, minHeight, maxCapacity,price, nextMaintenanceTime, scareLevel));
						break;
					default:
						System.out.println("Invalid ride type.");
					}
                    break;
                case 2:
                	System.out.println("Please enter the ride name to remove:");
                	String removeRideName = getRideFromUser().getName();
                	for (Ride ride : attractions) {
						if (ride.getName().equals(removeRideName)) {
							ride.setOpen(false);
							attractions.remove(ride);
							System.out.println("Ride " + removeRideName + " has been removed.");
							break;
						}
                	}
                    break;
                case 3:
                	Employee newEmployee = Employee.createEmployee(employeeTree);
                	if (newEmployee != null) {employeeTree.addPerson(newEmployee);}
                    break;
                case 4:
                    Employee employeeToRemove = getEmployeeFromUser();
                    if (employeeToRemove == null) {continue;}
                    employeeTree.removePerson(employeeToRemove.getIdAsNum());
                    break;
                case 5:
                	printAttractions();
                    break;
                case 6:
                	receptionists.printAllTouristInThePark();
                    break;
                case 7:
                    System.out.println("Employees:");
                    employeeTree.printAll();
                    break;
                case 8: 
                	System.out.println("Tourists:");
                	visitorsTree.printAll();
                    break;
                case 9:
                    System.out.println("Please enter the employee ID to move:");
                    String employeeID = scanner.nextLine();
                    Employee employeeToMove = (Employee) employeeTree.searchPerson(Integer.parseInt(employeeID));
					if (employeeToMove == null) {
						System.out.println("Employee not found.");
						break;
					}
					System.out.println("Please enter the new department (Management, Technician, Operator, Reception):");
					String newDepartment = scanner.nextLine();
					switch (newDepartment) {
						case "Management":
							employeeToMove.setDepartment("Management");
							break;
						case "Technician":
							employeeToMove.setDepartment("Technician");
							break;
						case "Operator":
							employeeToMove.setDepartment("Operator");
							break;
						case "Reception":
							employeeToMove.setDepartment("Reception");
							break;
						default:
							System.out.println("Invalid department.");
					}
                    break;
                case 10:
                	int totalMoney = 0;
					for (Ride ride : attractions) {
						totalMoney += ride.howMuchMoneyMadeToday();
						System.out.println("Ride: " + ride.getName() + ", Made today: " + ride.howMuchMoneyMadeToday());
					}
					System.out.println("Total money made today: " + totalMoney);
                    break;
                case 11:
                	showStats();
                	break;
                case 12:	
                    System.out.println("Exiting...");
                    return;
                default:
                	System.out.println("Invalid choice.");
            }
		}
}

	public void technicianMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		while (true) {
			Ride ride = getRideFromUser();
			if (ride == null) {continue;}
			
			while(true)
			{
				System.out.println(
					    "1. Open ride\t4. Get ride details\n" +
					    "2. Close ride\t5. Get complaint from tourist\n" +
					    "3. Fix ride\t6. Print All Rides next maintenance time\n" +
					    "7. Exit"
					);
				
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
					GregorianCalendar nextMaintenanceTime = getDateFromUser();
					ride.setNextMaintenanceTime(nextMaintenanceTime);
					System.out.println("Ride " + ride.getName() + " has been fixed and next maintenance time is set to " + nextMaintenanceTime.getTime());
					break;
				case 4:
					ride.printDetails();
					break;
				case 5:
					Tourist tourist = getTouristFromUser();
					if (tourist == null) {continue;}
					System.out.println("Please enter the complaint regarding the ride " + ride.getName() + ":");
					String complaint = scanner.nextLine();
					System.out.println("Please enter:\n1 - to fix the ride\n2 - to do nothing\n3 - to close the ride:");
					int fixChoice = scanner.nextInt();
					scanner.nextLine();
					switch (fixChoice) {
						case 1:
							GregorianCalendar nextMaintenanceTime1 = getDateFromUser();
							ride.setNextMaintenanceTime(nextMaintenanceTime1);
							System.out.println("Ride " + ride.getName() + " has been fixed and next maintenance time is set to " + nextMaintenanceTime1.getTime());
							break;
						case 2:
							System.out.println("No action taken.");
							break;
						case 3:
							ride.setOpen(false);
							System.out.println("Ride " + ride.getName() + " is now closed.");
							break;
					}
				    break;
				case 6:
					System.out.println("Rides next maintenance times:");
					for (Ride r : attractions) {
						System.out.println("Ride: " + r.getName() + ", Next Maintenance Time: " + r.getNextMaintenanceTime().getTime());
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
		Ride ride = getRideFromUser();
		if (ride == null) {return;}
		while(true)
		{
			System.out.println(
				    "1. Sell ticket\t\t\t\t\t5. Open ride\n" +
				    "2. Move the queue and start the attraction\t6. Get ride details\n" +
				    "3. Get out person from the queue\t\t7. Print all tourists in the queue\n" +
				    "4. Close ride\t\t\t\t\t8. Exit"
				);
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				Tourist tourist = getTouristFromUser();
				
				if (tourist == null) {
					System.out.println("Tourist not found.");
					continue;
					}
				try {ride.addToLine(tourist);}
				catch( Exception e ) {
					System.out.println("Error: " + e.getMessage());
					continue;
					}

				break;
			case 2:
				try {
					ride.operate();
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					continue;
				}
				System.out.println("Ride " + ride.getName() + " has been operated.");
				try {ride.scene();}
				catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					continue;
				}
				break;
			case 3:
				Tourist tourist1 = getTouristFromUser();
				if (tourist1 == null) {continue;}
				ride.removeFromQueue(tourist1);
				break;
			case 4:
				ride.setOpen(false);
				System.out.println("Ride " + ride.getName() + " is now closed.");
				break;
			case 5:
				ride.setOpen(true);
				System.out.println("Ride " + ride.getName() + " is now open.");
				break;
			case 6:
				ride.printDetails();
				break;
			case 7:
				ride.printQueue();
				break;
			case 8:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice.");
				break;
				
			}
		}
	}
	
	public void receptionMenu(Employee employee) {
		System.out.println("Welcome " + employee.getName() + "!");
		
		while (true) {
			System.out.println(
				    "Please choose an option:\n" +
				    "1. Sell ticket\t\t\t4. Print all tourists in the park now\n" +
				    "2. Give parking ticket\t\t5. Exit\n" +
				    "3. Print parking lot"
				);
            int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				Tourist tourist = getTouristFromUser();
				if (tourist == null) {visitorsTree = receptionists.registerTourist(visitorsTree);}
				receptionists.sellTicket(tourist);
				break;
			case 2:
				Tourist tourist1 = getTouristFromUser();
				if (tourist1 == null) {
					System.out.println("Tourist not found.");
					continue;
				}
				receptionists.outOfThePark(tourist1);
				break;
			case 3:
				receptionists.printParkingLot();
				break;
			case 4:
				receptionists.printAllTouristInThePark();
				break;
			case 5:
				System.out.println("Exiting...");
				return;
            default:
            	System.out.println("Invalid choice.");
            	break;
			}
			
		}
	}
	
	private void setIsOpen(boolean b) {isOpen = b;}
	
	private Tourist getTouristFromUser() {
		System.out.println("Please enter the tourist ID:");
		String touristId = scanner.nextLine();
		Tourist tourist = (Tourist) visitorsTree.searchPerson(Integer.parseInt(touristId));
		if (tourist == null) {
			System.out.println("Tourist not found.");
			return null;
		}
		return tourist;
	}

	private void printAttractions() {
		System.out.println("Attractions:");
		for (Ride ride : attractions) {
			System.out.println(ride.getName());
		}
	}

	private Ride getRideFromUser() {
		printAttractions();
		System.out.println("Please enter the ride name:");
		String rideName = scanner.nextLine();
		for (Ride ride : attractions) {
			if (ride.getName().equals(rideName)) {
				return ride;
			}
		}
		System.out.println("Ride not found.");
		return null;
	}

	private GregorianCalendar getDateFromUser() {
        System.out.println("Please enter the date (yyyy-mm-dd):");
        String date = scanner.nextLine();
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]) - 1; // Month is 0-based in GregorianCalendar
        int day = Integer.parseInt(dateParts[2]);
        return new GregorianCalendar(year, month, day);
    }
	
	private Employee getEmployeeFromUser() {
		System.out.println("Please enter the employee ID:");
		String employeeId = scanner.nextLine();
		Employee employee = (Employee) employeeTree.searchPerson(Integer.parseInt(employeeId));
		if (employee == null) {
			System.out.println("Employee not found.");
			return null;
		}
		return employee;
	}
	private void showStats() {
        System.out.println("==========================================================");
		System.out.println("Number of rides: " + attractions.size());
		System.out.println("Number of tourists in the system: " + visitorsTree.getSize());
		System.out.println("Number of employees in the system: " + employeeTree.getSize());
		System.out.println("Money made today by each ride:");
		for (Ride ride : attractions) {
			System.out.println(ride.getName() + ": " + ride.howMuchMoneyMadeToday());
		}
		System.out.println("==========================================================");
	}
}