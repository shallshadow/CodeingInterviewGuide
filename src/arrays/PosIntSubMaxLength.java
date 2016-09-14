
package arrays;

/**
 *
 * @author shadow 
 * @Date 2016��9��6������10:00:13
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
	    		//����k���³�ǰ���Ԫ��
	    		sum -= arr[left++];
	    	}else if(sum < k){
	    		right++;
	    		//����ұ�ָ���ѵ�����β��������ѭ��
	    		if(right == arr.length){
	    			break;
	    		}
	    		//����k���������Ԫ��
	    		sum += arr[right];
	    	}else{	 
	    		//����k,�µ�ǰ���Ԫ��
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
