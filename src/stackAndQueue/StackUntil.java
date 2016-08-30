package stackAndQueue;

import java.util.Stack;
/**
 * @Date 2016��7��27��19:57:52
 * @fun ջͨ����
 * @author shadow
 *
 */
public class StackUntil {
	
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.empty()) {
			return result;
		} else {
			System.err.println("LAST: " + result);
			int last = getAndRemoveLastElement(stack);
			
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}

		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<>();
		while(!stack.isEmpty()){
			int cur = stack.pop();
			while(!help.isEmpty() && help.peek() < cur){
				stack.push(help.pop());
			}
			
			help.push(cur);
		}
		
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		int[] testData = { 5, -2, 3, 4, 6, 7, 8, 12, 11 };
		Stack<Integer> minStack = new Stack<Integer>();
		for (int i = 0; i < testData.length; i++) {
			minStack.push(testData[i]);
		}
		sortStackByStack(minStack);
//		reverse(minStack);
		for(int i = 0; i < testData.length; i++){
			System.err.println(minStack.pop());
		}
		//
		// for(int i = 0; i < testData.length; i++){
		// System.out.println(minStack.pop());
		// }
		// ��ӡ��Сֵ
//		System.err.println("Remove: " + getAndRemoveLastElement(minStack));
//		System.err.println("Remove: " + getAndRemoveLastElement(minStack));
	}
}
