package arrays;

import java.util.HashMap;

/**
 * @Fun Integer Array get max-length's subarray that summary is k
 * @author shadow
 * @Date 2016年9月7日下午12:11:35
 * @version 1.0
 * @since
 **/
public class IntSubMaxLength extends ArrayProblem {

	private int k;
	private int length;

	public IntSubMaxLength(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	public IntSubMaxLength(int[] datas, int k) {
		super(datas);		
		// TODO Auto-generated constructor stub
		this.k = k;
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (!super.solve()) {
			return false;
		}
		length = getMaxLength(datas, k);
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + " Integer Array Get Max-length's Subarray that summary is k ";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : " + length);
	}

	/**
	 * 获取数组和为k的最大子序列数组的长度
	 * @param datas 目标数组
	 * @param k 数字和
	 * @return
	 */
	private int getMaxLength(int[] datas, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// 和为0的子数组长度为-1
		map.put(0, -1);
		// 最长子串的长度
		int len = 0;
		// 数组和
		int sum = 0;
		for (int i = 0; i < datas.length; i++) {
			sum += datas[i];
			if (map.get(sum - k) != null) {
				len = Math.max(len, i - map.get(sum - k));
			}else{
				if(!map.containsKey(sum-k)){
					map.put(sum - k, i);
				}
			}
		}

		return len;
	}
}
