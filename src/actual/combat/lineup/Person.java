
package actual.combat.lineup;

/**
 * @fun ���۲�Ŀͻ���
 * @author shadow
 * @Date 2016��9��3������7:09:01
 * @version 1.0
 * @since
 **/
public class Person implements ILineObservable {

	private String name;

	public Person(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void notice(int order) {
		// TODO Auto-generated method stub
		System.out.println(name + " ��ǰ����λ��Ϊ��" + order);
	}

}
