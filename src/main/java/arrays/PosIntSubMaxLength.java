
package arrays;

/**
 *
 * @author shadow 
 * @Date 2016年9月6日下午10:00:13
 * @version 1.0
 * @since 
 **/
public class PosIntSubMaxLength extends ArrayProblem {

	private int length;
	private int k;
	
	public PosIntSubMaxLength(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}
	
	public PosIntSubMaxLength(int[] datas, int k) {
		super(datas);
		// TODO Auto-generated constructor stub
		this.k = k;
	}
	
	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if(!super.solve()){
			return false;
		}
		length = getMaxLength(datas, k);
		return true;
	}
	
	private int getMaxLength(int[] arr, int k){
		int left = 0;
		int right = 0;
		int sum = arr[0];
	    int len = 0;
	    while(right < arr.length){
	    	if(sum == k){
	    		len = Math.max(len, right - left + 1);
	    		if(left == arr.length){
	    			break;
	    		}
	    		//满足k后吐出前面的元素
	    		sum -= arr[left++];
	    	}else if(sum < k){
	    		right++;
	    		//如果右边指针已到数组尾部，跳出循环
	    		if(right == arr.length){
	    			break;
	    		}
	    		//少于k，继续添加元素
	    		sum += arr[right];
	    	}else{	 
	    		//大于k,吐掉前面的元素
	    		sum -= arr[left++];
	    	}
	    }
	    
	    return len;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + "Positive Integer Arrays Get Max Subarray That Summary is K";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + " Result : " + length);
	}

}
