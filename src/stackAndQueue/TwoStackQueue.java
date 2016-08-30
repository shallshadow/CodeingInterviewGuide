package stackAndQueue;

import java.util.Stack;

/**
 * Fun:ʹ������ջ����һ������
 * Date:2016��7��26��19:25:19
 * @author shadow
 *
 */
public class TwoStackQueue {
	
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public TwoStackQueue(){
		this.stackPop = new Stack<>();
		this.stackPush = new Stack<>();
	}
	
	public void add(int newNum){
		stackPush.push(newNum);
	}
	
	public int poll(){
		if(this.stackPop.empty() && this.stackPush.empty()){
			throw new RuntimeException("Your stack is empty.");
		}else if(this.stackPop.empty()){
			reverse();
		}
		return this.stackPop.pop();
	}
	
	public int peek(){
		if(this.stackPop.empty() && this.stackPush.empty()){
			throw new RuntimeException("Your stack is empty.");
		}else if(this.stackPop.empty()){
			reverse();
		}
		
		return this.stackPop.peek();		
	}
	
	private void reverse(){		
		while(!this.stackPush.empty()){
			this.stackPop.push(this.stackPush.pop());
		}
	}
	
	public static void main(String[] args) {
		int[] testData = {5,-2,3,4,6,7,8,12,11};
		TwoStackQueue minStack = new TwoStackQueue();
		for(int i = 0; i < testData.length; i++){
			minStack.add(testData[i]);
		}
		
		for(int i = 0; i < testData.length; i++){
			System.out.print(minStack.poll() + "��");
		}
	
		
	}
}
