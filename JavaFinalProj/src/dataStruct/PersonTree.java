package dataStruct;
import personClass.Employee;
import personClass.Person;

public class PersonTree {
	private TreeNode root;

	public PersonTree() {this.root = null;}
	
	//Getters:
	public TreeNode getRoot() {
		return root;
	}
	public int getSize() {
		return getSizeRec(root);
}
	private int getSizeRec(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + getSizeRec(node.getLeft()) + getSizeRec(node.getRight());
	}
	//Other methods:
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
	    
	private void printByDepartmentRec(TreeNode node, String departmentName, boolean OneLine) { 
	    
		if (node == null) return;
	    printByDepartmentRec(node.getLeft(), departmentName, OneLine);
	    Employee employee = (Employee) node.getPerson(); // Safe cast since tree has only Employees
	    
	    if (employee.getDepartment().equalsIgnoreCase(departmentName)) {
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
	
	public void removePerson(int id) {
		if (root == null) {
			System.out.println("Tree is empty. Cannot remove person.");
			return;
		}
		root = removePersonRec(root, id);
	}

	private TreeNode removePersonRec(TreeNode current, int id) {
		if (current == null) {
			System.out.println("Person with ID " + id + " not found.");
			return null;
		}
		if (id < current.getPerson().getIdAsNum()) {
			current.setLeft(removePersonRec(current.getLeft(), id));
		} else if (id > current.getPerson().getIdAsNum()) {
			current.setRight(removePersonRec(current.getRight(), id));
		} else {
			if (current.getLeft() == null) {
				return current.getRight();
			} else if (current.getRight() == null) {
				return current.getLeft();
			}
			TreeNode minNode = findMin(current.getRight());
			current.setPerson(minNode.getPerson());
			current.setRight(removePersonRec(current.getRight(), minNode.getPerson().getIdAsNum()));
		}
		return current;
	}
	private TreeNode findMin(TreeNode right) {
		while (right.getLeft() != null) {
			right = right.getLeft();
		}
		return right;
	}
	public Person searchPerson(int id) {
		return searchPersonRec(root, id);
	}
	public void printAll() {
		printAllPerson(root);
	}
}

