package com.bjsxt.base.mytest;


public class ThreadTestOne extends Thread{

	public  int k = 10;
	
	public synchronized   void addk (){
		System.out.println("当前线程"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized void  lockk (){
		System.out.println("当前线程"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		
		final ThreadTestOne threadTestOne = new ThreadTestOne();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadTestOne.addk();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadTestOne.lockk();
				
			}
		},"t2");
		
		
		t1.start();
		t2.start();
	}
}
