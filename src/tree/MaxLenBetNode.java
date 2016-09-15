
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun �����������Ӷ������Ľڵ�A�������������ϻ��������ߣ�<br/>
 * 		����;�Ľڵ�ֻ�ܾ���һ�Σ�������ڵ�Bʱ��·���ϵĽڵ�������A��B�ľ��롣<br/>
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
	
	/**
	 * һ����hΪͷ�����ϣ�������ֻ���������������������
	 * 1.h���������ϵ������롣
	 * 2.h���������ϵ������롣
	 * 3.h����������h.left��Զ���� + 1(h) + h����������h.right��Զ�ľ��롣
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
		
		
		//�������ϵ�������
		int lMax = posOrder(head.getLeft(), record);
		//�������Ͼ���h���ӵ���Զ����
		int maxFormLeft = record[0];
		//�������ϵ�������
		int rMax = posOrder(head.getRight(), record);
		//�������Ͼ���h�Һ��ӵ���Զ����
		int maxFromRight = record[0];
		
		int curNodeMax = maxFormLeft + maxFromRight + 1;
		
		record[0] = Math.max(maxFormLeft, maxFromRight) + 1;
		
		return Math.max(Math.max(lMax, rMax), curNodeMax);
	}
}
