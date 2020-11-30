package com.education.timetable.utils;

import com.education.timetable.exception.TimeTableException;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtils {

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static void validateTime(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            throw new TimeTableException("begin time or end time cannot be null");
        }
        if (startTime.after(endTime)) {
            throw new TimeTableException("start time must be before end time");
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
