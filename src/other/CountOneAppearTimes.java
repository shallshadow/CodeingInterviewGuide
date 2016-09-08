
package other;

/**
 * @fun query the count of '1' appear in the number 1 to n 
 * @author shadow
 * @Date 2016年9月7日下午3:43:59
 * @version 1.0
 * @since
 **/
public class CountOneAppearTimes {

	public static void main(String[] args) {
		CountOneAppearTimes appearTimes = new CountOneAppearTimes();
		System.out.println("Times : " + appearTimes.solve1(20));
	}

	/**
	 * Time complexity:O(logN*logN)
	 * Space complexity:O(1);
	 * @param range
	 * @return
	 */
	public int solve2(int range) {
		if (range < 1) {
			return 0;
		}
		int len = getLenOfNum(range);
		if (len == 1) {
			return 1;
		}
		int tmp = powerBaseOf10(len - 1);
		System.out.println("temp : " + tmp);
		// The biggest digit number.
		int first = range / tmp;
		// only the biggest digit number is 1
		int firstOneNum = first == 1 ? range % tmp + 1 : tmp;
		System.out.println("firstOneNum : " + firstOneNum);
		// only the other digit number is 1
		int otherOneNum = first * (len - 1) * (tmp / 10);
		System.out.println("OtherOneNum : " + otherOneNum);
		return firstOneNum + otherOneNum + solve2(range % tmp);

	}

	private int getLenOfNum(int num) {
		int len = 0;
		while (num != 0) {
			len++;
			num /= 10;
		}
		return len;
	}

	private int powerBaseOf10(int base) {
		return (int) Math.pow(10, base);
	}

	/**
	 * Time complexity:O(NlogN)
	 * @param range
	 * @return
	 */
	public int solve1(int range) {
		int sum = 0;
		for (int i = 1; i <= range; i++) {
			sum += getOneAppearTimes(i);
		}

		return sum;
	}

	/**
	 * 时间复杂度O(logN)
	 * 
	 * @param num
	 *            分解num数字
	 * @return 统计其中出现1的个数
	 */
	public int getOneAppearTimes(int num) {
		int count = 0;
		while (num != 0) {
			if (num % 10 == 1) {
				count++;
			}
			num = num / 10;
		}
		return count;
	}
}
