
package random;

/**
 * @fun 线性同余方法：X(n+1) = (aX(n) + c)(mod m)
 * @author shadow
 * @Date 2016年9月11日下午7:35:12
 * @version 1.0
 * @since
 **/
public class CustomRandom {
	static final int FIGURES = 10000;
	static long mRandom;

	public static void main(String[] args) {
		long seed = System.currentTimeMillis();
		mRandom = seed % FIGURES;
		for(int i = 0; i < 100; i++){
			System.out.println(getRandom(seed));
		}
	}

	private static long getRandom(long seed) {
		return mRandom = ((mRandom * mRandom) / (long) Math.pow(10, 5 / 2)) % FIGURES;
	}
}
