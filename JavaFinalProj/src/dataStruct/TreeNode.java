package dataStruct;
ssss
import ruppinLand.Person;

public class TreeNode {
	Person person;
	TreeNode left;
	TreeNode right;

	public TreeNode(Person person) {
		this.person = person;
		this.left = null;
		this.right = null;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
		
	public TreeNode getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}
}
