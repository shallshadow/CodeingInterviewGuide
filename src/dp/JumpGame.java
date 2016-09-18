
package dp;
/**
 * @fun ������������������arr��arr[i]==k������Դ�λ��i������1~k�����롣�����λ��0��������������������������arr����λ���ϡ�
 * @author shadow 
 * @Date 2016��9��17������8:01:39
 * @version 1.0
 * @since 
 **/
public class JumpGame {
	
	public static void main(String[] args) {
		int[] arr = {3,2,3,1,1,4,5,6,1,1,2,1};
		System.out.println("Jump " + new JumpGame().jump(arr));
	}
	/**
	 * ����˼�����ʹ��Ծ��Χ���
	 * @param arr
	 * @return
	 */
	public int jump(int[] arr){
		if(arr == null || arr.length == 0){
			return 0;
		}
		
		int jump = 0;
		int cur = 0;
		int next = 0;
		for(int i = 0; i < arr.length; i++){
			if(cur < i){
				jump++;
				cur = next;
			}
			next = Math.max(next, i + arr[i]);
		}
		
		return jump;
	}
}
