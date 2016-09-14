
package tree;

import model.BinaryTree;
import model.TreeNode;

/**
 * @fun ƽ�����������෽��
 * @author shadow 
 * @Date 2016��9��14������10:43:26
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
