
package other;

import java.util.HashMap;
import java.util.HashSet;

import model.LinkNode;

/**
 * @fun 问题描述：已知一个消息流会不断地吐出整数1~N，但不一定按照顺序吐出。<br/>
 *      如果上次打印的数为i，那么当i+1出现时，请打印i+1及其之后接受过的并且连续的所有数，直到1~N全部接受并打印完。<br/>
 *      时间复杂度要求：O(N)
 * @author shadow
 * @Date 2016年9月12日下午7:59:33
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
		//缓冲冲出
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			box.receive(randArr[i]);
		}
		System.out.println();
		box.showHeadMap();
	}

	/**
	 * 将数组乱序函数
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
	 * 存放当前头节点
	 */
	private HashMap<Integer, LinkNode> headMap;
	/**
	 * 存放当前尾节点
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
		//判断尾节点map中是否恰好有一个小一的节点
		if (tailMap.containsKey(num - 1)) {
			tailMap.get(num - 1).setNext(cur);
			tailMap.remove(num - 1);
			headMap.remove(num);
		}
		//判断头节点map中是否恰好有一个大一的节点
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
