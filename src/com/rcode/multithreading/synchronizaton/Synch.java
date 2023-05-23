package com.rcode.multithreading.synchronizaton;

/**
 * @author Rahul Chauhan
 * 
 * As you can see, by calling sleep(), the call() method allows execution to switch to another thread.
 * This results in the mixed up output of the three message strings. In this program, nothing exists to stop
 * all three threads from calling the same method, on the same object, at the same time.
 * This is known as race condition.
 * 
Output:

[World[Synchronized[Hello]
]
]
 *
 *
 * Remember: once a thread enters any synchronized method on an instance, no other thread can enters
 * any synchronized method on the same instance. However non-synchronized methods on that instance will
 * continue to be callable.
 */
public class Synch {
	public static void main(String[] args) {
		Callme target = new Callme();
		
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronized");
		Caller ob3 = new Caller(target, "World");
		
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread finished");
		
	}
}
