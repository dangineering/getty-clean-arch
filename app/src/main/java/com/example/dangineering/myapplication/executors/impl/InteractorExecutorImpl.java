package com.example.dangineering.myapplication.executors.impl;

import android.support.annotation.NonNull;

import com.example.dangineering.myapplication.domain.interactor.Interactor;
import com.example.dangineering.myapplication.executors.InteractorExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InteractorExecutorImpl implements InteractorExecutor {

    /* system constants */
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORKER_QUEUE = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor threadPoolExecutor;


    public InteractorExecutorImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORKER_QUEUE);
    }

    @Override
    public void run(@NonNull Interactor interactor) {
        threadPoolExecutor.submit(interactor);
    }
}
