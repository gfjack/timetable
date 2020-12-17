package com.education.timetable.service;

import com.education.timetable.model.vo.TeacherVo;

import java.util.List;

public interface TeacherService {
    /**
     * 获取全部学生
     *
     * @return list of students
     */
    List<TeacherVo> getAll();
}
