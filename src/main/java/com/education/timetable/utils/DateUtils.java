package com.education.timetable.utils;

import com.education.timetable.config.StringResources;
import com.education.timetable.exception.TimeTableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtils {

  public static int getYear(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(Calendar.YEAR);
  }

  public static String getCurrentDate() {
    Date date = new Date();
    SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyMMdd");
    return simpleFormatter.format(date);
  }

  /**
   * 配合业务需要, 需要验证时间是否是整点时间
   *
   * @param startTime 开始时间
   * @param endTime 结束时间
   */
  public static void validateTime(Date startTime, Date endTime) {
    if (startTime == null || endTime == null) {
      throw new TimeTableException(StringResources.getString("BEGIN.TIME.OR.END.TIME.NOT.NULL"));
    }
    isSharpTime(startTime);
    isSharpTime(endTime);
    if (startTime.after(endTime) || startTime.equals(endTime)) {
      throw new TimeTableException(StringResources.getString("BEGIN.TIME.MUST.BEFORE.END.TIME"));
    }
  }

  /**
   * 比较时间段是否在某一时间段内
   *
   * @param startTime 开始时间
   * @param endTime 结束时间
   * @param sourceStartTime 比较的开始时间
   * @param sourceEndTime 比较的课程时间
   * @return true/false
   */
  public static boolean between(
      Date startTime, Date endTime, Date sourceStartTime, Date sourceEndTime) {
    validateTime(startTime, endTime);
    validateTime(sourceStartTime, sourceEndTime);
    if (startTime.before(sourceStartTime)) {
      return false;
    }
    if (startTime.after(sourceEndTime)) {
      return false;
    }
    if (endTime.before(sourceStartTime)) {
      return false;
    }
    return !endTime.after(sourceEndTime);
  }

  public static void isSharpTime(Date date) {
    SimpleDateFormat formatMinutes = new SimpleDateFormat("mm");
    SimpleDateFormat formatSeconds = new SimpleDateFormat("ss");
    String minutes = formatMinutes.format(date);
    String seconds = formatSeconds.format(date);
    if (!"00".equals(minutes) || !"00".equals(seconds)) {
      throw new TimeTableException(
          HttpStatus.BAD_REQUEST.value(),
          String.format(StringResources.getString("INCORRECT.SHARP.TIME") + ": %s", date));
    }
  }

}
