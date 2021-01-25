package com.education.timetable.config.aspects;

import com.education.timetable.config.SR;
import com.education.timetable.config.annotions.AdminOnly;
import com.education.timetable.exception.TimeTableException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.education.timetable.constants.constants.Constant.TOKEN;

@Aspect
@Component
public class AdminOnlyAspect {

  @Pointcut("@annotation(com.education.timetable.config.annotions.AdminOnly)")
  public void adminOnly() {}

  @Before("adminOnly()")
  public void doBefore(JoinPoint point) {

    // 获取请求
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 仅模板, 用于获取注解上的内容, 可以在里面自定义value, 但是目前仅做模板不需要
    MethodSignature signature = (MethodSignature) point.getSignature();
    AdminOnly adminOnly = signature.getMethod().getAnnotation(AdminOnly.class);

    // 如果为空, 则获取类注解
    if (adminOnly == null) {
      adminOnly = signature.getMethod().getDeclaringClass().getAnnotation(AdminOnly.class);
    }

    String token = request.getHeader(TOKEN);
    if (!"admin".equalsIgnoreCase(token)) {
      throw new TimeTableException(
          HttpStatus.FORBIDDEN.value(), SR.getString("NOT.ADMIN.USER"));
    }
  }
}
