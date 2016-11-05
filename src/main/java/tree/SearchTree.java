
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun 搜索二叉树相关方法类
 * @author shadow 
 * @Date 2016年9月14日上午11:25:21
 * @version 1.0
 * @since 
 **/
public class SearchTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("IS BST : " + new SearchTree().isBST(tree.getRoot()));
	}
	
	
	
	/**
	 * 判断树是否为搜索二叉树<br/>
	 * 原理：二叉树中序遍历，在遍历的过程中看节点值是否都是递增的即可。<br/>
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
				//得到最右边为右节点为空的树
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
