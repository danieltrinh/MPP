package prob4;

public interface FlyBehavior {
	default void fly() {
		System.out.println("	fly with wings");
	}
}
