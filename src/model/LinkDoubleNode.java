/**
 * @author shadow
 * @Date 2016年7月30日下午8:46:49
 * @Fun 双链表结构
 **/
package model;


public class LinkDoubleNode extends LinkNode {

	public LinkDoubleNode(Integer data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	
	public void setLast(LinkDoubleNode last){
		this.last = last;
	}
	
	public void Search(){
		LinkDoubleNode head = this;
		LinkDoubleNode tail = head;
		do{		
			System.out.println("LinkDoubleNode : " + head.getValue());
			head =  (LinkDoubleNode) head.getNext();
			
		}while(head != tail);
	}
	
	public LinkDoubleNode getLast(){
		return this.last;
	}
	
	private LinkDoubleNode last;
}
