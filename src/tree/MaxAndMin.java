
package tree;

import java.util.HashMap;
import model.BinaryTree;
import model.TreeNode;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��27������7:42:21
 * @version 1.0
 * @since
 **/
public class MaxAndMin {
	/**
	 * �ڶ��������ҵ��ۼӺ�Ϊָ��ֵ���·������
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
		//�ж��ۼӽ�������Ƿ��ѳ��ֵ�ǰ�������δ�������
		if(!sumMap.containsKey(curSum)){
			sumMap.put(curSum, level);
		}
		//�жϵ�ǰ�ۼƺ���Ŀ��Ĳ�ֵ�����ж����Ƿ��ѳ������ۼӽ������
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
