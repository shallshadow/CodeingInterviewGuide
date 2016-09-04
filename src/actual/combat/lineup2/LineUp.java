
package actual.combat.lineup2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @fun 观察者类实现
 * @author shadow 
 * @Date 2016年9月4日下午3:50:33
 * @version 1.0
 * @since 
 **/
public class LineUp implements ILineObserver {

	//队列
	private Queue<ILinePerson> queue;
	
	public LineUp() {
		// TODO Auto-generated constructor stub
		queue = new LinkedList<>();
	}
	
	@Override
	public void join(ILinePerson person) {
		// TODO Auto-generated method stub
		queue.add(person);
	}

	@Override
	public void leave(ILinePerson person) {
		// TODO Auto-generated method stub
		queue.remove(person);
	}
	
	

	/**
	 * 通知各客户
	 */
	@Override
	public void notifyAllPerson() {
		// TODO Auto-generated method stub
		Iterator<ILinePerson> iterator = queue.iterator();
		while(iterator.hasNext()){
			ILinePerson person = iterator.next();
			person.notice();
		}
	}


	@Override
	public int getPosition(ILinePerson person) {
		// TODO Auto-generated method stub
		int index = -1;
		Iterator<ILinePerson> iterator = queue.iterator();
		while(iterator.hasNext()){
			index++;
			if(person == iterator.next()){
				return index;
			}
		}		
		return index;
	}

}
