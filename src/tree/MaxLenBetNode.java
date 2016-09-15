
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun 问题描述：从二叉树的节点A出发，可以向上或者向下走，<br/>
 * 		但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫做A到B的距离。<br/>
 * @author shadow
 * @Date 2016年9月14日下午9:44:27
 * @version 1.0
 * @since
 **/
public class MaxLenBetNode {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("Distance : " + new MaxLenBetNode().maxDistance(tree.getRoot()));
	}
	
	/**
	 * 一个以h为头的树上，最大距离只可能来自以下三种情况：
	 * 1.h的左子树上的最大距离。
	 * 2.h的右子树上的最大距离。
	 * 3.h左子树上离h.left最远距离 + 1(h) + h右子树上离h.right最远的距离。
	 * @param head
	 * @return
	 */
	public int maxDistance(TreeNode head) {
		int[] record = new int[1];
		return posOrder(head, record);
	}

	private int posOrder(TreeNode head, int[] record) {
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		
		
		//左子树上的最大距离
		int lMax = posOrder(head.getLeft(), record);
		//左子树上距离h左孩子的最远距离
		int maxFormLeft = record[0];
		//右子树上的最大距离
		int rMax = posOrder(head.getRight(), record);
		//右子树上距离h右孩子的最远距离
		int maxFromRight = record[0];
		
		int curNodeMax = maxFormLeft + maxFromRight + 1;
		
		record[0] = Math.max(maxFormLeft, maxFromRight) + 1;
		
		return Math.max(Math.max(lMax, rMax), curNodeMax);
	}
}
