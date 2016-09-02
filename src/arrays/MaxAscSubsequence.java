
package arrays;

/**
 * @fun ��������������
 * @author shadow
 * @Date 2016��9��1������5:08:20
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
	 * ���ص�Ϊint arrays
	 */
	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return this.result;
	}

	private int[] generateList(int[] arr, int[] dp) {
		// �����
		int len = 0;
		// ����±�
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}

		int[] lis = new int[len];
		// ����±긳ֵ
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
	 * ����arr[i]��β����µ�����������г���
	 * 
	 * @param arr
	 * @return
	 */
	private int[] getDp1(int[] arr) {
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
		//��ʾ��Ч��λ��
		int rEnd = 0;
		//���ַ�����
		int right = 0;
		int left = 0;
		int mid = 0;
		
		for(int i = 1; i < arr.length; i++){
			left = 0;
			right = rEnd;
			//������Ч��ends����
			while(left <= right){
				mid = (left + right) / 2;
			
				if(arr[i] > ends[mid]){
					left = mid + 1;
				}else{
					right = mid - 1;
				} 
			}
			rEnd = Math.max(rEnd, left);
			//ά����Ч��			
			ends[left] = arr[i];
			dp[i] = left + 1;
		}
		
		return dp;
	}

}
