
package other;

import java.util.*;

/**
 *
 * @author shadow
 * @Date 2016年9月7日下午8:44:53
 * @version 1.0
 * @since
 **/
public class RandomPool<K> {
	private HashMap<Integer, K> indexKeyMap;
	private HashMap<K, Integer> keyIndexMap;
	private int size;

	public RandomPool() {
		// TODO Auto-generated constructor stub
		this.indexKeyMap = new HashMap<>();
		this.keyIndexMap = new HashMap<>();
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	public boolean insert(K... elem) {
		if (keyIndexMap.containsKey(elem)) {
			return false;
		}
		for (K e : elem) {
			indexKeyMap.put(size, e);
			keyIndexMap.put(e, size++);
		}

		return true;
	}

	public boolean delete(K elem) {
		if (keyIndexMap.containsKey(elem)) {
			int delIndex = keyIndexMap.get(elem);
			int lastIndex = --this.size;
			K lastKey = indexKeyMap.get(lastIndex);
			// 将删除位置的数据用最后一个元素数据填充
			indexKeyMap.put(delIndex, lastKey);
			// 更新最后一个数据的index
			keyIndexMap.put(lastKey, lastIndex);
			// 移除最后一个元素的位置
			indexKeyMap.remove(lastIndex);
			// 移除要删除的元素
			keyIndexMap.remove(elem);
			return true;
		}
		return false;
	}

	public K getRandom() {
		if (this.size == 0) {
			return null;
		}

		int randomIndex = (int) (Math.random() * this.size);
		return this.indexKeyMap.get(randomIndex);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return indexKeyMap.toString();
	}

	public static void main(String[] args) {
		RandomPool<Integer> randomPool = new RandomPool<>();
		randomPool.insert(1,2,3,4,5,6,7,8,9,10);
		randomPool.delete(1);
		randomPool.delete(4);
		for(int i = 0; i < 20; i++){
			System.out.println(i + " :" + randomPool.getRandom());
		}
		
		System.out.println(randomPool.toString());
	}
}
