package com.mianbaopailib.system;

import com.mianbaopailib.utils.ULog;

import java.util.concurrent.*;

/**
 * Created by shidawei on 16/7/17.
 */
public class MyThreadPool {

    ScheduledExecutorService executor;

    public MyThreadPool(){
        executor = Executors.newScheduledThreadPool(10);
    }

    public MyThreadPool(int size){
        executor = Executors.newScheduledThreadPool(size);
    }

    public void stop() {
        ULog.w("关闭线程池");
        this.executor.shutdown();
    }

    public void startOnce(Runnable runnable, long delay) {
        this.executor.schedule(runnable, delay, TimeUnit.SECONDS);
    }

    public Future<?> submit(Runnable runnable) {
        return executor.submit(runnable);
    }

}
