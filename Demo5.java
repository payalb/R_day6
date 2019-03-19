package com.java.multithreading;

public class Demo5 {

	public static void main(String[] args) {
		MyDemo obj1 = new MyDemo();
		Thread t1 = new Thread(() -> obj1.m1());
		t1.start();
		Thread t2 = new Thread(() -> MyDemo.m2());
		t2.start();
	}
}
//Both can run in parallel

class MyDemo {
	synchronized void m1() {// lock on obj1
		for (int i = 0; i < 100; i++)
			System.out.println(i);
	}

	static synchronized void m2() { // class lock
		for (int i = 101; i < 200; i++)
			System.out.println(i);
	}
}