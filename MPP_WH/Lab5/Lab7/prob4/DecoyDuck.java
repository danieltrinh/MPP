package prob4;

public class DecoyDuck   extends Duck implements FlyBehavior,QuackBehavior {

	@Override
	public void quack() {
		System.out.println("	cant not quack");
		
	}

	@Override
	public void display() {
		System.out.println("	displaying");
		
	}
	@Override
	public void fly() {
		System.out.println("	can not fly");
	}
	
	
	
	
	
	
	

}