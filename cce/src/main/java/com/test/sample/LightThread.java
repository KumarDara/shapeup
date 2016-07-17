package com.test.sample;

import java.util.Random;

/**
 * thread that does little work. just count & sleep
 *
 *
 */
public class LightThread implements Runnable {
	private static int cnt = 1;
        public LightThread() {
                new Thread(this, "LightThread"+cnt).start();
                cnt++;
        }

        public void run() {
                Long l = 0l;
                while(true) {
                        l++;
                        try {
                                Thread.sleep(new Random().nextInt(10));
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        if(l == Long.MAX_VALUE) {
                                l = 0l;
                        }
                }
        }
}