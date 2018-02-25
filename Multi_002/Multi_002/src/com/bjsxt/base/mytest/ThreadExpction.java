package com.bjsxt.base.mytest;

public class ThreadExpction extends Thread {

	private int i = 0;

	void putnumber() {

	}

	public void run() {
		while (i < 10) {
			try {
				i++;
				System.out.println("i:" + i);
				Thread.sleep(500);

				if (i == 5) {
					Integer.valueOf("a");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("log====" + Thread.currentThread().getName());
				continue;
			}
		}

	}

	public static void main(String[] args) {
		final ThreadExpction threadExpction = new ThreadExpction();
		threadExpction.start();

	}

}
