
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun ������������ط�����
 * @author shadow 
 * @Date 2016��9��14������11:25:21
 * @version 1.0
 * @since 
 **/
public class SearchTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("IS BST : " + new SearchTree().isBST(tree.getRoot()));
	}
	
	
	
	/**
	 * �ж����Ƿ�Ϊ����������<br/>
	 * ԭ������������������ڱ����Ĺ����п��ڵ�ֵ�Ƿ��ǵ����ļ��ɡ�<br/>
	 * @param head
	 * @return
	 */
	public boolean isBST(TreeNode head){
		if(head == null){
			return true;
		}
		
		boolean res = true;
		TreeNode pre = null;
		TreeNode cur1 = head;
		TreeNode cur2 = null;
		
		while(cur1 != null){
			cur2 = cur1.getLeft();
			if(cur2 != null){
				//�õ����ұ�Ϊ�ҽڵ�Ϊ�յ���
				while(cur2.getRight() != null && cur2.getRight() != cur1){
					cur2 = cur2.getRight();
				}
				
				if(cur2.getRight() == null){
					cur2.setRight(cur1);
					cur1 = cur1.getLeft();
					continue;
				}else{
					cur2.setRight(null);
				}
			}
			
			if(pre != null && pre.getValue() > cur1.getValue()){
				res = false;
			}
			pre = cur1;
			System.out.print(" " + cur1.getValue());
			cur1 = cur1.getRight();
		}		
		System.out.println();
		return res;
	}
}
