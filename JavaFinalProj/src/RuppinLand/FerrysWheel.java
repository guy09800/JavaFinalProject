package RuppinLand;
import java.util.GregorianCalendar;
public class FerrysWheel extends Ride {

	public FerrysWheel(String name, int minAge, int minHeight, int maxCapacity, int price,
			GregorianCalendar nextMaintenanceTime) {
		super(name, minAge, minHeight, maxCapacity, price, nextMaintenanceTime);
	}
	public void scene() throws Exception {
		printLine("🎡 The Ferris wheel creaks to life as the sun begins to set...");
		printLine("🌇 The sky glows orange while the first cabin slowly lifts off the ground.");
		printLine("🕊️ Birds glide past at eye level as the ride gains height.");
		printLine("💑 Couples point out tiny people below, laughing and taking photos.");
		printLine("🧍 Visitors sway gently, mesmerized by the panoramic view.");

	}
}
