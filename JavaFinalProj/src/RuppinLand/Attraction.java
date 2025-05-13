package RuppinLand;
import personClass.Person;
import java.util.Queue;

public interface Attraction {
	void addPerson(Person p);
	String getName();
	void setName(String name);
	void setMaxCapacity(int maxCapacity);
	int getMaxCapacity();
    int getCurrentCapacity();
    void setCurrentCapacity(int currentCapacity);
	Queue<Person> getQueue();
	void moveQueue();

}
