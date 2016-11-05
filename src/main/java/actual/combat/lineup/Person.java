
package actual.combat.lineup;

/**
 * @fun 被观察的客户类
 * @author shadow
 * @Date 2016年9月3日下午7:09:01
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
		System.out.println(name + " 当前所在位置为：" + order);
	}

}
