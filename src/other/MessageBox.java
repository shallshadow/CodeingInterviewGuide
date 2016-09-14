
package other;

import java.util.HashMap;
import java.util.HashSet;

import model.LinkNode;

/**
 * @fun ������������֪һ����Ϣ���᲻�ϵ��³�����1~N������һ������˳���³���<br/>
 *      ����ϴδ�ӡ����Ϊi����ô��i+1����ʱ�����ӡi+1����֮����ܹ��Ĳ�����������������ֱ��1~Nȫ�����ܲ���ӡ�ꡣ<br/>
 *      ʱ�临�Ӷ�Ҫ��O(N)
 * @author shadow
 * @Date 2016��9��12������7:59:33
 * @version 1.0
 * @since
 * @description 
 * 
 **/
public class MessageBox {

	public static void main(String[] args) {
		MessageBox box = new MessageBox();
		int arr[] = new int[20];
		for (int i = 0; i < 20; i++) {
			arr[i] = i + 1;
		}

		int[] randArr = box.outOfOrder(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" - " + randArr[i]);
		}
		//������
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			box.receive(randArr[i]);
		}
		System.out.println();
		box.showHeadMap();
	}

	/**
	 * ������������
	 * @param arr
	 * @return
	 */
	private int[] outOfOrder(int[] arr) {
		int out[] = new int[arr.length];
		HashSet<Integer> set = new HashSet<>();
		int random = 0;
		int index = 0;
		while (true) {
			random = (int) (Math.random() * arr.length);
			// System.out.println("random : " + random);
			if (set.contains(random)) {
				continue;
			} else {
				out[index++] = arr[random];
				set.add(random);
				if (index == arr.length) {
					break;
				}
			}
		}
		return out;
	}
	/**
	 * ��ŵ�ǰͷ�ڵ�
	 */
	private HashMap<Integer, LinkNode> headMap;
	/**
	 * ��ŵ�ǰβ�ڵ�
	 */
	private HashMap<Integer, LinkNode> tailMap;

	private int lastPrint;

	public MessageBox() {
		// TODO Auto-generated constructor stub
		headMap = new HashMap<>();
		tailMap = new HashMap<>();
		lastPrint = 0;
	}

	public void receive(int num) {
		if (num < 1) {
			return;
		}

		LinkNode cur = new LinkNode(num);
		headMap.put(num, cur);
		tailMap.put(num, cur);
		//�ж�β�ڵ�map���Ƿ�ǡ����һ��Сһ�Ľڵ�
		if (tailMap.containsKey(num - 1)) {
			tailMap.get(num - 1).setNext(cur);
			tailMap.remove(num - 1);
			headMap.remove(num);
		}
		//�ж�ͷ�ڵ�map���Ƿ�ǡ����һ����һ�Ľڵ�
		if (headMap.containsKey(num + 1)) {
			cur.setNext(headMap.get(num + 1));
			tailMap.remove(num);
			headMap.remove(num + 1);
		}

		if (headMap.containsKey(lastPrint + 1)) {
			print();
		}
	}
	
	private void showHeadMap(){
		for(Integer integer : headMap.keySet()){
			System.out.print(" i : " + integer);
		}
		System.out.println();
	}

	private void print() {
		LinkNode node = headMap.get(++lastPrint);
		headMap.remove(lastPrint);
		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getNext();
			lastPrint++;
		}
		tailMap.remove(--lastPrint);
		System.out.println();
	}
}
