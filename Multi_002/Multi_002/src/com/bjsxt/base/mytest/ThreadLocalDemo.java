package com.bjsxt.base.mytest;
public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "hello";
        }
    };
    static class MyRunnable implements Runnable{
        private int num;
        public MyRunnable(int num){
            this.num = num;
        }
        @Override
        public void run() {
            threadLocal.set(String.valueOf(num));
            System.out.println("threadLocalValue:"+threadLocal.get());
        }
    }

    public static void main(String[] args){
//    	MyRunnable myRunnable = ;
    	Thread t1 = new Thread(new MyRunnable(1));
    	t1.start();
    	Thread t2 = new Thread(new MyRunnable(2));
    	t2.start();
    	Thread t3 =  new Thread(new MyRunnable(3));
    	t3.start();
    }
}