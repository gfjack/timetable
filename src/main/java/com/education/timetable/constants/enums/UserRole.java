package com.education.timetable.constants.enums;

/** 用户角色 */
public enum UserRole {

  /** 学生 */
  STUDENT(1),

  /** 老师 */
  TEACHER(2),

  /** 家长 */
  GUARDIAN(3);

  public Integer code;

  UserRole(Integer code) {
    this.code = code;
  }

  public static UserRole getByName(String key) {
    for (UserRole userRole : UserRole.values()) {
      if (userRole.name().equalsIgnoreCase(key)) {
        return userRole;
      }
    }

    return null;
  }

  public static UserRole getByCode(Integer code) {
    for (UserRole userRole : UserRole.values()) {
      if (userRole.code.equals(code)) {
        return userRole;
      }
    }

    return null;
  }
}
