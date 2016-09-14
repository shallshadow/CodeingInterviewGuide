
package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun ��ȫ��������ط�����
 * @author shadow 
 * @Date 2016��9��14������8:50:37
 * @version 1.0
 * @since
 * 
 **/
public class CompBinTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("Complete Binary Tree is or not : " + new CompBinTree().isCBT(tree.getRoot()));
	}
	/**
	 *  1.�����������������ÿ���������ұ����α������еĽڵ㡣
	 *  2.�����ǰ�ڵ����Һ��ӣ���û�����ӣ�ֱ�ӷ���fals��
	 *  3.�����ǰ�ڵ㲢�������Һ���ȫ�У���֮��Ľڵ���붼ΪҶ�ڵ㣬���򷵻�false��
	 *  4.�������������������false�����������󷵻�true��
	 * @param head
	 * @return
	 */
	public boolean isCBT(TreeNode head){
		if(head == null){
			return false;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		boolean leaf = false;
		TreeNode lNode = null;
		TreeNode rNode = null;
		queue.offer(head);
		while(!queue.isEmpty()){
			head = queue.poll();
			lNode = head.getLeft();
			rNode = head.getRight();
			//�жϽڵ��Ƿ�ΪҶ�Ӽ����Գơ�
			if(leaf && (rNode != null || lNode != null) || (lNode == null && rNode != null)){
				return false;
			}
			
			if(rNode != null){
				queue.offer(rNode);
			}
			
			if(lNode != null){
				queue.offer(lNode);
			}else{
				leaf = true;
			}	
		}
		
		return true;
	}
}
