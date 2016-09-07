
package arrays;

import java.util.HashMap;

/**
 * @Fun Integer Array get max-length's subarray that summary is k
 * @author shadow
 * @Date 2016��9��7������12:11:35
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
	 * ��ȡ�����Ϊk���������������ĳ���
	 * @param datas Ŀ������
	 * @param k ���ֺ�
	 * @return
	 */
	private int getMaxLength(int[] datas, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// ��Ϊ0�������鳤��Ϊ-1
		map.put(0, -1);
		// ��Ӵ��ĳ���
		int len = 0;
		// �����
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
