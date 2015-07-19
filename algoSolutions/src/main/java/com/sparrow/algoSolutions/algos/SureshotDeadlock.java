package com.sparrow.algoSolutions.algos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SureshotDeadlock 
{
    Lock lockA = new ReentrantLock();
    Lock lockB = new ReentrantLock();
    volatile private int n = 0;

    private Thread thA = new Thread("A") {
        @Override
        public void run() {
            try {
                lockA.lock();
                n = 1;
                while (n != 2) {
                    sleep(50);
                }
                System.out.println("A requesting for lockB");
                lockB.lock();
            } catch(InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " interuppted");
            }finally {
                lockB.unlock();
                lockA.unlock();
            }
        }
    };

    private Thread thB = new Thread("B") {
        @Override
        public void run() {
            try {
                while (n != 1) {
                    sleep(10);
                }

                lockB.lock();
                n = 2;
                System.out.println("B requesting for lockA");
                lockA.lock();
            } catch(InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " interuppted");
            }finally {
                lockB.unlock();
                lockA.unlock();
            }
        }
    };

    private void createDeadlock()
    {
        thA.start();
        thB.start();
    }

    public static void main(String[] args) {
        new SureshotDeadlock().createDeadlock();
    }
}
