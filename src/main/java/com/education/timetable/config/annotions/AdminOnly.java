package com.education.timetable.config.annotions;

import java.lang.annotation.*;

/**
 * 管理员权限注解
 * @author 古丰杰
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminOnly {
}
