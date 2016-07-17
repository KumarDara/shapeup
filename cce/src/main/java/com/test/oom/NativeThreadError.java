package com.test.oom;

public class NativeThreadError {
	public static void main(String[] args) {
		while(true){
		    new Thread(new Runnable(){
		        public void run() {
		            try {
		                Thread.sleep(100000);
		            } catch(InterruptedException e) { }        
		        }    
		    }).start();
		}

	}
}
