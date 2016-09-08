
package other;

import java.util.*;

/**
 * @fun �������������һ�ֽṹ���ڸýṹ���������������ܣ�
 * 		insert(key):��ĳ��key���뵽�ýṹ���������ظ����롣
 * 		delete(key):��ԭ���ڽṹ�е�ĳ��key�Ƴ���
 * 		getRandom():�ȸ���������ؽṹ�е��κ�һ��key��
 * @author shadow
 * @Date 2016��9��7������8:44:53
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

	/**
	 * ����ǿ�Ԫ��
	 * @param elem �����Ԫ������
	 * @return �Ƿ����ɹ�
	 */
	@SuppressWarnings("unchecked")
	public boolean insert(K... elem) {
		if(elem == null || elem.length == 0){
			return false;
		}
		
		if (keyIndexMap.containsKey(elem)) {
			return false;
		}
		for (K e : elem) {
			if(e == null){
				continue;
			}
			indexKeyMap.put(size, e);
			keyIndexMap.put(e, size++);
		}

		return true;
	}

	/**
	 * ɾ��Ԫ�غ�Ҫ��֤����Ԫ��������Ȼ������
	 * @param elem ɾ����Ԫ��
	 * @return ɾ���ɹ����
	 */
	public boolean delete(K elem) {
		if (keyIndexMap.containsKey(elem)) {
			int delIndex = keyIndexMap.get(elem);
			int lastIndex = --this.size;
			K lastKey = indexKeyMap.get(lastIndex);
			// ��ɾ��λ�õ����������һ��Ԫ���������
			indexKeyMap.put(delIndex, lastKey);
			// �������һ�����ݵ�index
			keyIndexMap.put(lastKey, lastIndex);
			// �Ƴ����һ��Ԫ�ص�λ��
			indexKeyMap.remove(lastIndex);
			// �Ƴ�Ҫɾ����Ԫ��
			keyIndexMap.remove(elem);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return �ȸ��������ȡԪ��
	 */
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
