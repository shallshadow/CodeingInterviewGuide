
package other;

/**
 * @fun ��ˮ���㷨 �����������ȰѶ�����ǰk���������"ˮ��"�����ڵ�k+1������ʼ����k/(k+1)�ĸ���ѡ��ö���<br/>
 *      ��k/(k+2)�������Դ����ƣ���k/m�ĸ���ѡ���m������(m>k)�����m��ѡ�У�������滻ˮ���е�һ������<br/>
 *      ����ÿ������ѡ�еĸ��ʾ�Ϊk/n��<br/>
 * @author shadow
 * @Date 2016��9��8������6:34:35
 * @version 1.0
 * @since
 **/
public class ReservoirAlgorithm {

	public static void main(String[] args) {
		ReservoirAlgorithm algorithm = new ReservoirAlgorithm();
		int[] res = algorithm.getKNumRand(20, 1000);
		for(int r : res){
			System.out.println("R : " + r);
		}
	}
	
	/**
	 * ���㷨��n��֪������µġ�
	 * @param k ˮ���С
	 * @param max n
	 * @return ��ѡ�е�k����������
	 */
	public int[] getKNumRand(int k, int max) {
		if (k < 1 || max < 1) {
			return null;
		}

		int[] res = new int[Math.min(k, max)];
		for(int i = 0; i < k; i++){
			res[i] = i + 1;
		}
		
		for(int i = k; i <= max; i++){
			//�Ƿ�ѡ��
			if(rand(i) <= k){
				res[rand(k) - 1] = i;
			}
		}

		return res;
	}

	private int rand(int max) {
		return (int) (Math.random() * max) + 1;
	}

}
