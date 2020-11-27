package com.education.timetable.service;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.CourseCreateVo;
import com.education.timetable.model.vo.CourseVo;

public interface CourseService {

	CourseVo create(CoursePo coursePo);

}
