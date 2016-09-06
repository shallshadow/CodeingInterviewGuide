package stackAndQueue;

import java.util.HashMap;
import java.util.Stack;
import model.TreeNode;

/**
 * @Date 2016Äê7ÔÂ27ÈÕ20:39:32
 * @Fun
 * @author shadow
 *
 */
public class MaxTree {

	public static void main(String[] args) {
		MaxTree tree = new MaxTree();
		int arr[] = {3,4,5,1,2};
		TreeNode head = tree.getMaxTree(arr);
		
		
		System.err.println(head.getValue());
		tree.findTree(head);
		
	}
	
	public void findTree(TreeNode node){		
		if(node == null){
			return;
		}
		
		findTree(node.getLeft());
		findTree(node.getRight());
		System.out.println(node.getValue());
	}
	
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public TreeNode getMaxTree(int[] arr) {
		TreeNode[] nodes = getNodes(arr);

		Stack<TreeNode> stack = new Stack<>();
		HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
		HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();

		findFirstMax(nodes, stack, lBigMap);
		reverse(nodes);
		findFirstMax(nodes, stack, rBigMap);
		reverse(nodes);
		
		return getHead(nodes, lBigMap, rBigMap);
	}

	private TreeNode getHead(TreeNode[] nodes, HashMap<TreeNode, TreeNode>lBigMap, HashMap<TreeNode, TreeNode> rBigMap){
		TreeNode head = null;
		for(int i = 0; i < nodes.length; i++){
			TreeNode curNode = nodes[i];
			TreeNode left = lBigMap.get(curNode);
			TreeNode right = rBigMap.get(curNode);
			
			if(left == null && right == null){
				head = curNode;
			}else if(left == null){
				if(right.getLeft() == null){
					right.setLeft(curNode);
				}else{
					right.setRight(curNode);
				}
			}else if(right == null){
				if(left.getLeft() == null){
					left.setLeft(curNode);
				}else{
					left.setRight(curNode);
				}
			}else{
				TreeNode parent = left.getValue() < right.getValue() ? left : right;				
				if(parent.getLeft() == null){
					parent.setLeft(curNode);
				}else{
					parent.setRight(curNode);
				}
			}
		}
		
		return head;
	}
	
	/**
	 * reverse Node array
	 * @param nodes
	 */
	private void reverse(TreeNode[] nodes) {
		TreeNode temp = null;
		for (int i = 0; i < nodes.length / 2; i++) {
				temp = nodes[i];
				nodes[i] = nodes[nodes.length - i - 1];
				nodes[nodes.length - i - 1] = temp;
		}
	}

	private void findFirstMax(TreeNode[] nodes, Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
		for (int i = 0; i < nodes.length; i++) {
			TreeNode curNode = nodes[i];
			while ((!stack.isEmpty()) && stack.peek().getValue() < curNode.getValue()) {
				popStackSetMap(stack, map);
			}
			stack.push(curNode);
		}

		while (!stack.isEmpty()) {
			popStackSetMap(stack, map);
		}
	}

	/**
	 * @Fun Take Node into HashMap
	 * @param stack
	 * @param map
	 */
	private void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
		TreeNode popNode = stack.pop();
		if (stack.isEmpty()) {
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}

	/**
	 * get Node array from int array.
	 * @param arr
	 * @return
	 */
	private TreeNode[] getNodes(int[] arr) {
		TreeNode[] nodes = new TreeNode[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nodes[i] = new TreeNode(arr[i]);
		}

		return nodes;
	}
}
