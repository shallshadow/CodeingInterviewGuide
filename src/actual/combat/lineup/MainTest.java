
package actual.combat.lineup;
/**
 * @fun ���һ���Ŷ�ϵͳ���ܹ���ÿ�����������û����ܿ����Լ��ڶ�����������λ�úͱ仯,<br/>
 * 		���������ʱ���˼�����˳����������˳�Ӱ�쵽�û���λ������ʱ��Ҫ��ʱ�������û���<br/>
 * @author shadow 
 * @Date 2016��9��3������7:24:09
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
