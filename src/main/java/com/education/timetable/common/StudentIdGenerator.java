package com.education.timetable.common;


import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * 用于生成学生学号
 */
public class StudentIdGenerator {

    public static Long generateStudentId(String name, String number) {
        Calendar calendar = Calendar.getInstance();
        StringBuilder id = new StringBuilder();
        // 起始段
        id.append("66");
        // 当前日期
        id.append(calendar.get(Calendar.YEAR));
        id.append(calendar.get(Calendar.MONTH));
        id.append(calendar.get(Calendar.DAY_OF_MONTH));
        // 姓名长度和电话号拼接
        if (StringUtils.isBlank(name)) {
            name = "default";
        }
        if (StringUtils.isBlank(number) || number.length() < 4 || !StringUtils.isNumeric(number)) {
            number = "0000";
        }
        id.append(name.length());
        id.append(StringUtils.substring(number, -3));
        // 校区代码
        id.append("1");
        return Long.parseLong(id.toString());
    }
}
