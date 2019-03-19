package com.java.multithreading;

public class Demo4 {
public static void main(String[] args) {
	Temp obj1= new Temp();
	Thread t1= new Thread(()-> obj1.m1());
	Thread t2= new Thread(()-> obj1.m1());
	t1.start();
	t2.start();

}
}

class Temp{
	int x;
	
	synchronized void m1() {//thread should acquire the current object lock
		x++; //T1 : x= x+1  [x+1 : 1] :time up 
		System.out.println(x);
	}
}