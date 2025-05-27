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
    private int TouristInPark = 0;
    private static LinkedList<Ticket> enterys = new LinkedList<Ticket>();
    private Tourist [][] parkingLot = new Tourist[10][10];
    private Tourist [] touristsVisitedToday = new Tourist[0];
    private int totalMoneyToday = 0;
    private int price;
    
    public Reception(String name, int price) {
        this.name = name;
        this.price = price;
    }

	
    @Override
    public String getName() {return name;}

    @Override
	public void printDetails(PersonTree employeeTree) {
    	
	    System.out.println(this.name + " Department - Full Employee Details:");
	    boolean OneLine = false; 
	    employeeTree.printByDepartment(this.name,OneLine);
	}

	public int getTouristInPark() {
		return TouristInPark;
	}

	public void setTouristInPark(int touristInPark) {
		TouristInPark = touristInPark;
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
    
    public Tourist registerTourist(PersonTree visitorsTree) {
		Scanner scanner  = new Scanner(System.in);

		String id;
		while (true) {
		    System.out.println("please enter your id to register as a tourist");
		    id = scanner.nextLine().trim();

		    if (id.isEmpty()) {
		        System.out.println("ID cannot be empty.");
		        continue;
		    }

		    if (!id.matches("\\d+")) {
		        System.out.println("Invalid ID. Please enter numbers only.");
		        continue;
		    }

		    if (visitorsTree.searchPerson(Integer.parseInt(id)) != null) {
		        System.out.println("Tourist with this ID already exists.");
		        continue;
		    }

		    break;
		}

		// name
		String name;
		while (true) {
		    System.out.println("please enter your name");
		    name = scanner.nextLine().trim();

		    if (name.isEmpty()) {
		        System.out.println("Name cannot be empty.");
		        continue;
		    }

		    if (!name.matches("[a-zA-Z ]+")) { // רק אותיות ורווחים
		        System.out.println("Invalid name. Please enter letters only.");
		        continue;
		    }

		    break; 
		}

		//birthday
		int year = 0, month = 0, day = 0;
		while (true) {
		    System.out.println("please enter your birth date in format yyyy-mm-dd");
		    String birthDate = scanner.nextLine().trim();
		    
		    if (!birthDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
		        System.out.println("Invalid date format. Please use yyyy-mm-dd.");
		        continue;
		    }

		    String[] parts = birthDate.split("-");
		    if (parts.length != 3) {
		        System.out.println("Invalid date format. Please use yyyy-mm-dd.");
		        continue;
		    }

		    
		    if (!parts[0].matches("\\d{4}") || !parts[1].matches("\\d{2}") || !parts[2].matches("\\d{2}")) {
		        System.out.println("Each part of the date must be numeric.");
		        continue;
		    }

		    year = Integer.parseInt(parts[0]);
		    month = Integer.parseInt(parts[1]) - 1; // Java: month is 0-based
		    day = Integer.parseInt(parts[2]);

		    
		    int currentYear = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);
		    if (year < 1900 || year > currentYear) {
		        System.out.println("Year must be between 1900 and the current year.");
		        continue;
		    }

		    if (month < 0 || month > 11) {
		        System.out.println("Month must be between 01 and 12.");
		        continue;
		    }

		    if (day < 1 || day > 31) {
		        System.out.println("Day must be between 01 and 31.");
		        continue;
		    }

		    // check if its really a date in the calendar
		    GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		    if (calendar.get(GregorianCalendar.YEAR) != year ||
		        calendar.get(GregorianCalendar.MONTH) != month ||
		        calendar.get(GregorianCalendar.DAY_OF_MONTH) != day) {
		        System.out.println("Invalid calendar date. Please enter a real date.");
		        continue;
		    }

		    break; 
		}

		//height 
		double height = 0;
		while (true) {
		    System.out.println("please enter your height in meters (Format : X.YZ):");
		    String heightInput = scanner.nextLine().trim();

		    if (!heightInput.matches("\\d+(\\.\\d+)?")) {
		        System.out.println("Invalid input. Please enter a valid number in format X.YZ");
		        continue;
		    }

		    height = Double.parseDouble(heightInput); // כאן זה נכנס למשתנה מסוג double

		    if (height <= 0) {
		        System.out.println("Height must be a positive number.");
		        continue;
		    }

		    break;
		}

		// add tourist to the tree and return the new tree 
		Tourist newTourist = new Tourist(id, name, new GregorianCalendar(year, month, day), height);
		visitorsTree.addPerson(newTourist);
		System.out.println("Tourist registered successfully.");
		return newTourist;
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
    
	public void outOfThePark(Tourist tourist) {
		TouristInPark--;
		if (tourist.getticketStack().peek() != null) {
			if (tourist.getticketStack().peek().getPlayDateTime() == null) {
				tourist.getticketStack().peek().setPlayDateTime(new GregorianCalendar());
			}
		}
		if (tourist.getParkingPlace() != null) {
			int row = tourist.getParkingPlace()[0];
			int col = tourist.getParkingPlace()[1];
			if (row >= 0 && row < parkingLot.length && col >= 0 && col < parkingLot[0].length) {
				parkingLot[row][col] = null;
				System.out.println(tourist.getName() + " has left the parking lot.");
			} else {
				System.out.println("Invalid parking place for " + tourist.getName() + ".");
			}
		}
		
	}
	public void printParkingLot() {
	    System.out.println("=== Parking Lot ===");

	    System.out.print("      ");
	    for (int j = 0; j < parkingLot[0].length; j++) {
	        System.out.printf("   [%2d]   ", j);
	    }
	    System.out.println();

	    for (int i = 0; i < parkingLot.length; i++) {
	        System.out.printf("[%2d] ", i);
	        for (int j = 0; j < parkingLot[i].length; j++) {
	            Tourist t = parkingLot[i][j];
	            String name = (t != null) ? t.getName() : "-";
	            System.out.printf("| %-7s ", name);
	        }
	        System.out.println("|");
	    }

	    System.out.println("===================");
	}

	public void sellTicket(Tourist tourist) {
		if (tourist == null) {
			throw new IllegalArgumentException("Tourist cannot be null.");
		}
		TouristInPark++;
		if (touristsVisitedToday.length == 0) {
			touristsVisitedToday = new Tourist[] { tourist };
		}
		else {
		Tourist [] newTouristsVisitedToday = new Tourist[touristsVisitedToday.length + 1];
		System.arraycopy(touristsVisitedToday, 0, newTouristsVisitedToday, 0, touristsVisitedToday.length);
		newTouristsVisitedToday[touristsVisitedToday.length-1] = tourist;
		touristsVisitedToday = newTouristsVisitedToday;
		}
		totalMoneyToday += price;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Does " + tourist.getName() + " have a car? (yes/no)");
		String hasCar = scanner.nextLine().trim().toLowerCase();
		if (hasCar.equals("yes")) {
			printParkingLot();
			System.out.println("Please enter the parking spot (row and column) for " + tourist.getName() + ":");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			if (row < 0 || row >= parkingLot.length || col < 0 || col >= parkingLot[0].length) {
				System.out.println("Invalid parking spot. Please try again.");
			} else if (parkingLot[row][col] != null) {
				System.out.println("Parking spot is already taken. Please try again.");
			} else {
				parkingLot[row][col] = tourist;
				System.out.println(tourist.getName() + " parked at (" + row + ", " + col + ").");
				tourist.setParkingPlace(row,col);
			}
		}
		
	}
	public void printAllTouristInThePark() {
		System.out.println("=== Tourists in the Park Right Now ===");
		for (int i = 0; i < touristsVisitedToday.length; i++) {
			if (touristsVisitedToday[i] != null) {
				System.out.println(touristsVisitedToday[i].getName());
			}
		}
		System.out.println("=============================");
		System.out.println("Total Tourists in Park: " + TouristInPark);
	}
}

