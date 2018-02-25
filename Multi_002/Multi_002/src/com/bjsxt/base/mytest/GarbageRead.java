package com.bjsxt.base.mytest;

public class GarbageRead {

	
	private int a = 1 ;
	
	private int b = 3;
	
	public synchronized void setValue(int a,int b){
		
		try {
			this.a = a;
			Thread.sleep(500);
			this.b = b;
			System.out.println("set值"+"a:"+a+",b:"+b);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private synchronized void getValue(){
		
		System.out.println("get值"+"a:"+a+",b:"+b);
	}
	
	
	public static void main(String[] args) {
		final GarbageRead garbageRead = new GarbageRead();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				garbageRead.setValue(5,10);
				
			}
		}, "t1");
		

		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				garbageRead.getValue();
				
			}
		}, "t2");
		
		t1.start();
		
		t2.start();
	}
	
}
