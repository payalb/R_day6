package com.java.multithreading;

public class Demo3 {
	public static void main(String[] args) {
		A obj= new A();
		Runnable r= ()-> obj.m1();
		Thread t1= new Thread(r);
		t1.start();
		Runnable r2= ()-> obj.m2();
		Thread t2= new Thread(r2);
		t2.start();
		
	}
}
//T1: 
class A {
	void m1() {// 1-> 10
		int x = 1;
		while (x <= 10) { //T1 is at this line : x=1 : scheduler says time up
			System.out.println(x++);
		}
	}

	 void m2() {// 11-> 20
		int x = 11;
		while (x <= 20) {
			System.out.println(x++);//11 x=x+1: time up
		}
	}
}