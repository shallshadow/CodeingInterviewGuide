
package actual.combat.lineup2;
/**
 * @fun �۲��߽ӿ�
 * @author shadow 
 * @Date 2016��9��4������3:46:47
 * @version 1.0
 * @since 
 **/
public interface ILineObserver {
	/**
	 * ����������
	 * @param person �۲����
	 */
	void join(ILinePerson person);
	
	/**
	 * �뿪����
	 * @param person �۲����
	 */
	void left(ILinePerson person);
	/**
	 * 
	 * @param person �۲����
	 * @return ��ȡ�۲����ǰλ��
	 */
	int getPosition(ILinePerson person);
	
	/**
	 * ֪ͨ�۲����
	 * **/
	void notice();
}
