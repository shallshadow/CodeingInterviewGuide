
package arrays;

/**
 * @fun 给定两个字符串str1和str2，返回两个字符串的最长公共子序列。
 * @author shadow
 * @Date 2016年9月1日下午8:42:53
 * @version 1.0
 * @since
 **/
public class MaxComSubsequence extends ArrayProblem {

	private String str1;
	private String str2;
	private String result;
	
	public MaxComSubsequence(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	public MaxComSubsequence(int[] datas,String str1, String str2) {
		super(datas);
		// TODO Auto-generated constructor stub
		this.str1 = str1;
		this.str2 = str2;
	}
	
	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
			return false;
		}
		
		result = lcse(str1, str2);
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "MaxComSubsequence ";
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : " + result);
	}
	
	private String lcse(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();

		int[][] dp = getDp(chs1, chs2);
		
		int m = chs1.length - 1;
		int n = chs2.length - 1;
		char[] res = new char[dp[m][n]];
		int index = res.length - 1;
		while(index >= 0){
			if(n > 0 && dp[m][n] == dp[m][n-1]){
				n--;
			}else if(m > 0 && dp[m][n] == dp[m-1][n]){
				m--;
			}else{
				res[index--] = chs1[m];
				m--;
				n--;
			}
		}

		return String.valueOf(res);
	}

	private int[][] getDp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;

		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}

		for (int i = 1; i < str2.length; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], str1[0] == str2[i] ? 1 : 0);
		}

		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		return dp;
	}

}
