package lesson10.labs.prob6;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class Queue {
	class Node {
		Object value;
		Node next;

	}
	private Node head;
	private Node tail;

	public void add(Object newValue) {
		Node n = new Node();
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		tail.value = newValue;
	}

	synchronized public void addThreadSafe(Object newValue) {
		Node n = new Node();
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		tail.value = newValue;
	}

	public Object remove() {
		if (head == null)
			return null;
		Node n = head;
		head = n.next;
		return n.value;
	}

	synchronized public Object removeThreadSafe() {
		if (head == null)
			return null;
		Node n = head;
		head = n.next;
		return n.value;
	}

	public int getSize() {
		int i = 0;
		Node temp = head;
		while (temp.next != null) {
			i++;
			temp = temp.next;
		}
		return i;
	}

	public static void multipleThreadNotSafe(Queue q) {

		Runnable r = () -> {
			for (int i = 0; i <= 100; i++)
				q.add(i);
		};

		for (int i = 0; i <= 100; i++)
			new Thread(r).start();
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {}
	}
	
	public static void multipleThreadSafe(Queue q) {

		Runnable r = () -> {
			for (int i = 0; i < 100; i++)
				q.addThreadSafe(i);
		};

		for (int i = 0; i < 100; i++)
			new Thread(r).start();
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {}
	}

	public static void main(String[] args) {
		System.out.println("Not Thread Safe");
		Queue q1 = new Queue();
		multipleThreadNotSafe(q1);
		System.out.println(q1.getSize());

		// -> the number of element is different every time we run multithread add
		// -> the number of adds may be fewer or more than 
		// we expected when using multithread
		// to add new nodes to queue
		
		//THREAD SAFE
		System.out.println("Thread Safe");
		Queue q2 = new Queue();
		multipleThreadSafe(q2);
		System.out.println(q2.getSize());
	}
}
