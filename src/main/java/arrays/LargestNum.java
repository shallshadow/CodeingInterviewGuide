
package arrays;

import java.util.Arrays;

/**
 * @fun Problem:leetcode 179.
 * @author shadow
 * @Date 2016年9月18日上午10:15:05
 * @version 1.0
 * @since
 **/
public class LargestNum {
	public static void main(String[] args) {
		int[] arr = { 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247 };
		System.out.println(new LargestNum().largestNumber(arr));
		System.out.println(new LargestNum().largestNumber2(arr));
	}

	/**
	 * 采取相邻字符串各自在前相加，比较字符串大小排序
	 * @param nums
	 * @return
	 */
	public String largestNumber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = Integer.toString(nums[i]);
		}

//		Arrays.sort(strings, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				String s1 = o1 + o2;
//				String s2 = o2 + o1;
//				return s2.compareTo(s1);
//			}
//		});
		
		Arrays.sort(strings, (s1, s2)->((s2 + s1).compareTo(s1 + s2)));

//		if (strings[strings.length - 1].charAt(0) == '0') {
//			return "0";
//		}


//		StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < strings.length; i++) {
//			builder.append(strings[i]);
//		}

		String result = String.join("", strings);
		if(result.isEmpty() || result.charAt(0) == '0'){
			return "0";
		}
		return result;
	}

	/**
	 * 采取补位的策略。 选取最高位和最低位的最大值来补齐数字的位数，再进行排序输出。
	 * 
	 * @param nums
	 * @return
	 */
	public String largestNumber(int[] nums) {
		int max = getMax(nums);
		int times = getTimes(max);

		int line = (int) Math.pow(10, times);
		int arr[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = nums[i];
			int bigdit = getBigDit(arr[i]);
			for (int j = 0; j < times; j++) {
				if (arr[i] < line) {
					arr[i] = arr[i] * 10 + bigdit;
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swap(arr, j, j + 1);
					swap(nums, j, j + 1);
				}
			}
		}

		boolean first = true;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			if (first && nums[i] == 0) {
				continue;
			}
			first = false;
			sb.append(nums[i]);
		}
		return sb.toString().equals("") ? "0" : sb.toString();
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int getBigDit(int num) {
		int temp = num;
		while (temp > 10) {
			temp = temp / 10;
		}
		return Math.max(temp, num % 10);
	}

	private int getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int n : nums) {
			if (n > max) {
				max = n;
			}
		}
		return max;
	}

	private int getTimes(int max) {
		int count = 0;
		while (max > 0) {
			max = max / 10;
			count++;
		}
		return count;
	}
}
