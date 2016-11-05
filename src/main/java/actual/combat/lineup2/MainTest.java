
package actual.combat.lineup2;
/**
 * @fun 观察者模式实践
 * @author shadow 
 * @Date 2016年9月4日下午4:04:32
 * @version 1.0
 * @since 
 **/
public class MainTest {
	public static void main(String[] args) {
		//观察者类
		ILineObserver observer = new LineUp();
		//客户
		ILinePerson[] persons = new LinePerson[20];
		
		//入队
		for(int i = 0; i < 20; i++){
			persons[i] = new LinePerson("Person " + i, observer);
			persons[i].join();
		}		
		
		System.out.println("Person 5 left : ");
		persons[5].leave();
		System.out.println();
		
		System.out.println("Person 11 left :");
		persons[11].leave();
		System.out.println();
	}
}
