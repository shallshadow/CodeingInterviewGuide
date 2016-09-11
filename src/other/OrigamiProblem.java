
package other;
/**
 * @fun ������������ֽ����<br/>
 * 		����һ���������N������ֽ�������±����Ϸ���������N�Σ�����ϵ��´�ӡ�����ۺ۵ķ���<br>
 *      ����N = 1ʱ����ӡ��down;N = 2ʱ����ӡdown��down��up��
 * @author shadow 
 * @Date 2016��9��8������6:59:59
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
	 * @param i ��ӡ�Ĳ���
	 * @param n ��ӡ���ܲ���
	 * @param down �Ƿ������ۺ�
	 */
	private void printProcess(int i, int n, boolean down){
		if(i > n){			
			//
			return;
		}	
		//�ȷ���down�ڵ�
		printProcess(i+1, n, true);
		System.out.print(down ? " down " : " up ");
		//�ٷ���up�ڵ�
		printProcess(i+1, n, false);
		System.out.println();
	}
}
