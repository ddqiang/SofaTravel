package com.example.dllo.sofatravel.main.main.tools.threadpool;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dllo on 16/8/1.
 */
public class SingleThreadPool {

    private static SingleThreadPool mSingleThreadPool = new SingleThreadPool();
    private ThreadPoolExecutor mThreadPoolExecutor;

    public static SingleThreadPool getmSingleThreadPool() {
        if (mSingleThreadPool == null) {
            synchronized (SingleThreadPool.class) {
                if (mSingleThreadPool == null) {
                    mSingleThreadPool = new SingleThreadPool();
                }
            }
        }
        return mSingleThreadPool;
    }

    private SingleThreadPool() {
        int CPUCores = Runtime.getRuntime().availableProcessors();
        mThreadPoolExecutor = new ThreadPoolExecutor(CPUCores, CPUCores * 2 + 1, 60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
    }

    //开启一个任务
    public void excute(Runnable task) {
        mThreadPoolExecutor.execute(task);
    }

    //移除一个任务
    public boolean remove(Runnable task) {
        boolean move = mThreadPoolExecutor.remove(task);
        return move;
    }
}
