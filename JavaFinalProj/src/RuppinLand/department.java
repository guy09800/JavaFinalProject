package RuppinLand;

import dataStruct.*;
import personClass.Tourist;

public interface department {
	public String getName();
	public void printDetails(PersonTree employeeTree);
	public void printDetailsOneLine(PersonTree EmployeeTree);
	public void closeRide(Ride ride);
	public void openRide(Ride ride);
	public void handleCustomer(Tourist tourist, Ride ride);
}
