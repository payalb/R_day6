package com.java.multithreading;

import java.util.stream.Stream;

public class Demo1 {
public static void main(String[] args) {
	System.out.println(Thread.currentThread().getName());
	
	Thread t1= new Thread() {
		@Override
		public void run() {
			Stream.iterate(2, x-> x+2).limit(10).forEach(x-> System.out.println(x));
		}
		
	};
	Thread t2= new Thread() {
		@Override
		public void run() {
			Stream.iterate(3, x-> x+3).limit(10).forEach(x-> System.out.println(x));
		}
		
	};
	
	t1.start();//runnable
	t2.start();//runnable
	//Scheduler will decide: once it is running: it will call run method
	
	//Thread has it's own lifecycle
	//Thread completes run method: dead: cannot call any method on a dead thread
	
}
}

/*//Thread class
class MyThread extends Thread{
	@Override
	public void run() {
		
	}
}*/