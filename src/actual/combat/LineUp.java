
package actual.combat;

import java.util.*;

/**
 * @fun 管理队列的观察者类实现
 * @author shadow
 * @Date 2016年9月3日下午6:52:47
 * @version 1.0
 * @since7 
 **/
public class LineUp implements ILineObserver {

	private List<ILineObservable> personList;
	private int curLeftIndex = -1;

	public LineUp() {
		// TODO Auto-generated constructor stub
		personList = new LinkedList<>();

	}

	@Override
	public void join(ILineObservable person) {
		personList.add(person);
	}
	@Override
	public void left(ILineObservable person) {
		curLeftIndex = personList.indexOf(person);
		personList.remove(person);
		notice();
	}

	public int getOrder(ILineObservable person) {
		return personList.indexOf(person) + 1;
	}

	@Override
	public void notice() {
		// TODO Auto-generated method stub
		Iterator<ILineObservable> iterator = personList.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			ILineObservable person = iterator.next();
			if (i > curLeftIndex) {
				person.notice(i);
			}
			i++;
		}
	}

}
