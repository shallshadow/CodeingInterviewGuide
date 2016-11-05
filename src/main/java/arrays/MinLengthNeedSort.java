
package arrays;

/**
 * @fun 给定数组arr，返回arr的最长递增子序列
 * @author shadow
 * @Date 2016年8月31日上午11:33:08
 * @version 1.0
 * @since
 **/
public class MinLengthNeedSort extends ArrayProblem {

	private int num = 0;

	public MinLengthNeedSort(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if (!super.solve()) {
			return false;
		}
		num = getMinLength(datas);
		return true;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + ".MinlengthNeedSort ";
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : " + num);
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return this.num;
	}

	private int getMinLength(int[] arr) {
		int min = arr[arr.length - 1];
		int noMinIndex = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			// 若数大于最小数，则记录其需要交换的位置
			if (arr[i] > min) {
				noMinIndex = i;
			} else {
				min = Math.min(arr[i], min);
			}
		}

		if (noMinIndex == -1) {
			return 0;
		}

		int max = arr[0];

		int noMaxIndex = -1;
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < max) {
				noMaxIndex = i;
			} else {
				max = Math.max(arr[i], max);
			}
		}
		// System.out.println("max : " + noMaxIndex);
		// System.out.println("min : " + noMinIndex);

		return noMaxIndex - noMinIndex + 1;
	}
}
