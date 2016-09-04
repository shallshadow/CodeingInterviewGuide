
package actual.combat.lineup;
/**
 * @fun 设计一个排队系统，能够让每个进入队伍的用户都能看到自己在队列中所处的位置和变化,<br/>
 * 		队伍可能随时有人加入和退出；当有人退出影响到用户的位置排名时需要及时反馈到用户。<br/>
 * @author shadow 
 * @Date 2016年9月3日下午7:24:09
 * @version 1.0
 * @since 
 **/
public class MainTest {
	public static void main(String[] args) {
		LineUp lineUp = new LineUp();
		Person[] persons = new Person[20];
		for(int i = 0; i < 20; i++){
			persons[i] = new Person("Person : " + (i + 1));
			lineUp.join(persons[i]);
		}
		
		System.out.println("Person 5 Left : ");
		lineUp.left(persons[5]);
		System.out.println();
		
		System.out.println("Person 9 Left : ");
		lineUp.left(persons[9]);
		
		System.out.println("Person 3 Left : ");
		lineUp.left(persons[3]);
		
		System.out.println("Person 4 index : " + lineUp.getOrder(persons[4]));
	}
}
