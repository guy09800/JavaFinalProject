package dataStruct;
import personClass.Employee;
import personClass.Person;

public class PersonTree {
	TreeNode root;

	public PersonTree() {this.root = null;}
	public TreeNode getRoot() {return root;}
	public Person searchPerson(int id) {return searchPersonRec(root, id);}
	public void printAll() {printAllPerson(root);}
	
	public void addPerson(Person person) {
		if (person == null) {
			throw new IllegalArgumentException("Person cannot be null");
		}
		if (root == null) {
			root = new TreeNode(person);
		} else {
			addPersonRec(root, person);
		}
	}
	
	private void addPersonRec(TreeNode current, Person person) {
		if (current == null) {
			return;
		}
		if (person.getIdAsNum() < current.getPerson().getIdAsNum()) {
			if (current.getLeft() == null) {
				current.setLeft(new TreeNode(person));
			} else {
				addPersonRec(current.getLeft(), person);
			}
		} else if (person.getIdAsNum() > current.getPerson().getIdAsNum()) {
			if (current.getRight() == null) {
				current.setRight(new TreeNode(person));
			} else {
				addPersonRec(current.getRight(), person);
			}
		} else {
			throw new IllegalArgumentException("Person with this ID already exists");
		}
	}
	
	private Person searchPersonRec(TreeNode current, int id) {
		if (current == null) {
			return null;
		}
		if (id == current.getPerson().getIdAsNum()) {
			return current.getPerson();
		} else if (id < current.getPerson().getIdAsNum()) {
			return searchPersonRec(current.getLeft(), id);
		} else {
			return searchPersonRec(current.getRight(), id);
		}
	}

	public void printByDepartment(String departmentName, boolean OneLine) {
		
	    if (departmentName == null || departmentName.isBlank()) {
	        System.out.println("Invalid department name.");
	        return;
	    }

	    System.out.println("Employees in department: " + departmentName);
	    printByDepartmentRec(root, departmentName.trim(), OneLine); 
	}
	    

	
	// In-Order Traversal :
	private void printByDepartmentRec(TreeNode node, String departmentName, boolean OneLine) { 
	    
		if (node == null) return;

	    printByDepartmentRec(node.getLeft(), departmentName, OneLine);

	    Employee employee = (Employee) node.getPerson(); // Safe cast since tree has only Employees
	    
	    if (employee.getdepartment().equalsIgnoreCase(departmentName)) {
	    	if (OneLine) {
	        employee.printDetailsOneLine();
	    	}
	    	else if (!OneLine) { 
	    		employee.printDetails(); 
	    	}
	    }

	    printByDepartmentRec(node.getRight(), departmentName, OneLine);
	}

	private void printAllPerson(TreeNode node) {
		if (node != null) {
			printAllPerson(node.getLeft());
			node.getPerson().printDetailsOneLine();
			printAllPerson(node.getRight());
		}
	}
}

