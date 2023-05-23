package com.rcode.multithreading.synchronizaton;

public class Callme {
	void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
	
	synchronized void callSynchronized(String msg) {
		call(msg);
	}
}
