
package actual.combat.lineup;
/**
 * @fun 观察者接口
 * @author shadow 
 * @Date 2016年9月3日下午6:53:01
 * @version 1.0
 * @since 
 **/
public interface ILineObserver {
	void notice();
	
	void join(ILineObservable person);
	
	void left(ILineObservable person);
}
