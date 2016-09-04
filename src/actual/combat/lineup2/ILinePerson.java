
package actual.combat.lineup2;
/**
 * @fun 被观察者接口
 * @author shadow 
 * @Date 2016年9月4日下午3:48:58
 * @version 1.0
 * @since 
 **/
public interface ILinePerson {
	/**
	 * 客户进入队列
	 */
	void join();
	/**
	 * 客户退出队列
	 */
	void left();
	/**
	 * 通知客户操作
	 */
	void notice();
	/**
	 * 
	 * @return 获取当前对象的位置
	 */
	int getPosition();
}
