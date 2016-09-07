
package other;
/**
 * @fun Judge a integer number is palindrome or not. 
 * @author shadow 
 * @Date 2016年9月7日下午3:07:04
 * @version 1.0
 * @since 
 **/
public class JudgeIntIsPalindrome {
	public static void main(String[] args) {
		JudgeIntIsPalindrome palindrome = new JudgeIntIsPalindrome();
		System.err.println(palindrome.isPalindrom(132311));
	}
	
	
	public boolean isPalindrom(int n){
		if(n == Integer.MIN_VALUE){
			return false;
		}
		n = Math.abs(n);
		int bigDigit = 0;
		int litDigit = 0;
		int helpNum = 1;
		
		while(n / helpNum >= 10){
			helpNum *= 10;
		}
		
		while(n != 0){
			//the biggest digit
			if(bigDigit != litDigit){
				return false;
			}
			bigDigit = n / helpNum;
			litDigit = n % 10;
			//reduce the biggest digit by % and the smallest digit by /
			n = (n % helpNum) / 10;	
			//reduce two digit by once
			helpNum = helpNum / 100;
		}
		
		return true;
	}
}
