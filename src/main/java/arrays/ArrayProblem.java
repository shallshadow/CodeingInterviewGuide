
package arrays;

import base.Problem;

/**
 * @fun 数组问题解决基类
 * @author shadow 
 * @Date 2016年8月31日上午11:33:31
 * @version 1.0
 * @since 
 **/
public class ArrayProblem extends Problem {
	protected int[] datas;
	public ArrayProblem(int[] datas) {
		// TODO Auto-generated constructor stub
		this.datas = datas;
	}
	
	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		//super.solve();
		return isVaild(datas);
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + ".ArrayProblem";
	}
	
	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return datas;
	}
	
	@Override
	public void showResult() {
		// TODO Auto-generated method stub
		if(!isVaild(datas)){
			System.out.println(getDesc() + " Error.");
		}
		
		System.out.println(getDesc() + " Result : ");
		for(int i = 0; i < datas.length; i++){
			System.out.print(" " + datas[i]);
		}
	}
	
	private boolean isVaild(int[] datas){
		if(datas == null || datas.length == 0){
			return false;
		}
		
		return true;
	}
}
