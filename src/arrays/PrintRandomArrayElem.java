
package arrays;

/**
 *
 * @author shadow 
 * @Date 2016年9月7日下午3:29:47
 * @version 1.0
 * @since 
 **/
public class PrintRandomArrayElem extends ArrayProblem {

	private int m;
	
	public PrintRandomArrayElem(int[] datas) {
		super(datas);
		// TODO Auto-generated constructor stub
	}
	
	public PrintRandomArrayElem(int[] datas, int m) {
		super(datas);
		// TODO Auto-generated constructor stub
		this.m = m;
	}
	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		if(!super.solve()){
			return false;
		}
		printRandom(datas, m);
		return true;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + " Print random array element by equal chance ";
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		System.out.println(getDesc() + "\nResult : the m is " + this.m + ", the Result is above");
	}
	
	private void printRandom(int[] datas, int m){
		m = Math.min(datas.length, m);
		
		int count = 0;
		int temp = 0;
		while(count < m){
			int randIndex = (int) (Math.random() * (datas.length - count));
			System.out.println("Data : " + datas[randIndex]);
			count++;
			temp = datas[randIndex];			
			datas[randIndex] = datas[datas.length - count];
			datas[datas.length - count] = temp;			
		}
	}
	
	public static void main(String[] args) {
		int[] datas = {1,5,6,8,9,2,10};
		int m = 6;
		PrintRandomArrayElem arrayElem = new PrintRandomArrayElem(datas, m);
		arrayElem.solve();
		arrayElem.showResult();
	}

}
