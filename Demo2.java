package com.java.multithreading;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) throws InterruptedException {
		MyList obj= new MyList();
		Thread t1= new Thread() {
			public void run() {
				for(int i=0; i<100; i++) {
					obj.add();
				}
			}
		};
	//	T1: i=21: 22th index
		Thread t2= new Thread() {
			public void run() {
				for(int i=0; i<100; i++) {
					try {
						obj.remove();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	//	Thread.sleep(1000);
		t1.start();
	
		//main thread to wait till t1 and t2 are done
		t2.join();//Main thread to wait for t2 to complete
		t1.join();//Main thread to wait for t1 to complete
		System.out.println(obj.list.size());
	}
}

class MyList {

	List<Integer> list = new ArrayList<>();

	public synchronized void add() { //Object lock: obj lock
		list.add((int) (Math.random() * 100));
		notify();//Going to bring any 1 thread in the waiting state to the runnable state
	}

	public synchronized void remove() throws InterruptedException {//Object lock
		if(list.size()<=0) {
			wait();//This thread will release the current object lock and go into the waiting state
		}
		list.remove(0);
		
	}
}