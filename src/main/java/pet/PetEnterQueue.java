package pet;

/**
 * @Date 2016年7月26日20:05:16
 * @author shadow
 *
 */
public class PetEnterQueue {
	
	private Pet pet;
	private long count;
	
	public PetEnterQueue(Pet pet, long count) {
		// TODO Auto-generated constructor stub
		this.pet = pet;
		this.count = count;
	}
	
	public Pet getPet(){
		return this.pet;
	}
	
	public long getCount(){
		return this.count;
	}
	
	public String getEnterPetType(){
		return this.pet.getType();
	}
	
}
