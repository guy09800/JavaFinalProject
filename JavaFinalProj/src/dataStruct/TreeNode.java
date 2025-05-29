package dataStruct;

import personClass.Person;

public class TreeNode {
	Person person;
	TreeNode left;
	TreeNode right;

	public TreeNode(Person person) {
		this.person = person;
		this.left = null;
		this.right = null;
	}
	//Getters:
	public Person getPerson() {return person;}
	public TreeNode getLeft() {return left;}
	public TreeNode getRight() {return right;}
	//Setters:
	public void setPerson(Person person) {this.person = person;}
	public void setLeft(TreeNode left) {this.left = left;}
	public void setRight(TreeNode right) {this.right = right;}
	//Other methods:
	public boolean isLeaf() {return left == null && right == null;}
}
