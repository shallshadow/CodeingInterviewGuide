
package tree;

import java.util.List;

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
		List<Integer> list = tree.inOrder();
		
		TreeNode head = new BinTreeIsBalance().generateTree(list);
		System.out.println("Balance : " + new BinTreeIsBalance().isBalance(head));
		
	}

	/**
	 * 通过有序数组生产平衡搜索二叉树
	 * @param sortArr
	 * @return
	 */
	public TreeNode generateTree(List<Integer> sortArr) {
		if (sortArr == null) {
			return null;
		}
		return generate(sortArr, 0, sortArr.size() - 1);
	}

	private TreeNode generate(List<Integer> sortArr, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode head = new TreeNode(sortArr.get(mid));
		head.setLeft(generate(sortArr, start, mid - 1));
		head.setRight(generate(sortArr, mid + 1, end));

		return head;
	}

	/**
	 * 判断该树是不是一颗平衡二叉树
	 * @param head
	 * @return 
	 */
	public boolean isBalance(TreeNode head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 0, res);
		return res[0];
	}

	/**
	 * 
	 * @param node
	 * @param level
	 * @param res
	 * @return
	 */
	private int getHeight(TreeNode node, int level, boolean[] res) {
		if (node == null) {
			return level;
		}

		int lh = getHeight(node.getLeft(), level + 1, res);
		if (!res[0]) {
			return level;
		}

		int rh = getHeight(node.getRight(), level + 1, res);
		if (!res[0]) {
			return level;
		}

		if (Math.abs(lh - rh) > 1) {
			res[0] = false;
		}
		return Math.max(lh, rh);
	}
}
