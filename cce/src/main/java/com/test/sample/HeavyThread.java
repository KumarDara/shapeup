package com.test.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * thread that does some heavy lifting
 *
 *
 */
public class HeavyThread implements Runnable {

        private long length;

        public HeavyThread(long length) {
                this.length = length;
                new Thread(this, "HeavyThread").start();
        }

        public void run() {
                while (true) {
                        String data = "";

                        // make some shit up
                        for (int i = 0; i < length; i++) {
                                data += UUID.randomUUID().toString();
                        }

                        MessageDigest digest;
                        try {
                                digest = MessageDigest.getInstance("MD5");
                        } catch (NoSuchAlgorithmException e) {
                                throw new RuntimeException(e);
                        }

                        // hash that shit
                        digest.update(data.getBytes());
                }
        }
}