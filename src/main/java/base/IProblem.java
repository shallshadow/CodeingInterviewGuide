
package base;
/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月30日下午4:52:08
 * @version 1.0
 * @since 
 **/
public interface IProblem {
	//Problem solve
	boolean solve();
	
	//Problem description
	String getDesc();
	
	//return the solved result
	Object getResult();
	
	//show the solved result
	void showResult();
}
