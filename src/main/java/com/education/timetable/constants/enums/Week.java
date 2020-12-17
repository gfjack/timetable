package com.education.timetable.constants.enums;

public enum Week {

  /** 周一 */
  MONDAY(0, "周一"),

  /** 周二 */
  TUESDAY(1, "周二"),

  /** 周三 */
  WEDNESDAY(2, "周三"),

  /** 周四 */
  THURSDAY(3, "周四"),

  /** 周五 */
  FRIDAY(4, "周五"),

  /** 周六 */
  SATURDAY(5, "周六"),

  /** 周日 */
  SUNDAY(6, "周日");

  private final Integer code;
  private final String name;

  Week(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  public static Week getByCode(Integer code) {
    for (Week week : Week.values()) {
      if (week.code.equals(code)) {
        return week;
      }
    }

    return null;
  }

  public static Week getByName(String name) {
    for (Week week : Week.values()) {
      if (week.name.equalsIgnoreCase(name)) {
        return week;
      }
    }

    return null;
  }
}
