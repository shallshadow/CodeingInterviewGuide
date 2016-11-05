
package actual.combat.lineup2;
/**
 * @fun 观察者接口
 * @author shadow 
 * @Date 2016年9月4日下午3:46:47
 * @version 1.0
 * @since 
 **/
public interface ILineObserver {
	/**
	 * 加入队伍操作
	 * @param person 观察对象
	 */
	void join(ILinePerson person);
	
	/**
	 * 离开队伍
	 * @param person 观察对象
	 */
	void leave(ILinePerson person);
	/**
	 * 
	 * @param person 观察对象
	 * @return 获取观察对象当前位置
	 */
	int getPosition(ILinePerson person);
	
	/**
	 * 通知所有的观察对象
	 * **/
	void notifyAllPerson();
}
