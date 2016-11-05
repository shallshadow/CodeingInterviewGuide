
package arrays;

import matrix.MainTest;

/**
 * @fun 添加最少字符，使字符串成为回文字符串。
 * @author shadow
 * @Date 2016年9月1日下午3:24:13
 * @version 1.0
 * @since
 **/
public class Palindrome extends ArrayProblem {

	private String string;

	public Palindrome(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	public Palindrome(int[] datas, String str) {
		this(datas);
		this.string = str;
	}
	
	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		string = getPalindrome(string);
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "Palindrom ";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : " + this.string);
	}

	private String getPalindrome(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}

		char[] chas = str.toCharArray();
		int[][] dp = getDP(chas);
		MainTest.showMatrix(dp);
		
		char[] res = new char[chas.length + dp[0][chas.length - 1]];

		int i = 0;
		int j = chas.length - 1;
		int resl = 0;
		int resr = res.length - 1;
		while (i <= j) {
			if (chas[i] == chas[j]) {
				res[resl++] = chas[i++];
				res[resr--] = chas[j--];
			} else if (dp[i][j - 1] < dp[i + 1][j]) {
				res[resl++] = chas[j];
				res[resr--] = chas[j--];
			}else {
				res[resl++] = chas[i];
				res[resr--] = chas[i++];
			}
		}

		return String.valueOf(res);
	}

	private int[][] getDP(char[] str) {
		int[][] dp = new int[str.length][str.length];
		for (int j = 1; j < str.length; j++) {
			dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
			//System.err.print("j-2 : " + (j - 2));
			for (int i = j - 2; i > -1; i--) {
				//System.err.println("   I : " + i);
				if (str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
				
			}
			
		}
		return dp;
	}

}
