
package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.BinaryTree;
import model.TreeNode;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��27������6:57:59
 * @version 1.0
 * @since
 **/
public class SerialTree {
	/**
	 * ǰ����������������л�
	 * @param head
	 * @return
	 */
	public static String serail(TreeNode head){
		if(head == null){
			return "#!";
		}
		
		String result = head.getValue()+"!";
		result += serail(head.getLeft());
		result += serail(head.getRight());
		return result;	
	}
	
	/**
	 * ��ǰ��������л��Ķ����������л�
	 * @param src
	 * @return
	 */
	public static TreeNode unSerial(String src){
		String[] nodes = src.split("!");
		Queue<String> queue = new LinkedList<>();
		for(int i = 0; i < nodes.length; i++){
			queue.offer(nodes[i]);
		}
		return unSerial(queue);
	}
	
	private static TreeNode unSerial(Queue<String> queue){
		String value = queue.poll();
		if(value.equals("#")){
			return null;
		}
		
		TreeNode head = new TreeNode(Integer.valueOf(value));
		head.setLeft(unSerial(queue));
		head.setRight(unSerial(queue));		
		return head;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		String result = serail(tree.getRoot());
		System.out.println(result);
		System.out.println("PerOder:");
		tree.preOrder();
		System.out.println("PerOder2:");
		tree.preOrderMorris(unSerial(result));
	}
}
