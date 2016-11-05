package arrays;

/**
 * @fun 从两个长度相等的排序数组中得到中位数
 * @author shadow
 * @Date 2016年9月7日下午12:37:43
 * @version 1.0
 * @since
 **/
public class TwoSortArrayFindMedian extends ArrayProblem {

	private int[] datas2;
	private int median;

	public TwoSortArrayFindMedian(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	public TwoSortArrayFindMedian(int[] datas, int[] datas2) {
		super(datas);
		// TODO Auto-generated constructor stub
		this.datas2 = datas2;
	}
	
	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if(datas2 == null || datas2.length == 0){
			return false;
		}
		if(! super.solve()){
			return false;
		}
		median = findMedian(datas, datas2);
		
		return true;
		
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + " Find median in two sorted array";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result :" + median);
	}
	
	private int findMedian(int[] datas, int[] datas2){
		int[] mergeData = merge(datas, datas2);
		MainTest.showArrays(mergeData);
		if(mergeData.length % 2 == 0){
			return (mergeData[mergeData.length / 2] + mergeData[mergeData.length / 2 - 1]) / 2;
		}
		return mergeData[mergeData.length / 2];
	}

	/**
	 * 将两个有序数组合并
	 * @param datas  有序数组
	 * @param datas2   有序数组
	 * @return 合并后的有序数组
	 */
	private int[] merge(int[] datas, int[] datas2) {
		int[] mergeData = new int[datas.length + datas2.length];
		int left = 0;
		int right = 0;
		int third = 0;

		while (left < datas.length && right < datas2.length) {
			//将较小的放入第三个数组中
			if (datas[left] <= datas2[right]) {
				mergeData[third++] = datas[left++];
			} else {
				mergeData[third++] = datas2[right++];
			}
		}

		while (left < datas.length) {
			mergeData[third++] = datas[left++];
		}
		
		while (right < datas2.length) {
			mergeData[third++] = datas2[right++];
		}

		return mergeData;
	}
}
