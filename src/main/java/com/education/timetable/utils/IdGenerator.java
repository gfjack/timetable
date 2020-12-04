package com.education.timetable.utils;


import org.apache.commons.lang3.StringUtils;


/**
 * 用于生成学生学号
 */
public class IdGenerator {

    public static Long generateStudentId(String name, String number) {
        StringBuilder id = new StringBuilder();
        // 起始段
        id.append("66");
        // 当前日期
        id.append(DateUtils.getCurrentDate());
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
