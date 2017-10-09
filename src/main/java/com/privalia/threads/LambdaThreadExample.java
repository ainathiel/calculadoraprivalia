package com.privalia.threads;

public class LambdaThreadExample {

	public static void main(String[] args) {
		//Extends Thread Class
		MyThread thread1 = new MyThread();
		
		// Implementing Runnable using interface
		Thread thread2 = new Thread(new MyRunnable());
		
		//Implementing Runneable using anonymous class (Old way)
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread name: " + Thread.currentThread().getName());
			}
		};
		
		Thread thread3 = new Thread(runnable2);
		
		// Implementing Runnabe using Lambda expression
		Runnable runnable3 = () -> {
			System.out.println("Thread name: " + Thread.currentThread().getName());
		};
		
		Thread thread4 = new Thread(runnable3);
		
		//Start Threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

}
