
package model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月25日下午9:40:54
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
	 * @return 树的高度
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
	 * @return 树中value元素所在的最长路径
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
	 * 递归创建搜索二叉树
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
	 * 非递归实现二叉树先序遍历
	 * @return 元素列表
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
	 * 非递归实现二叉树中序遍历
	 * @return 元素列表
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
	 * 非递归实现后序遍历
	 * @return 元素列表
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
			// 逆序
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
	 * 非递归实现二叉树的后序遍历，只使用一个栈的情况
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
	 * 递归先序遍历
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
	 * 递归中序遍历
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
	 * 递归后序遍历
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
	 * 使用Morris算法，先序遍历二叉树
	 * 
	 * @param head
	 * 
	 * @fun 1.如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。<br/>
	 *      2.如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。<br/>
	 *      a)如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点。当前节点更新为当前节点的左孩子。<br/>
	 *      b)如果前驱节点的右孩子为当前节点，则将它的右孩子重新设置为空(恢复树的形状)。 当前节点更新为当前节点的右孩子。<br/>
	 * 
	 *      3.重复以上1、2直到当前节点为空。<br/>
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
					//将最右边的空指针指向当前结点
					cur2.setRight(cur);
					System.out.print(cur.getValue() + ",");
					cur = cur.getLeft();
					continue;
				} else {
					//还原右边
					cur2.setRight(null);
				}
			} else {
				System.out.print(cur.getValue() + ",");
			}

			cur = cur.getRight();
		}
	}

	/**
	 * 使用Morris算法，中序遍历二叉树
	 * 
	 * @param head
	 * 
	 * @fun 步骤： <br/>
	 *      1.如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。<br/>
	 *      2.如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。<br/>
	 *      a)如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。<br/>
	 *      b)如果前驱节点的右孩子为当前节点，则将它的右孩子重新设置为空(恢复树的形状)。输出当前节点。 当前节点更新为当前节点的右孩子。
	 *      <br/>
	 *      3.重复以上1、2直到当前节点为空。<br/>
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
	 * 使用Morris算法，后序遍历二叉树
	 * 
	 * @param head
	 * 
	 * @fun 步骤：<br/>
	 *      当前节点设置为临时节点dump。 1.如果当前节点的左孩子为空，则将其右孩子作为当前节点。
	 *      2.如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 *      a)如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 *      b)如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。倒序输出从当前节点的左孩子到该前驱节点这
	 *      条路径上的所有节点。当前节点更新为当前节点的右孩子。 3.重复以上1、2直到当前节点为空。
	 */
	public void postOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}

		// 临时节点
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
	 * @fun 倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。
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
	 * 逆序树的右孩子
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
	 * 层序遍历
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
	 * 按照正常树结构打印二叉树
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
