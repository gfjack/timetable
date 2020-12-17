package com.education.timetable.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** 获取框架上下文信息 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  /**
   * 获取上下文
   *
   * @return 上下文
   */
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  /**
   * 设置上下文
   *
   * @param applicationContext 上下文
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    SpringContextUtils.applicationContext = applicationContext;
  }

  /**
   * 通过名字获取上下文中的bean
   *
   * @param name 类名
   * @return object
   */
  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }

  /**
   * 通过类型获取上下文中的bean
   *
   * @param requiredType 类型
   * @return object
   */
  public static Object getBean(Class<?> requiredType) {
    return applicationContext.getBean(requiredType);
  }
}
