package personClass;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Person {
// fields id name of birthday
	private String id;
	private String name;
	private GregorianCalendar  birthday;
	private int height;
	
	//default constructor
	public Person() {
		this.id = "";
		this.name = "";
		this.birthday = new GregorianCalendar();
	}
	
	//constructor with parameters		
	 public Person(String id, String name, GregorianCalendar birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	 //getters and setters
	 public String getId() {return id; }
	 public int getIdAsNum() {return Integer.valueOf(id); }
	 public void setId(String id) {this.id = id;}

	 public String getName() {return name;}
	 public void setName(String name) {this.name = name;}

	 public GregorianCalendar getBirthday() {return birthday;}
	 public void setBirthday(GregorianCalendar birthday) 
		{this.birthday = birthday;}
	 
	 public abstract void printDetails();

	 //toString method- to print the details of the person
	 @Override
	 public String toString() {
		return "ID: " + id + "\nName: " + name + "\nBirthday: " + birthday.get(Calendar.DAY_OF_MONTH) + "/"
				+ (birthday.get(Calendar.MONTH) + 1) + "/" + birthday.get(Calendar.YEAR);
		}
	 public int getAge() {
		 GregorianCalendar today = new GregorianCalendar();
		 int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
			if (today.get(Calendar.MONTH) < birthday.get(Calendar.MONTH)
					|| (today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH)
							&& today.get(Calendar.DAY_OF_MONTH) < birthday.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		return age;
			            
	 }
	 public int getHight() {return height;}
	 public void setHight(int height) {
			if (height < 0) {
				throw new IllegalArgumentException("Height cannot be negative");
			}
			this.height = height;
	 }

	
	
}
