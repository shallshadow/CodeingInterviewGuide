/**
 * @author shadow
 * @Date 2016年7月30日下午8:24:30
 * @Fun
 **/
package linklist;

import model.LinkDoubleNode;
import model.LinkNode;

public class LinkUntil {

	/**
	 *  将链表的部分节点逆序
	 * @param head
	 * @param from
	 * @param to
	 * @return
	 */
	public static LinkNode reversePart(LinkNode head, int from, int to) {
		int len = 0;
		LinkNode node1 = head;
		LinkNode fPre = null;
		LinkNode tPos = null;

		while (node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1? node1 : tPos;
			node1 = node1.getNext();
		}
		
		if(from > to || from < 1 || to > len){
			return head;
		}
		
		node1 = fPre == null? head : fPre.getNext();
		LinkNode node2 = node1.getNext();
		node1.setNext(tPos);
		LinkNode next = null;
		
		while(node2 != tPos){
			next = node2.getNext();
			node2.setNext(node1);
			node1 = node2;
			node2 = next;
		}
		
		if(fPre != null){
			fPre.setNext(node1);
			return head;
		}

		return node1;
	}

	/**
	 * 双向链表逆序
	 * 
	 * @param head
	 * @return
	 */
	public static LinkDoubleNode reverseList(LinkDoubleNode head) {
		if (head == null) {
			return head;
		}
		LinkDoubleNode pre = null;
		LinkDoubleNode next = null;
		LinkDoubleNode head2 = head;

		do {
			next = (LinkDoubleNode) head.getNext();
			System.err.println(head.getValue());
			head.setNext(pre);
			head.setLast(next);
			pre = head;
			head = next;
		} while (head != head2);

		pre.setLast(head2);
		head2.setNext(pre);

		return pre;
	}

	/**
	 * 反转单向链表
	 * 
	 * @param head
	 * @return
	 */
	public static LinkNode reverseList(LinkNode head) {
		LinkNode pre = null;
		LinkNode next = null;
		while (head != null) {
			next = head.getNext();
			head.setNext(pre);
			pre = head;
			head = next;

		}
		return pre;
	}

	/**
	 * 删除a/b处的节点
	 * 
	 * @param head
	 * @param a
	 * @param b
	 * @return
	 */
	public static LinkNode removeByRatio(LinkNode head, int a, int b) {
		if (a < 1 || a > b) {
			return head;
		}

		int n = 0;
		LinkNode cur = head;
		while (cur != null) {
			n++;
			cur = cur.getNext();
		}

		n = (int) Math.ceil(((double) (a * n)) / (double) b);

		if (n > 1) {
			cur = head;
			while (--n != 1) {
				cur = cur.getNext();
			}
			cur.setNext(cur.getNext().getNext());
		}

		return head;
	}

	/**
	 * @fun 删除链表中间节点
	 * @param head
	 * @return
	 */
	public static LinkNode removeMidNode(LinkNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}

		if (head.getNext().getNext() == null) {
			return head.getNext();
		}

		LinkNode pre = head;
		LinkNode cur = head.getNext().getNext();

		// 循环遍历到中间位置
		while (cur.getNext() != null && cur.getNext().getNext() != null) {
			pre = pre.getNext();
			cur = cur.getNext().getNext();
		}

		pre.setNext(pre.getNext().getNext());

		return head;
	}

	/**
	 * 删除双链表倒数第K个节点
	 * 
	 * @param head
	 * @param lastKth
	 * @return
	 */
	public static LinkDoubleNode removeLastKthNode(LinkDoubleNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}

		LinkDoubleNode cur = head;
		LinkDoubleNode tailCur = head;

		do {
			lastKth--;
			cur = (LinkDoubleNode) cur.getNext();
			if (lastKth < 0) {
				tailCur = (LinkDoubleNode) tailCur.getNext();
				if (cur == head) {
					LinkDoubleNode removeNode = (LinkDoubleNode) tailCur.getNext().getNext();
					tailCur.setNext(removeNode);
					removeNode.setLast(tailCur);
				}

			}
		} while (cur != head);

		return head;
	}

	/**
	 * @fun 打印两个有序链表的公共部分
	 * @param head1
	 * @param head2
	 */
	public static void printCommonPart(LinkNode head1, LinkNode head2) {
		System.out.println("Common Part:");
		while (head1 != null && head2 != null) {
			if (head1.getValue() < head2.getValue()) {
				head1 = head1.getNext();
			} else if (head1.getValue() > head2.getValue()) {
				head2 = head2.getNext();
			} else {
				System.out.println(head1.getValue() + ",");
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
		}
	}

	/**
	 * @fun 删除倒数第K个链表节点
	 * @param head
	 * @param lastKth
	 * @return head
	 */
	public static LinkNode removeLastKthNode(LinkNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		LinkNode cur = head;
		LinkNode removeCur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.getNext();
			if (lastKth < 0) {
				if (cur == null) {
					removeCur.setNext(removeCur.getNext().getNext());
				}
				removeCur = removeCur.getNext();
			}
		}
		return head;
	}
}
