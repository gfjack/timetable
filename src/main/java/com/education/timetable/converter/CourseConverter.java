package com.education.timetable.converter;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.CourseCreateVo;
import com.education.timetable.model.vo.CourseVo;

import java.util.UUID;

/** @author jack */
public class CourseConverter {

  public static CourseVo toCourseVo(CoursePo course) {
    CourseVo courseVo = new CourseVo();
    courseVo.setCourseId(course.getCourseId());
    courseVo.setCourseName(course.getCourseName());
    courseVo.setSubjectName(course.getSubjectName());
    courseVo.setRegisteredStudents(course.getRegisteredStudents());
    courseVo.setStartTime(course.getStartTime());
    courseVo.setEndTime(course.getEndTime());

    return courseVo;
  }

  public static CoursePo toCoursePo(CourseVo courseVo) {
    CoursePo coursePo = new CoursePo();
    coursePo.setCourseId(UUID.randomUUID());
    coursePo.setCourseName(courseVo.getCourseName());
    coursePo.setSubjectId(UUID.randomUUID());
    coursePo.setSubjectName(courseVo.getSubjectName());
    coursePo.setRegisteredStudents(courseVo.getRegisteredStudents());
    coursePo.setStartTime(courseVo.getStartTime());
    coursePo.setEndTime(courseVo.getEndTime());

    return coursePo;
  }

  public static CoursePo toCoursePo(CourseCreateVo courseCreateVo) {
    CoursePo coursePo = new CoursePo();
    coursePo.setCourseId(UUID.randomUUID());
    coursePo.setCourseName(courseCreateVo.getCourseName());
    coursePo.setSubjectId(UUID.randomUUID());
    coursePo.setSubjectName(courseCreateVo.getSubjectName());
    coursePo.setRegisteredStudents(courseCreateVo.getRegisteredStudents());
    coursePo.setStartTime(courseCreateVo.getStartTime());
    coursePo.setEndTime(courseCreateVo.getEndTime());

    return coursePo;
  }
}
