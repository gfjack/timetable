package com.education.timetable.utils;

import com.education.timetable.config.StringResources;
import com.education.timetable.exception.TimeTableException;
import lombok.extern.slf4j.Slf4j;

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


    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyMMdd");
        return simpleFormatter.format(date);
    }

    public static void validateTime(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            throw new TimeTableException(StringResources.getString("BEGIN.TIME.OR.END.TIME.NOT.NULL"));
        }
        if (startTime.after(endTime)) {
            throw new TimeTableException(StringResources.getString("BEGIN.TIME.MUST.BEFORE.END.TIME"));
        }
    }

    /**
     * 比较时间段是否在某一时间段内
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param sourceStartTime 比较的开始时间
     * @param sourceEndTime 比较的课程时间
     * @return true/false
     */
    public static boolean between(Date startTime, Date endTime, Date sourceStartTime, Date sourceEndTime) {
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
}
