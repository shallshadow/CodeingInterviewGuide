
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun 平衡二叉树相关类方法
 * @author shadow 
 * @Date 2016年9月14日上午10:43:26
 * @version 1.0
 * @since 
 **/
public class BinTreeIsBalance {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("Balance : " + new BinTreeIsBalance().isBalance(tree.getRoot()));
	}
	
	public boolean isBalance(TreeNode head){
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 0, res);
		return res[0];
	}
	
	public int getHeight(TreeNode node, int level, boolean[] res){
		if(node == null){
			return level;
		}
		
		int lh = getHeight(node.getLeft(), level + 1, res);
		if(!res[0]){
			return level;
		}
		
		int rh = getHeight(node.getRight(), level + 1, res);
		if(!res[0]){
			return level;
		}
		
		if(Math.abs(lh-rh) > 1){
			res[0] = false;
		}
		return Math.max(lh, rh);
	}
}
