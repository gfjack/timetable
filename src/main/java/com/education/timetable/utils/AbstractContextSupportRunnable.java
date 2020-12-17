package com.education.timetable.utils;

import com.netflix.hystrix.strategy.HystrixPlugins;

import java.util.concurrent.Callable;

/** 异步上下文设置 */
public abstract class AbstractContextSupportRunnable implements Runnable {
  private final Callable delegatingCallable;

  public AbstractContextSupportRunnable() {
    delegatingCallable =
        HystrixPlugins.getInstance()
            .getConcurrencyStrategy()
            .wrapCallable(
                (Callable)
                    () -> {
                      AbstractContextSupportRunnable.this.execute();
                      return null;
                    });
  }

  @Override
  public final void run() {
    try {
      delegatingCallable.call();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 具体要执行的代码放在该方法内，
   *
   * @return
   */
  protected abstract void execute();
}
