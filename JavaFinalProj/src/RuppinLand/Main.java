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
    private LinkedList<Ride> attractions;
    private static List<Object> departments;
    private boolean isOpen;
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
		
	    Technician technician = new Technician("Technician");
	    Operator operator = new Operator("Operator");
	    Reception reception = new Reception("Reception");
	    Management management = new Management("Management");
	    
	    departments.add(technician);
	    departments.add(operator);
	    departments.add(reception);
	    departments.add(management);
	    
		System.out.println("Welcome to Ruppin Land!");
		//create new departments
		
		// create new 10 tourists
		
		Tourist t1 = new Tourist("1", "Alice", new GregorianCalendar(2000, 1, 1), 1.75);
		Tourist t2 = new Tourist("2", "Bob", new GregorianCalendar(1995, 2, 2), 1.80);
		Tourist t3 = new Tourist("3", "Charlie", new GregorianCalendar(1990, 3, 3), 1.65);
		Tourist t4 = new Tourist("4", "David", new GregorianCalendar(1985, 4, 4), 1.70);
		Tourist t5 = new Tourist("5", "Eve", new GregorianCalendar(1980, 5, 5), 1.60);
		Tourist t6 = new Tourist("6", "Frank", new GregorianCalendar(1975, 6, 6), 1.85);
		Tourist t7 = new Tourist("7", "Grace", new GregorianCalendar(1970, 7, 7), 1.55);
		Tourist t8 = new Tourist("8", "Heidi", new GregorianCalendar(1965, 8, 8), 1.90);
		Tourist t9 = new Tourist("9", "Ivan", new GregorianCalendar(1960, 9, 9), 1.50);
		Tourist t10 = new Tourist("10", "Judy", new GregorianCalendar(1955, 10, 10), 1.95);
		// add tourists to the tree
		main.visitorsTree.addPerson(t1);
		main.visitorsTree.addPerson(t2);
		main.visitorsTree.addPerson(t3);
		main.visitorsTree.addPerson(t4);
		main.visitorsTree.addPerson(t5);
		main.visitorsTree.addPerson(t6);
		main.visitorsTree.addPerson(t7);
		main.visitorsTree.addPerson(t8);
		main.visitorsTree.addPerson(t9);
		main.visitorsTree.addPerson(t10);
		
		// create 10 employees
		Employee e1 = new Employee("11", "Kathy", new GregorianCalendar(1990, 1, 1), "Management", 100);
		Employee e2 = new Employee("12", "Leo", new GregorianCalendar(1985, 2, 2), "Reception", 80);
		Employee e3 = new Employee("13", "Mallory", new GregorianCalendar(1980, 3, 3), "Reception", 90);
		Employee e4 = new Employee("14", "Nina", new GregorianCalendar(1975, 4, 4), "Technician", 70);
		Employee e5 = new Employee("15", "Oscar", new GregorianCalendar(1970, 5, 5), "Operator", 60);
		Employee e6 = new Employee("16", "Peggy", new GregorianCalendar(1965, 6, 6), "Operator", 85);
		Employee e7 = new Employee("17", "Quentin", new GregorianCalendar(1960, 7, 7), "Operator", 75);
		Employee e8 = new Employee("18", "Rupert", new GregorianCalendar(1955, 8, 8), "Management", 110);
		Employee e9 = new Employee("19", "Sybil", new GregorianCalendar(1950, 9, 9), "Technician", 65);
		Employee e10 = new Employee("20", "Trent", new GregorianCalendar(1945, 10, 10), "Reception", 55);
		// add employees to the tree
		main.employeeTree.addPerson(e1);
		main.employeeTree.addPerson(e2);
		main.employeeTree.addPerson(e3);
		main.employeeTree.addPerson(e4);
		main.employeeTree.addPerson(e5);
		main.employeeTree.addPerson(e6);
		main.employeeTree.addPerson(e7);
		main.employeeTree.addPerson(e8);
		main.employeeTree.addPerson(e9);
		main.employeeTree.addPerson(e10);
		
		main.mainMenu();
		
	}

	
	// Main Menu : 
	
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
	
	
	
	// All Types of Menus : 
	
	
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
					
					//check if the ride is open
					if (!ride.isOpen()) {
						System.out.println("Ride " + ride.getName() + " is closed.");
						continue;
					}
					//check if the tourist is old enough
					if (tourist.getAge() < ride.getMinAge()) {
						System.out.println(
								"Tourist " + tourist.getName() + " is not old enough for ride " + ride.getName() + ".");
						continue;
					}
					//check if the tourist is tall enough
					if (tourist.getHeight() < ride.getMinHeight()) {
						System.out.println("Tourist " + tourist.getName() + " is not tall enough for ride "
								+ ride.getName() + ".");
						continue;
					}// method adds a visitor to line, GUY needs to add the conditionals to the original function
					try {
                    ride.addToLine(tourist);
					} catch( Exception e ) {
						continue;
					}
					//sell the ticket
					tourist.addVisit(new Ticket(tourist.getId(), tourist.getName(), ride.getName(), ride.getPrice(),LocalDateTime.now(), null));
					// add tourist to queue function GUY
					System.out.println("Tourist " + tourist.getName() + " has been added to the queue for ride "
							+ ride.getName() + ".");
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