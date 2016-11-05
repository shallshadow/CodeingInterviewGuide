
package dp;
/**
 * @fun 问题描述：给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个距离。如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。
 * @author shadow 
 * @Date 2016年9月17日下午8:01:39
 * @version 1.0
 * @since 
 **/
public class JumpGame {
	
	public static void main(String[] args) {
		int[] arr = {3,2,3,1,1,4,5,6,1,1,2,1};
		System.out.println("Jump " + new JumpGame().jump(arr));
	}
	/**
	 * 核心思想就是使跳跃范围最大。
	 * @param arr
	 * @return
	 */
	public int jump(int[] arr){
		if(arr == null || arr.length == 0){
			return 0;
		}
		
		int jump = 0;
		int cur = 0;
		int next = 0;
		for(int i = 0; i < arr.length; i++){
			if(cur < i){
				jump++;
				cur = next;
			}
			next = Math.max(next, i + arr[i]);
		}
		
		return jump;
	}
}
