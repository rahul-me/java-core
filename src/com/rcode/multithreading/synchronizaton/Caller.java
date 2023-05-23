package com.rcode.multithreading.synchronizaton;

public class Caller implements Runnable {
	
	String msg;
	Callme target;
	Thread t;
	
	Caller(Callme target, String msg) {
		this.target = target;
		this.msg = msg;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
//		target.call(msg); // call un-synchronized method
		target.callSynchronized(msg);  // call synchronized
	}
}
