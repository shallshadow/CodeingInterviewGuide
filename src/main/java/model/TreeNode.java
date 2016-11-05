package model;

/**
 * @Date 2016年7月27日20:39:06
 * @fun 树节点
 * @author shadow
 *
 */
public class TreeNode {
	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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

	public TreeNode(int data){
		this.value = data;
	}
}
