package com.test.thread;

import java.util.concurrent.TimeUnit;

public class HighCpu {
    public static void main(String[] args) {
        new Thread(new Idle(), "Idle").start();
        new Thread(new Busy(), "Busy").start();
    }
}

class Idle implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
        }
    }
}

class Busy implements Runnable {
    @Override
    public void run() {
        while(true) {
            "Foo".matches("F.*");
        }
    }
}