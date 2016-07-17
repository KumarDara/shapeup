package com.test.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadLock {
	
	public static Object Lock1 = new Object();
	   public static Object Lock2 = new Object();
	   
	   public static void main(String args[]) {
	   
	      ThreadDemo1 T1 = new ThreadDemo1();
	      ThreadDemo2 T2 = new ThreadDemo2();
	      T1.start();
	      T2.start();
	      try { Thread.sleep(100); }
          catch (InterruptedException e) {}
	      //detectDeadlock();
	   }
	   
	   private static class ThreadDemo1 extends Thread {
	      public void run() {
	         synchronized (Lock1) {
	            System.out.println("Thread 1: Holding lock 1...");
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 1: Waiting for lock 2...");
	            synchronized (Lock2) {
	               System.out.println("Thread 1: Holding lock 1 & 2...");
	            }
	         }
	      }
	   }
	   private static class ThreadDemo2 extends Thread {
	      public void run() {
	         synchronized (Lock2) {
	            System.out.println("Thread 2: Holding lock 2...");
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 2: Waiting for lock 1...");
	            synchronized (Lock1) {
	               System.out.println("Thread 2: Holding lock 1 & 2...");
	            }
	         }
	      }
	   }
	   
	   private static void detectDeadlock() {
		    ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		    long[] threadIds = threadBean.findDeadlockedThreads();
		    int deadlockedThreads = threadIds != null? threadIds.length : 0;
		    System.out.println("Number of deadlocked threads: " + deadlockedThreads);
		    for(long id : threadIds) {
		    	System.out.println("ThreadInfo::"+threadBean.getThreadInfo(id));
		    }
		}

}
