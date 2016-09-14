
package tree;

import model.BinaryTree;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月25日下午8:58:56
 * @version 1.0
 * @since  二叉树遍历测试
 **/
public class TreeSearchTest {
	public static void main(String[] args) {
		BinaryTree head = new BinaryTree();

		
		System.out.print("PreOrder by recurrence:");
		head.preOrderTravers(head.getRoot());
		System.out.print("\nPreOrder by stack: ");
		head.preOrder();
		System.out.print("\nPreOrder by Morris: ");
		head.preOrderMorris(head.getRoot());
		System.out.println();		
	
		System.out.print("\nInOreder by recurrence:");
		head.inOrderTravers(head.getRoot());
		System.out.print("\nInOrder by stack:  ");
		head.inOrder();		
		System.out.print("\nInOrder by Morris: ");
		head.inOrderMorris(head.getRoot());
		System.out.println();

		System.out.print("\nPostOrder by recurrence:");
		head.postOrderTravers(head.getRoot());
		System.out.print("\nPostOrder by double stack: ");
		head.postOrder();
		System.out.print("\nPostOrder by one stack: ");
		head.postOrder2();
		System.out.print("\nPostOrder by Morris: ");
		head.postOrderMorris(head.getRoot());	
		System.out.println();
		
		System.out.print("\nLevelOrder by Morris: ");
		head.levelOrder(head.getRoot());
		System.out.println();
		
		head.printTree(head.getRoot());
		
		System.out.println("height : " + head.getHeight());
		System.out.println("height 1　: " + head.getHeight(9));
	}
}
