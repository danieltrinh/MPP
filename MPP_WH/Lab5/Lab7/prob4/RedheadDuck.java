package prob4;


public class RedheadDuck   extends Duck implements FlyBehavior,QuackBehavior {

	@Override
	public void quack() {
		System.out.println("	quacking");
		
	}

	@Override
	public void display() {
		
			System.out.println("	displaying");
		
		
	}
	
	

	
	

}