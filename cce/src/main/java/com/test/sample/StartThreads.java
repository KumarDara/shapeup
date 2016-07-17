package com.test.sample;

public class StartThreads {

    public static void main(String[] args) {
            // lets start 1 heavy ...
            new HeavyThread(1000);
            //new HeavyThread(1000);

            // ... and 3 light threads
            new LightThread();
            new LightThread();
            new LightThread();
    }
}