package com.education.timetable.processor;

import com.education.timetable.utils.SpringContextUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/** 异步任务处理器模板 */
@Slf4j
@AllArgsConstructor
public class DefaultAsyncProcessor implements Runnable {

  @SneakyThrows
  protected void execute() {
    Thread.sleep(2000);
    System.out.println(1);
  }

  @Override
  public void run() {
    System.out.println(SpringContextUtils.getApplicationContext().getEnvironment());
  }
}
