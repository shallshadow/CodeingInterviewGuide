
package actual.combat.lineup2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @fun �۲�����ʵ��
 * @author shadow 
 * @Date 2016��9��4������3:50:33
 * @version 1.0
 * @since 
 **/
public class LineUp implements ILineObserver {

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
	public void left(ILinePerson person) {
		// TODO Auto-generated method stub
		queue.remove(person);
	}
	
	

	/**
	 * ֪ͨ���ͻ�
	 */
	@Override
	public void notice() {
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
