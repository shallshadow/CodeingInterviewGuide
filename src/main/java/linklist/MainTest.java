/**
 * @author shadow
 * @Date 2016年7月30日下午8:27:34
 * @Fun
 **/
package linklist;

import friendly.Student;
import model.LinkDoubleNode;
import model.LinkNode;

public class MainTest {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6};
		int[] arr2 = {3,4,5,6,7,8,9};
		LinkNode result = null;
		LinkNode head = LinkList.Create(arr1);
//		LinkNode head2 = LinkList.Create(arr2);
//		LinkUntil.printCommonPart(head1, head2);
//		
//		LinkNode head = LinkUntil.removeLastKthNode(head1, 10);
//		head.Search();
		
//		LinkDoubleNode head = LinkList.CreateDoubleLinkList(arr1);
		//head.Search();
		//head.Search();
		//LinkDoubleNode result = LinkUntil.removeLastKthNode(head, 3);
		//result = LinkUntil.removeMidNode(head);
		//result = LinkUntil.removeByRatio(head, 2, 5);
		//result = LinkUntil.reverseList(head);
		result = LinkUntil.reversePart(head, 2, 5);
		System.err.println("Reverse:\n");
		result.Search();
		
		Teacher teacher = new Teacher();
		teacher.getAge();
		
	}
}
