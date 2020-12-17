package com.education.timetable.utils;

import lombok.NonNull;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTaskExecutorUtils {

  public static void run(
      @NonNull Runnable runnable, ThreadPoolTaskExecutor threadPoolTaskExecutor) {
    threadPoolTaskExecutor.execute(runnable);
  }

  public static ThreadPoolTaskExecutor createThreadPool(@NonNull Integer num) {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.initialize();
    // 核心线程数 线程池维护线程的最少数量
    threadPoolTaskExecutor.setCorePoolSize(num);
    // 线程池维护线程所允许的空闲时间
    threadPoolTaskExecutor.setKeepAliveSeconds(2000);
    // 线程池维护线程的最大数量
    threadPoolTaskExecutor.setMaxPoolSize(300);
    // 线程池所使用的缓冲队列
    threadPoolTaskExecutor.setQueueCapacity(200000);

    threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
    return threadPoolTaskExecutor;
  }

  public static ThreadPoolTaskExecutor createThreadPool(@NonNull Integer num, Integer maxNum) {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.initialize();
    // 核心线程数 线程池维护线程的最少数量
    threadPoolTaskExecutor.setCorePoolSize(num);
    // 线程池维护线程所允许的空闲时间
    threadPoolTaskExecutor.setKeepAliveSeconds(200);
    // 线程池维护线程的最大数量
    threadPoolTaskExecutor.setMaxPoolSize(maxNum);
    // 线程池所使用的缓冲队列
    threadPoolTaskExecutor.setQueueCapacity(20000);
    return threadPoolTaskExecutor;
  }

  public static void getActiveCountPeriodically(
      ThreadPoolTaskExecutor threadPoolTaskExecutor, Integer period) {
    while (threadPoolTaskExecutor.getActiveCount() > 0) {
      Runnable helloRunnable =
          () -> System.out.println("线程池存活数量: " + threadPoolTaskExecutor.getActiveCount());

      ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
      executor.scheduleAtFixedRate(helloRunnable, 0, period, TimeUnit.SECONDS);
    }
  }
}
