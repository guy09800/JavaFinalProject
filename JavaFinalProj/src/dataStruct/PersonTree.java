package dataStruct;
import personClass.Person;

public class PersonTree {
	TreeNode root;

	public PersonTree() {
		this.root = null;
	}

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

	public Person searchPerson(int id) {
		return searchPersonRec(root, id);
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
}
