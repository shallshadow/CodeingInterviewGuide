/**
 * @author shadow
 * @Date 2016年7月29日下午10:04:12
 * @Fun
 **/
package model;

/**
 * @Date 2016年7月29日22:06:27
 * @Fun 单向链表节点
 * @author shadow
 *
 */
public class LinkNode {
	private Integer value;
	private LinkNode next;
	public LinkNode(Integer data){
		this.value = data;
	}
	
	public void setNext(LinkNode next){
		this.next = next;
	}
	
	public Integer getValue(){
		return this.value;
	}
	
	public LinkNode getNext(){
		return this.next;
	}
	
	public void Search(){
		LinkNode head = this;
		
		while(head != null){			
			System.out.println("LinkNode : " + head.getValue());
			head = head.getNext();
		}
	}
}
