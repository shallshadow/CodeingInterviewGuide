/**
 * @author shadow
 * @Date 2016年7月29日下午10:07:23
 * @Fun
 **/
package linklist;

import model.LinkDoubleNode;
import model.LinkNode;

/**
 * @Date 2016年7月29日22:15:36
 * @Fun 链表生产类
 * @author shadow
 *
 */
public class LinkList {
	
	/**
	 * 创建双向链表
	 * @param arr
	 * @return
	 */
	public static LinkDoubleNode CreateDoubleLinkList(int[] arr){
		LinkDoubleNode head = null;
		LinkDoubleNode tail = null;
		LinkDoubleNode temp = null;
		
		for(int i = 0; i < arr.length; i++){
			if(head == null){
				head = new LinkDoubleNode(arr[i]);
				temp = head;
			}else{
				tail = temp;
				temp.setNext(new LinkDoubleNode(arr[i]));
				temp = (LinkDoubleNode) temp.getNext();
				temp.setLast(tail);
			}
		}
		
		head.setLast(temp);
		temp.setNext(head);
		
		return head;
	}
	
	public static LinkNode Create(int[] arr){
		LinkNode head = null;
		LinkNode temp = head;

		for(int i = 0; i < arr.length; i++){
			if(head == null){
				head = new LinkNode(arr[i]);
				temp = head;
			}else{				 
				temp.setNext(new LinkNode(arr[i]));	
				temp = temp.getNext();
			}				
		}		
		return head;
	}
}
