package pet;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @Date 2016Äê7ÔÂ26ÈÕ20:04:54
 * 
 * @author shadow
 *
 */
public class DogCatQueue {
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;
	
	public DogCatQueue(){
		dogQ = new LinkedList<>();
		catQ = new LinkedList<>();
		this.count = 0;
	}
	
	public void add(Pet pet){
		if(pet.getType().equals("dog")){
			this.dogQ.add(new PetEnterQueue(pet, this.count++));
		}else if(pet.getType().equals("cat")){
			this.catQ.add(new PetEnterQueue(pet, this.count++));
		}else {
			throw new RuntimeException("err, not dog or cat.");
		}	
	}
	
	public Pet pollAll(){
		if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
			if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
				return this.dogQ.poll().getPet();
			}else{
				return this.catQ.poll().getPet();
			}
		}else if(!this.dogQ.isEmpty()){
			return this.dogQ.poll().getPet();
		}else if(!this.catQ.isEmpty()){
			return this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("err, queue is empty.");
		}
	}
	
	public Dog pollDog(){
		if(this.dogQ.isEmpty()){
			throw new RuntimeException("Dog queue is empty.");
		}else{
			return (Dog) this.dogQ.poll().getPet();
		}
	}
	
	public Cat pollCat(){
		if(this.catQ.isEmpty()){
			throw new RuntimeException("Cat queue is empty.");
		}else{
			return (Cat) this.dogQ.poll().getPet();
		}
	}
	
	public boolean isEmpty(){
		return this.dogQ.isEmpty() && this.dogQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty(){
		return this.dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty(){
		return this.catQ.isEmpty();
	}
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Dog dog2 = new Dog();
		DogCatQueue queue = new DogCatQueue();
		queue.add(cat);
		queue.add(dog);
		queue.add(cat);
		queue.add(dog2);
		for(int i = 0; i < queue.count; i++){
			System.err.println(queue.pollAll().getType());			
		}
		
		System.err.println(queue.pollCat());
		
	}
}
