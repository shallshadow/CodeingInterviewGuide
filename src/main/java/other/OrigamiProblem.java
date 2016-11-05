
package other;
/**
 * @fun 问题描述：折纸问题<br/>
 * 		给定一个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。<br>
 *      例：N = 1时，打印：down;N = 2时，打印down，down，up。
 * @author shadow 
 * @Date 2016年9月8日下午6:59:59
 * @version 1.0
 * @since 
 **/
public class OrigamiProblem {
	
	public static void main(String[] args) {
		OrigamiProblem problem = new OrigamiProblem();
		problem.printAllFolds(5);
	}
	
	public void printAllFolds(int n){		
		printProcess(1, n, true);
		
	}
	
	/**
	 * 
	 * @param i 打印的层数
	 * @param n 打印的总层数
	 * @param down 是否是下折痕
	 */
	private void printProcess(int i, int n, boolean down){
		if(i > n){			
			//
			return;
		}	
		//先访问down节点
		printProcess(i+1, n, true);
		System.out.print(down ? " down " : " up ");
		//再访问up节点
		printProcess(i+1, n, false);
		System.out.println();
	}
}
