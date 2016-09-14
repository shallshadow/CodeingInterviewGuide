
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun �����������Ӷ������Ľڵ�A�������������ϻ��������ߣ�����;�Ľڵ�ֻ�ܾ���һ�Σ�������ڵ�Bʱ��·���ϵĽڵ�������A��B�ľ���
 * @author shadow
 * @Date 2016��9��14������9:44:27
 * @version 1.0
 * @since
 **/
public class MaxLenBetNode {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("Distance : " + new MaxLenBetNode().maxDistance(tree.getRoot()));
	}
	
	public int maxDistance(TreeNode head) {
		int[] record = new int[1];
		return posOrder(head, record);
	}

	private int posOrder(TreeNode head, int[] record) {
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = posOrder(head.getLeft(), record);
		int maxFormLeft = record[0];
		int rMax = posOrder(head.getRight(), record);
		int maxFromRight = record[0];
		int curNodeMax = maxFormLeft + maxFromRight + 1;
		record[0] = Math.max(maxFormLeft, maxFromRight) + 1;
		return Math.max(Math.max(lMax, rMax), curNodeMax);
	}
}
