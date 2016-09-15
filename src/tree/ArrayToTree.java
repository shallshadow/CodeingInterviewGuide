
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
		
		//tree.preOrderMorris(tree.getRoot());
		tree.preOrderMorris(new ArrayToTree().preInToTree(preList, inList));
	}
	/**
	 * 解决一：先序和中序结合
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode preInToTree(List<Integer> pre, List<Integer> in) {
		if(pre == null || in == null){
			return null;
		}
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < in.size(); i++){
			map.put(in.get(i), i);
		}
		
		return preIn(pre, 0, pre.size() - 1, in, 0, in.size() - 1, map);
	}

	/**
	 * 
	 * @param p
	 *            先序数组
	 * @param pi
	 *            先序数组的
	 * @param pj
	 * @param n
	 * @param ni
	 * @param nj
	 * @param map
	 * @return
	 */
	private TreeNode preIn(List<Integer> p, int pi, int pj, List<Integer> n, int ni, int nj, HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return null;
		}
		TreeNode head = new TreeNode(p.get(pi));
		//获取头节点在中序数组中的位置
		int index = map.get(p.get(pi));
		head.setLeft(preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map));
		head.setRight(preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map));

		return head;
	}
}
