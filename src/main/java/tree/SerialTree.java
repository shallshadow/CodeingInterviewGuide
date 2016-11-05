
package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.BinaryTree;
import model.TreeNode;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月27日下午6:57:59
 * @version 1.0
 * @since
 **/
public class SerialTree {
	/**
	 * 前序遍历将二叉树序列化
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
	 * 将前序遍历序列化的二叉树反序列化
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
