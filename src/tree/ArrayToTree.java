
package tree;

import java.util.HashMap;
import java.util.List;

import model.*;

/**
 * ������������֪һ�Ŷ����������нڵ�ֵ����ͬ��������Ŷ�������ȷ���������򣬺������顣<br/>
 * ��ֱ�����������ʵ�����������������ع�ԭ���Ķ��������������ع���������ͷ�ڵ㡣<br/>
 * 
 * @author shadow
 * @Date 2016��9��15������10:28:55
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
	 * ���һ�������������
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
	 *            ��������
	 * @param pi
	 *            ���������
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
		//��ȡͷ�ڵ������������е�λ��
		int index = map.get(p.get(pi));
		head.setLeft(preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map));
		head.setRight(preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map));

		return head;
	}
}
