package RuppinLand;
import java.util.GregorianCalendar;

public class DaySummary {
	private GregorianCalendar date;
	private int totalMoney;
	
	
	public DaySummary(GregorianCalendar date, int totalMoney) {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null.");
		}
		if (totalMoney < 0) {
			throw new IllegalArgumentException("Total money cannot be negative.");
		}

		this.date = date;
		this.totalMoney = totalMoney;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null.");
		}
		this.date = date;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		if (totalMoney < 0) {
			throw new IllegalArgumentException("Total money cannot be negative.");
		}
		this.totalMoney = totalMoney;
	}
	
}
