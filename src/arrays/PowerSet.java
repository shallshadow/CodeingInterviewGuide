
package arrays;
/**
 * @fun 求数组的所有子集
 * @author shadow 
 * @Date 2016年9月18日下午2:52:53
 * @version 1.0
 * @since 
 **/
public class PowerSet {
	public static void main(String[] args) {
		int arr[] = {1,2,3,5};
		new PowerSet().getPowerSet(arr);
	}
	
	public void getPowerSet(int[] arr){
		int len = arr.length;
		int total = 1 << len;
		System.out.println("total : " + total);
		for(int i = 0; i < total; i++){
			for(int j = 0; j < len; j++){
				//Printing all elements for which there is a bit one in i
				if((i & (1 << j)) != 0){
					System.out.print("| i : " + i + " arr :" + arr[j]);
				}
			}
			System.out.print("\n");
		}
	}
}
