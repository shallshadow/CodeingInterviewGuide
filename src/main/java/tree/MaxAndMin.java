
package tree;

import java.util.HashMap;
import model.BinaryTree;
import model.TreeNode;

/**
 * @fun 在儿叉树中找到累积和为指定值得最长路径长度
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月27日下午7:42:21
 * @version 1.0
 * @since
 **/
public class MaxAndMin {
	/**
	 * 在二叉树中找到累加和为指定值得最长路径长度
	 * @param head
	 * @param sum
	 * @return
	 */
	public static int getMaxLength(TreeNode head, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, 0);		
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}

	public static int preOrder(TreeNode head, int sum, int preSum, int level, int maxLen,
			HashMap<Integer, Integer> sumMap) {
		
		if(head == null){
			return maxLen;
		}
		
		int curSum = preSum + head.getValue();
		//判断累加结果集中是否已出现当前结果，若未出现添加
		if(!sumMap.containsKey(curSum)){
			sumMap.put(curSum, level);
		}
		//判断当前累计和与目标的差值，并判断其是否已出现在累加结果集中
		if(sumMap.containsKey(curSum - sum)){
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		
		maxLen = preOrder(head.getLeft(), sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(head.getRight(), sum, curSum, level + 1, maxLen, sumMap);
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("Max Length 22 : " + getMaxLength(tree.getRoot(), 22));
	}
}
