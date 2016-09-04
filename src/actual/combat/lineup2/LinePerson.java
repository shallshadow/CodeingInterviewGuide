
package actual.combat.lineup2;
/**
 * @fun  ���۲���ʵ��
 * @author shadow 
 * @Date 2016��9��4������3:57:29
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
		this.observer.join(this);
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		this.observer.left(this);
		this.observer.notice();
	}

	@Override
	public void notice() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " : " + this.observer.getPosition(this));
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return this.observer.getPosition(this);
	}
	
}
