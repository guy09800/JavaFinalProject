package RuppinLand;

import dataStruct.PersonTree;
import dataStruct.TreeNode;
import personClass.Employee;
import personClass.Tourist;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Reception implements department {

    private String name;
    private static LinkedList<Ticket> enterys = new LinkedList<Ticket>();
    private Tourist [][] parkingLot;
    
    public Reception(String name) {
        this.name = name;
        this.parkingLot = new Tourist[10][10];
    }
    
	public Reception(String name, int rows, int columns) {
		this.name = name;
		parkingLot = new Tourist[rows][columns];
		
	}
	
    @Override
    public String getName() {return name;}

    @Override
	public void printDetails(PersonTree employeeTree) {
    	
	    System.out.println(this.name + " Department - Full Employee Details:");
	    boolean OneLine = false; 
	    employeeTree.printByDepartment(this.name,OneLine);
	}

	@Override
	public void printDetailsOneLine(PersonTree employeeTree) {
		
	    System.out.println(this.name + " Department - One-Line Employee Summaries:");
	    boolean OneLine = true;	    
	    employeeTree.printByDepartment(this.name,OneLine);
	    
	}
	
    @Override
    public void handleCustomer(Tourist tourist, Ride ride) {
        System.out.println("Reception is registering the tourist " + tourist.getName() + ".");
    }
    
    public void registerTourist(PersonTree visitorsTree) {
    	
        Scanner scanner = new Scanner(System.in); 
        while (true) {
            try {
                System.out.println("Enter Tourist ID (numbers only):");
                String id = scanner.nextLine().trim();
                if (visitorsTree.searchPerson(Integer.parseInt(id)) != null) {
                    System.out.println("Tourist with this ID already exists.");
                    continue;
                }

                System.out.println("Enter Tourist name:");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }

                System.out.println("Enter birth date (format: yyyy-mm-dd):");
                String[] parts = scanner.nextLine().trim().split("-");
                if (parts.length != 3) {
                    System.out.println("Invalid date format.");
                    continue;
                }

                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]) - 1; // 0-based month
                int day = Integer.parseInt(parts[2]);

                GregorianCalendar birthday = new GregorianCalendar(year, month, day);

                System.out.println("Enter height in meters (Format : X.YZ):");
                double height = Double.parseDouble(scanner.nextLine());

                Tourist newTourist = new Tourist(id, name, birthday, height);
                visitorsTree.addPerson(newTourist);
                System.out.println("Tourist registered successfully.");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Try again.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public void addEmployee(PersonTree employeeTree) {
    	
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter Employee ID (numbers only):");
                String id = scanner.nextLine().trim();
                if (employeeTree.searchPerson(Integer.parseInt(id)) != null) {
                    System.out.println("Employee with this ID already exists.");
                    continue;
                }

                System.out.println("Enter Employee name:");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }

                System.out.println("Enter birth date (format: yyyy-mm-dd):");
                String[] parts = scanner.nextLine().trim().split("-");
                if (parts.length != 3) {
                    System.out.println("Invalid date format.");
                    continue;
                }
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]) - 1; // 0-based
                int day = Integer.parseInt(parts[2]);
                GregorianCalendar birthday = new GregorianCalendar(year, month, day);

                System.out.println("Enter department (Technician / Operator / Reception / Management):");
                String department = scanner.nextLine().trim();
                if (!department.equalsIgnoreCase("Technician") &&
                    !department.equalsIgnoreCase("Operator") &&
                    !department.equalsIgnoreCase("Reception") &&
                    !department.equalsIgnoreCase("Management")) {
                    System.out.println("Invalid department name.");
                    continue;
                }

                System.out.println("Enter salary:");
                double salary = Double.parseDouble(scanner.nextLine());
                if (salary < 0) {
                    System.out.println("Salary must be positive.");
                    continue;
                }

                Employee newEmployee = new Employee(id, name, birthday, department, salary);
                employeeTree.addPerson(newEmployee);
                System.out.println("Employee added successfully.");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Try again.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void closeRide(Ride ride) {
        ride.setOpen(false);
    }

    @Override
    public void openRide(Ride ride) {
        ride.setOpen(true);
    }
    
	public static void outOfThePark(Tourist tourist) {
	}
	public void printParkingLot() {
	
	}

	public void sellTicket(Tourist tourist) {
		
	}
	public void printAllTouristToday() {
		
	}
}

