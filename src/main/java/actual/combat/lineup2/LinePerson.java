
package actual.combat.lineup2;
/**
 * @fun  被观察者实现
 * @author shadow 
 * @Date 2016年9月4日下午3:57:29
 * @version 1.0
 * @since 
 **/
public class LinePerson implements ILinePerson {
	
	private String name;
	private ILineObserver observer;
	
	public LinePerson(String name, ILineObserver observer) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.observer = observer;
	}
	
	@Override
	public void join() {
		// TODO Auto-generated method stub
		observer.join(this);
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		observer.leave(this);
		observer.notifyAllPerson();
	}

	@Override
	public void notice() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " : " + this.observer.getPosition(this));
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return observer.getPosition(this);
	}
	
}
