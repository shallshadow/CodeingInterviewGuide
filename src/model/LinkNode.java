/**
 * @author shadow
 * @Date 2016��7��29������10:04:12
 * @Fun
 **/
package model;

/**
 * @Date 2016��7��29��22:06:27
 * @Fun ��������ڵ�
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
