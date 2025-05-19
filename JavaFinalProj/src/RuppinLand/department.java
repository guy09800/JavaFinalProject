package RuppinLand;
import personClass.*;

public interface department {
	public String getName();
	public void menu();
	public void printDetails();
	public void printDetailsOneLine();
	public void handleCoustomer(Tourist tourist);
	public void closeRide(Ride ride);
	public void openRide(Ride ride);
}
