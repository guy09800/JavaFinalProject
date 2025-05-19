package RuppinLand;

import personClass.Tourist;

public class Technician implements department {
	
	private String name;

    public Technician(String name) {
        this.name=name;
    }
    

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printDetailsOneLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCoustomer(Tourist tourist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeRide(Ride ride) {
		// TODO Auto-generated method stub
		ride.setOpen(false);
	}

	@Override
	public void openRide(Ride ride) {
		// TODO Auto-generated method stub
		ride.setOpen(true);
	}

}
