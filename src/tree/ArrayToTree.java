
package tree;

import java.util.HashMap;
import java.util.List;

import model.*;

/**
 * 问题描述：已知一颗二叉树的所有节点值都不同，给定这颗二叉树正确的先序，中序，后序数组。<br/>
 * 请分别用三个函数实现任意两种数组结合重构原来的二叉树，并返回重构二叉树的头节点。<br/>
 * 
 * @author shadow
 * @Date 2016年9月15日上午10:28:55
 * @version 1.0
 * @since
 **/
public class ArrayToTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		List<Integer> preList = tree.preOrder();
		List<Integer> inList = tree.inOrder();
		List<Integer> posList = tree.postOrder();

		System.out.println("Pre List : " + preList);
		System.out.println("In List : " + inList);
		System.out.println("Pos List : " + posList);

		// tree.preOrderMorris(tree.getRoot());
		tree.preOrderMorris(new ArrayToTree().preInToTree(preList, inList));
		System.out.println();
		tree.preOrderMorris(new ArrayToTree().inPosToTree(inList, posList));
		System.out.println();
		tree.preOrderMorris(new ArrayToTree().prePosToTree(preList, posList));
	}

	/**
	 * 解决一：先序和中序结合 前序遍历的第一个值就是根节点，然后再中序遍历中找到这个值，那么这个值的左边部分即为当前二叉树的左子树部分中序遍历结果，
	 * <br/>
	 * 这个值的右边部分即为当前二叉树的右子树部分中序遍历结果。<br/>
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode preInToTree(List<Integer> pre, List<Integer> in) {
		if (pre == null || in == null) {
			return null;
		}
		// 将中序数组的值与索引记录到键值对中
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.size(); i++) {
			map.put(in.get(i), i);
		}

		return preIn(pre, 0, pre.size() - 1, in, 0, in.size() - 1, map);
	}

	/**
	 * 
	 * @param p
	 *            先序数组
	 * @param pi
	 *            先序数组的第一个索引
	 * @param pj
	 *            先序数组的最后一个索引
	 * @param n
	 *            中序数组
	 * @param ni
	 *            中序数组的第一个索引
	 * @param nj
	 *            中序数组的最后一个索引
	 * @param map
	 *            记录中序数组的Map,key为数组元素，value为数组索引
	 * @return
	 */
	private TreeNode preIn(List<Integer> p, int pi, int pj, List<Integer> n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return null;
		}
		TreeNode head = new TreeNode(p.get(pi));
		// 获取头节点在中序数组中的位置
		int index = map.get(p.get(pi));
		head.setLeft(preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map));
		head.setRight(preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map));

		return head;
	}

	/**
	 * 解决二：中序和后序数组结合生成树 基本思想：通过后序数组的最右的值划分中序数组。
	 * 
	 * @param in
	 *            中序列表
	 * @param pos
	 *            后序列表
	 * @return
	 */
	public TreeNode inPosToTree(List<Integer> in, List<Integer> pos) {
		if (in == null || pos == null) {
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.size(); i++) {
			map.put(in.get(i), i);
		}

		return inPos(in, 0, in.size() - 1, pos, 0, pos.size() - 1, map);
	}

	/**
	 * 
	 * @param n
	 *            中序数组
	 * @param ni
	 *            中序数组第一个索引
	 * @param nj
	 *            中序数组最后一个索引
	 * @param s
	 *            后序数组
	 * @param si
	 *            后序数组第一个索引
	 * @param sj
	 *            后序数组最后一个索引
	 * @param map
	 *            中序数组map，key是数组值，value是数组索引
	 * @return
	 */
	private TreeNode inPos(List<Integer> n, int ni, int nj, List<Integer> s, int si, int sj,
			HashMap<Integer, Integer> map) {
		if (si > sj) {
			return null;
		}

		TreeNode head = new TreeNode(s.get(sj));
		int index = map.get(s.get(sj));
		head.setLeft(inPos(n, ni, index - 1, s, si, si + index - ni - 1, map));
		head.setRight(inPos(n, index + 1, nj, s, si + index - ni, sj - 1, map));

		return head;
	}

	/**
	 * 每个节点的孩子数都为0或2的二叉树才能被先序和后序重构出来
	 * @param pre
	 * @param pos
	 * @return
	 */
	public TreeNode prePosToTree(List<Integer> pre, List<Integer> pos) {
		if(pre == null || pos == null){
			return null;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < pos.size(); i++){
			map.put(pos.get(i), i);
		}
		
		return prePos(pre, 0, pre.size() - 1, pos, 0, pos.size() - 1, map);
	}

	private TreeNode prePos(List<Integer> p, int pi, int pj, List<Integer> s, int si, int sj,
			HashMap<Integer, Integer> map) {
		TreeNode head = new TreeNode(s.get(sj--));
		if (pi == pj) {
			return head;
		}

		int index = map.get(p.get(++pi));
		head.setLeft(prePos(p, pi, pi + index - si, s, si, index, map));
		head.setRight(prePos(p, pi + index - si + 1, pj, s, index + 1, sj, map));
		
		return head;
	}
}
