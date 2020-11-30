package com.education.timetable.converter;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.CourseCreateVo;
import com.education.timetable.model.vo.CourseVo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** @author jack */
public class CourseConverter {

  public static CourseVo toCourseVo(CoursePo course) {
    CourseVo courseVo = new CourseVo();
    courseVo.setCourseId(course.getCourseId());
    courseVo.setCourseName(course.getCourseName());
    courseVo.setCourseIntroduction(course.getCourseIntroduction());
    courseVo.setSubjectName(course.getSubjectName());
    courseVo.setRegisteredStudents(course.getRegisteredStudents());
    courseVo.setStartTime(course.getStartTime());
    courseVo.setEndTime(course.getEndTime());
    courseVo.setDay(course.getDay());
    courseVo.setTeacherId(course.getTeacherId());

    return courseVo;
  }

  public static List<CourseVo> toCourseVos(List<CoursePo> courses) {
    List<CourseVo> res = new ArrayList<>();
    for (CoursePo course : courses) {
      res.add(toCourseVo(course));
    }

    return res;
  }

  public static CoursePo toCoursePo(CourseVo courseVo) {
    CoursePo coursePo = new CoursePo();
    coursePo.setCourseId(UUID.randomUUID());
    coursePo.setCourseName(courseVo.getCourseName());
    coursePo.setCourseIntroduction(courseVo.getCourseIntroduction());
    coursePo.setSubjectId(UUID.randomUUID());
    coursePo.setSubjectName(courseVo.getSubjectName());
    coursePo.setRegisteredStudents(courseVo.getRegisteredStudents());
    coursePo.setStartTime(courseVo.getStartTime());
    coursePo.setEndTime(courseVo.getEndTime());
    coursePo.setDay(courseVo.getDay());
    coursePo.setTeacherId(courseVo.getTeacherId());

    return coursePo;
  }

  public static CoursePo toCoursePo(CourseCreateVo courseCreateVo) {
    CoursePo coursePo = new CoursePo();
    coursePo.setCourseId(UUID.randomUUID());
    coursePo.setCourseName(courseCreateVo.getCourseName());
    coursePo.setCourseIntroduction(courseCreateVo.getCourseIntroduction());
    coursePo.setSubjectId(UUID.randomUUID());
    coursePo.setSubjectName(courseCreateVo.getSubjectName());
    coursePo.setRegisteredStudents(courseCreateVo.getRegisteredStudents());
    coursePo.setStartTime(courseCreateVo.getStartTime());
    coursePo.setEndTime(courseCreateVo.getEndTime());
    coursePo.setTeacherId(courseCreateVo.getTeacherId());
    coursePo.setDay(courseCreateVo.getDay());

    return coursePo;
  }
}
