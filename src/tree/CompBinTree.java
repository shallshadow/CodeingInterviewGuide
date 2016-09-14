
package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun 完全二叉树相关方法类
 * @author shadow 
 * @Date 2016年9月14日下午8:50:37
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
	 *  1.按层遍历二叉树，从每层的左边向右边依次遍历所有的节点。
	 *  2.如果当前节点有右孩子，但没有左孩子，直接返回fals。
	 *  3.如果当前节点并不是左右孩子全有，那之后的节点必须都为叶节点，否则返回false。
	 *  4.遍历过程中如果不返回false，遍历结束后返回true。
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
			//判断节点是否为叶子及不对称。
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
