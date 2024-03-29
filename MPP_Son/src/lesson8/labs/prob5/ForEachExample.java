package lesson8.labs.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", "Away", "On Vacation",
				"Everywhere you want to be");
//		Consumer<String> doSomething = (String s) -> System.out.println(s.toUpperCase());
//		list.forEach(doSomething);

		// print each element of the list in upper case format
		
//		a. Use a lambda expression instead of directly defining a Consumer
		list.forEach(s->System.out.println(s.toUpperCase()));
//		b. Use a method reference in place of your lambda expression in (a)
		Consumer<String> con = (x) -> System.out.println(x.toUpperCase()); 
		list.forEach(con::accept);
	}

	// implement a Consumer

}