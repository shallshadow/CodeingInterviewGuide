
package other;

/**
 * @fun 蓄水池算法 问题描述：先把读到的前k个对象放入"水库"，对于第k+1个对象开始，以k/(k+1)的概率选择该对象，<br/>
 *      以k/(k+2)个对象，以此类推，以k/m的概率选择第m个对象(m>k)。如果m被选中，则随机替换水库中的一个对象。<br/>
 *      最终每个对象被选中的概率均为k/n。<br/>
 * @author shadow
 * @Date 2016年9月8日下午6:34:35
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
	 * 此算法是n已知的情况下的。
	 * @param k 水库大小
	 * @param max n
	 * @return 被选中的k个数的数组
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
			//是否被选中
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
