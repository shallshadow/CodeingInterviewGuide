package stackAndQueue;

import java.util.Stack;
/**
 * Fun:设计一个有getMin功能的栈
 * Date:2016年7月26日18:56:07
 * @author shadow
 *
 */
public class MinStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MinStack(){
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}
	
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum <= this.getMin()){
			this.stackMin.push(newNum);
		}
		
		this.stackData.add(newNum);
	}
	
	public int pop(){		
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty.");
		}
		
		int value = this.stackData.pop();
		if(value == this.getMin()){
			this.stackMin.pop();
		}		
		
		return value;		
	}
	
	public int getMin(){		
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty.");
		}
		
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		int[] testData = {5,2,3,4,6,7,8,12,11};
		MinStack minStack = new MinStack();
		for(int i = 0; i < testData.length; i++){
			minStack.push(testData[i]);
		}
//		
//		for(int i = 0; i < testData.length; i++){
//			System.out.println(minStack.pop());
//		}
		//打印最小值
		System.err.println(minStack.getMin());
	}
}
