package stackAndQueue;

import java.util.Stack;

/**
 * Fun:创建一个栈来获取最小值
 * Date:2016年7月26日19:22:32
 * @author shadow
 *
 */
public class MinStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	
	public MinStack2(){
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}
	
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum < this.getMin()){
			this.stackMin.push(newNum);
		}else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		
		this.stackData.push(newNum);
	}
	
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty.");
		}
		
		this.stackMin.pop();
		return this.stackData.pop();
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		int[] testData = {5,-2,3,4,6,7,8,12,11};
		MinStack2 minStack = new MinStack2();
		for(int i = 0; i < testData.length; i++){
			minStack.push(testData[i]);
		}
//		
//		for(int i = 0; i < testData.length; i++){
//			System.out.println(minStack.pop());
//		}
		//打印最小值
		System.err.println("MinStack2: "+minStack.getMin());
	}
}
