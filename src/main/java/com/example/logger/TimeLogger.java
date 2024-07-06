package com.example.logger;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TimeLogger {
    private static final int CALLER_INDEX = 2;

    public <T> T executeTaskAndLog(Supplier<T> task) {
        long startTime = System.currentTimeMillis();
        T result = task.get();
        long endTime = System.currentTimeMillis();

        long duration = startTime - endTime;

        String targetClassName = Thread.currentThread().getStackTrace()[CALLER_INDEX].getClassName();
        String targetMethodName = Thread.currentThread().getStackTrace()[CALLER_INDEX].getMethodName();

        log.info(targetClassName + "." + targetMethodName + " 의 실행 시간 : " + duration + "ms");
        return result;
    }

    public void executeTaskAndLog(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();

        long duration = startTime - endTime;

        String targetClassName = Thread.currentThread().getStackTrace()[CALLER_INDEX].getClassName();
        String targetMethodName = Thread.currentThread().getStackTrace()[CALLER_INDEX].getMethodName();

        log.info(targetClassName + "." + targetMethodName + " 의 실행 시간 : " + duration + "ms");
    }

}
