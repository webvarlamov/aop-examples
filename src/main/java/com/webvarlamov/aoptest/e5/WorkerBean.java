package com.webvarlamov.aoptest.e5;

public class WorkerBean {
    public void doSomeWork(int noOfTimes) throws InterruptedException {
        for (int i = 0; i < noOfTimes; i++) {
            Thread.sleep(10);
        }
    }
}
