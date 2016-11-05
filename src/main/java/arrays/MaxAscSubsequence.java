
package arrays;

/**
 * @fun 最长递增子序列求解
 * @author shadow
 * @Date 2016年9月1日下午5:08:20
 * @version 1.0
 * @since
 **/
public class MaxAscSubsequence extends ArrayProblem {

	private int[] result;

	public MaxAscSubsequence(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (super.solve()) {
			int[] dp = getDp2(datas);
			MainTest.showArrays(dp);
			result = generateList(datas, dp);
			
			return true;
		}
		return false;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "MaxAscSubsequence ";
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		if(result == null || result.length == 0){
			return;
		}
		
		System.out.println(getDesc() + " Result : ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(" " + result[i]);
		}
		System.out.println();
	}
	/**
	 * 返回的为int arrays
	 */
	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return this.result;
	}

	private int[] generateList(int[] arr, int[] dp) {
		// 最长长度
		int len = 0;
		// 最大下标
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}

		int[] lis = new int[len];
		// 最大下标赋值
		lis[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				lis[--len] = arr[i];
				index = i;
			}
		}

		return lis;
	}

	/**
	 * 求以arr[i]结尾情况下的最长递增子序列长度
	 * 
	 * @param arr
	 * @return
	 */
	public int[] getDp1(int[] arr) {
		int[] dp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		return dp;
	}
	
	private int[] getDp2(int[] arr){
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		//表示有效区位置
		int rEnd = 0;
		//二分法查找
		int right = 0;
		int left = 0;
		int mid = 0;
		
		for(int i = 1; i < arr.length; i++){
			left = 0;
			right = rEnd;
			//查找有效区ends数组
			while(left <= right){
				mid = (left + right) / 2;
			
				if(arr[i] > ends[mid]){
					left = mid + 1;
				}else{
					right = mid - 1;
				} 
			}
			rEnd = Math.max(rEnd, left);
			//维护有效区			
			ends[left] = arr[i];
			dp[i] = left + 1;
		}
		
		return dp;
	}

}
