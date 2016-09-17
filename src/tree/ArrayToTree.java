
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

		// tree.preOrderMorris(tree.getRoot());
		tree.preOrderMorris(new ArrayToTree().preInToTree(preList, inList));
		System.out.println();
		tree.preOrderMorris(new ArrayToTree().inPosToTree(inList, posList));
		System.out.println();
		tree.preOrderMorris(new ArrayToTree().prePosToTree(preList, posList));
	}

	/**
	 * ���һ������������� ǰ������ĵ�һ��ֵ���Ǹ��ڵ㣬Ȼ��������������ҵ����ֵ����ô���ֵ����߲��ּ�Ϊ��ǰ������������������������������
	 * <br/>
	 * ���ֵ���ұ߲��ּ�Ϊ��ǰ������������������������������<br/>
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode preInToTree(List<Integer> pre, List<Integer> in) {
		if (pre == null || in == null) {
			return null;
		}
		// �����������ֵ��������¼����ֵ����
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.size(); i++) {
			map.put(in.get(i), i);
		}

		return preIn(pre, 0, pre.size() - 1, in, 0, in.size() - 1, map);
	}

	/**
	 * 
	 * @param p
	 *            ��������
	 * @param pi
	 *            ��������ĵ�һ������
	 * @param pj
	 *            ������������һ������
	 * @param n
	 *            ��������
	 * @param ni
	 *            ��������ĵ�һ������
	 * @param nj
	 *            ������������һ������
	 * @param map
	 *            ��¼���������Map,keyΪ����Ԫ�أ�valueΪ��������
	 * @return
	 */
	private TreeNode preIn(List<Integer> p, int pi, int pj, List<Integer> n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return null;
		}
		TreeNode head = new TreeNode(p.get(pi));
		// ��ȡͷ�ڵ������������е�λ��
		int index = map.get(p.get(pi));
		head.setLeft(preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map));
		head.setRight(preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map));

		return head;
	}

	/**
	 * �����������ͺ��������������� ����˼�룺ͨ��������������ҵ�ֵ�����������顣
	 * 
	 * @param in
	 *            �����б�
	 * @param pos
	 *            �����б�
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
	 *            ��������
	 * @param ni
	 *            ���������һ������
	 * @param nj
	 *            �����������һ������
	 * @param s
	 *            ��������
	 * @param si
	 *            ���������һ������
	 * @param sj
	 *            �����������һ������
	 * @param map
	 *            ��������map��key������ֵ��value����������
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
	 * ÿ���ڵ�ĺ�������Ϊ0��2�Ķ��������ܱ�����ͺ����ع�����
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
