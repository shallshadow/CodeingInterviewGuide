
package actual.combat.lineup2;
/**
 * @fun ���۲��߽ӿ�
 * @author shadow 
 * @Date 2016��9��4������3:48:58
 * @version 1.0
 * @since 
 **/
public interface ILinePerson {
	/**
	 * �ͻ��������
	 */
	void join();
	/**
	 * �ͻ��˳�����
	 */
	void left();
	/**
	 * ֪ͨ�ͻ�����
	 */
	void notice();
	/**
	 * 
	 * @return ��ȡ��ǰ�����λ��
	 */
	int getPosition();
}
