
package actual.combat.lineup;
/**
 * @fun �۲��߽ӿ�
 * @author shadow 
 * @Date 2016��9��3������6:53:01
 * @version 1.0
 * @since 
 **/
public interface ILineObserver {
	void notice();
	
	void join(ILineObservable person);
	
	void left(ILineObservable person);
}
