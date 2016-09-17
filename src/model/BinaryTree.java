
package model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��25������9:40:54
 * @version 1.0
 * @since
 **/
public class BinaryTree {
	private TreeNode root;

	public BinaryTree() {
		root = null;
		int[] datas = { 3, 5, 6, 8, 9, 1, 2 ,4,15,36,24};
		for (int i = 0; i < datas.length; i++) {
			this.insert(root, datas[i]);
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	/**
	 * 
	 * @return ���ĸ߶�
	 */
	public int getHeight() {
		if (this.root == null) {
			return 0;
		}

		return getHeight(this.root);
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private int getHeight(TreeNode node) {
		return node == null ? 0 : 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}

	/**
	 * 
	 * @param value
	 * @return ����valueԪ�����ڵ��·��
	 */
	public int getHeight(int value) {
		return getHeight(this.root, 1, value);
	}

	private int getHeight(TreeNode node, int level, int data) {
		if (node == null) {
			return -1;
		}

		if (node.getValue() == data) {
			return level;
		}

		return Math.max(getHeight(node.getLeft(), level + 1, data), getHeight(node.getRight(), level + 1 , data));
	}

	/**
	 * �ݹ鴴������������
	 * 
	 * @param node
	 * @param data
	 */
	public void insert(TreeNode node, int data) {
		if (root == null) {
			root = new TreeNode(data);
		} else {
			if (data < node.getValue()) {
				if (node.getLeft() == null) {
					node.setLeft(new TreeNode(data));
				} else {
					insert(node.getLeft(), data);
				}
			} else {
				if (node.getRight() == null) {
					node.setRight(new TreeNode(data));
				} else {
					insert(node.getRight(), data);
				}
			}
		}
	}
	


	/**
	 * �ǵݹ�ʵ�ֶ������������
	 * @return Ԫ���б�
	 */
	public List<Integer> preOrder() {
		if (root == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		TreeNode temp = root;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.push(temp);
		while (!deque.isEmpty()) {
			temp = deque.pop();

			if (temp.getRight() != null) {
				deque.push(temp.getRight());
			}

			if (temp.getLeft() != null) {
				deque.push(temp.getLeft());
			}

			list.add(temp.getValue());
		}
		return list;
	}

	/**
	 * �ǵݹ�ʵ�ֶ������������
	 * @return Ԫ���б�
	 */
	public List<Integer> inOrder() {
		if (root == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		TreeNode temp = root;
		Deque<TreeNode> deque = new LinkedList<>();
		while (!deque.isEmpty() || temp != null) {
			if (temp != null) {
				deque.push(temp);
				temp = temp.getLeft();
			} else {
				temp = deque.pop();
				//System.out.print(temp.getValue() + ",");
				list.add(temp.getValue());
				temp = temp.getRight();
			}
		}
		
		return list;
	}

	/**
	 * �ǵݹ�ʵ�ֺ������
	 * @return Ԫ���б�
	 */
	public List<Integer> postOrder() {
		if (root == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		TreeNode temp = root;
		Deque<TreeNode> deque = new LinkedList<>();
		Deque<TreeNode> deque2 = new LinkedList<>();
		deque.push(temp);
		while (!deque.isEmpty()) {
			temp = deque.pop();
			// ����
			deque2.push(temp);

			if (temp.getLeft() != null) {
				deque.push(temp.getLeft());
			}

			if (temp.getRight() != null) {
				deque.push(temp.getRight());
			}
		}
		while (!deque2.isEmpty()) {
			list.add(deque2.pop().getValue());
		}
		
		return list;
	}

	/**
	 * �ǵݹ�ʵ�ֶ������ĺ��������ֻʹ��һ��ջ�����
	 */
	public void postOrder2() {
		if (root == null) {
			return;
		}
		TreeNode temp = root;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.push(temp);
		TreeNode cNode = null;
		while (!deque.isEmpty()) {
			cNode = deque.peek();
			if (cNode.getLeft() != null && temp != cNode.getLeft() && temp != cNode.getRight()) {
				deque.push(cNode.getLeft());
			} else if (cNode.getRight() != null && temp != cNode.getRight()) {
				deque.push(cNode.getRight());
			} else {
				System.out.print(deque.pop().getValue() + ",");
				temp = cNode;
			}
		}

	}

	/**
	 * �ݹ��������
	 * 
	 * @param head
	 */
	public void preOrderTravers(TreeNode head) {
		if (head == null) {
			return;
		}

		System.out.print(head.getValue() + ",");
		preOrderTravers(head.getLeft());
		preOrderTravers(head.getRight());
		
	}

	/**
	 * �ݹ��������
	 * 
	 * @param head
	 */
	public void inOrderTravers(TreeNode head) {
		if (head == null) {
			return;
		}
		preOrderTravers(head.getLeft());
		System.out.print(head.getValue() + ",");
		preOrderTravers(head.getRight());
	}

	/**
	 * �ݹ�������
	 * 
	 * @param head
	 */
	public void postOrderTravers(TreeNode head) {
		if (head == null) {
			return;
		}
		postOrderTravers(head.getLeft());
		postOrderTravers(head.getRight());
		System.out.print(head.getValue() + ",");
	}

	/**
	 * ʹ��Morris�㷨���������������
	 * 
	 * @param head
	 * 
	 * @fun 1.�����ǰ�ڵ������Ϊ�գ��������ǰ�ڵ㲢�����Һ�����Ϊ��ǰ�ڵ㡣<br/>
	 *      2.�����ǰ�ڵ�����Ӳ�Ϊ�գ��ڵ�ǰ�ڵ�����������ҵ���ǰ�ڵ�����������µ�ǰ���ڵ㡣<br/>
	 *      a)���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㡣�����ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ�<br/>
	 *      b)���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ㣬�������Һ�����������Ϊ��(�ָ�������״)�� ��ǰ�ڵ����Ϊ��ǰ�ڵ���Һ��ӡ�<br/>
	 * 
	 *      3.�ظ�����1��2ֱ����ǰ�ڵ�Ϊ�ա�<br/>
	 */
	public void preOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		TreeNode cur2 = null;
		while (cur != null) {
			cur2 = cur.getLeft();
			if (cur2 != null) {
				while (cur2.getRight() != null && cur2.getRight() != cur) {
					cur2 = cur2.getRight();
				}

				if (cur2.getRight() == null) {
					//�����ұߵĿ�ָ��ָ��ǰ���
					cur2.setRight(cur);
					System.out.print(cur.getValue() + ",");
					cur = cur.getLeft();
					continue;
				} else {
					//��ԭ�ұ�
					cur2.setRight(null);
				}
			} else {
				System.out.print(cur.getValue() + ",");
			}

			cur = cur.getRight();
		}
	}

	/**
	 * ʹ��Morris�㷨���������������
	 * 
	 * @param head
	 * 
	 * @fun ���裺 <br/>
	 *      1.�����ǰ�ڵ������Ϊ�գ��������ǰ�ڵ㲢�����Һ�����Ϊ��ǰ�ڵ㡣<br/>
	 *      2.�����ǰ�ڵ�����Ӳ�Ϊ�գ��ڵ�ǰ�ڵ�����������ҵ���ǰ�ڵ�����������µ�ǰ���ڵ㡣<br/>
	 *      a)���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ�<br/>
	 *      b)���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ㣬�������Һ�����������Ϊ��(�ָ�������״)�������ǰ�ڵ㡣 ��ǰ�ڵ����Ϊ��ǰ�ڵ���Һ��ӡ�
	 *      <br/>
	 *      3.�ظ�����1��2ֱ����ǰ�ڵ�Ϊ�ա�<br/>
	 * 
	 */
	public void inOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}

		TreeNode cur = head;
		TreeNode cur2 = null;

		while (cur != null) {
			cur2 = cur.getLeft();
			if (cur2 != null) {
				while (cur2.getRight() != null && cur2.getRight() != cur) {
					cur2 = cur2.getRight();
				}
				if (cur2.getRight() == null) {
					cur2.setRight(cur);
					cur = cur.getLeft();
					continue;
				} else {
					cur2.setRight(null);
					System.out.print(cur.getValue() + ",");
				}
			} else {
				System.out.print(cur.getValue() + ",");
			}

			cur = cur.getRight();
		}
	}

	/**
	 * ʹ��Morris�㷨���������������
	 * 
	 * @param head
	 * 
	 * @fun ���裺<br/>
	 *      ��ǰ�ڵ�����Ϊ��ʱ�ڵ�dump�� 1.�����ǰ�ڵ������Ϊ�գ������Һ�����Ϊ��ǰ�ڵ㡣
	 *      2.�����ǰ�ڵ�����Ӳ�Ϊ�գ��ڵ�ǰ�ڵ�����������ҵ���ǰ�ڵ�����������µ�ǰ���ڵ㡣
	 *      a)���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ�
	 *      b)���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ㣬�������Һ���������Ϊ�ա���������ӵ�ǰ�ڵ�����ӵ���ǰ���ڵ���
	 *      ��·���ϵ����нڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ���Һ��ӡ� 3.�ظ�����1��2ֱ����ǰ�ڵ�Ϊ�ա�
	 */
	public void postOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}

		// ��ʱ�ڵ�
		TreeNode dump = new TreeNode(0);
		dump.setLeft(head);

		TreeNode cur = dump;
		TreeNode cur2 = null;

		while (cur != null) {
			cur2 = cur.getLeft();
			if (cur2 != null) {
				while (cur2.getRight() != null && cur2.getRight() != cur) {
					cur2 = cur2.getRight();
				}
				if (cur2.getRight() == null) {
					cur2.setRight(cur);
					cur = cur.getLeft();
					continue;
				} else {
					cur2.setRight(null);
					printEdge(cur.getLeft());
				}
			}
			cur = cur.getRight();
		}
	}

	/**
	 * 
	 * @param head
	 * 
	 * @fun ��������ӵ�ǰ�ڵ�����ӵ���ǰ���ڵ�����·���ϵ����нڵ㡣
	 */
	private void printEdge(TreeNode head) {
		TreeNode tail = reverseEdge(head);
		TreeNode cur = tail;
		while (cur != null) {
			System.out.print(cur.getValue() + ",");
			cur = cur.getRight();
		}

		reverseEdge(tail);
	}

	/**
	 * ���������Һ���
	 * 
	 * @param head
	 * @return
	 */
	public TreeNode reverseEdge(TreeNode head) {
		TreeNode pre = null;
		TreeNode next = null;
		while (head != null) {
			next = head.getRight();
			head.setRight(pre);
			pre = head;
			head = next;
		}
		return pre;
	}

	/**
	 * �������
	 * 
	 * @param head
	 * 
	 */
	public void levelOrder(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode temp = head;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.addFirst(temp);
		while (!deque.isEmpty()) {
			temp = deque.removeLast();
			if (temp.getLeft() != null) {
				deque.addFirst(temp.getLeft());
			}

			if (temp.getRight() != null) {
				deque.addFirst(temp.getRight());
			}
			System.out.print(temp.getValue() + ",");
		}
	}

	/**
	 * �����������ṹ��ӡ������
	 * 
	 * @param head
	 */
	public void printTree(TreeNode head) {
		System.out.println("Binary tree:");
		printInOrder(head, 0, "H", 17);
	}

	private void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}

		printInOrder(head.getRight(), height + 1, "v", len);
		String val = to + head.getValue() + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.getLeft(), height + 1, "^", lenR);
	}

	private String getSpace(int num) {
		String space = " ";
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < num; i++) {
			buffer.append(space);
		}

		return buffer.toString();
	}
}
