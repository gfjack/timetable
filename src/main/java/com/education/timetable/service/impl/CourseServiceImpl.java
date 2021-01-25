package com.education.timetable.service.impl;

import com.education.timetable.config.SR;
import com.education.timetable.constants.enums.Week;
import com.education.timetable.exception.ObjectNotFoundException;
import com.education.timetable.exception.ServerException;
import com.education.timetable.exception.TimeTableException;
import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.*;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.CourseConverter.*;
import static com.education.timetable.utils.DateUtils.between;
import static com.education.timetable.utils.DateUtils.validateTime;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

  @Resource private CourseRepository courseRepository;

  private CoursePo load(UUID courseId) {
    CoursePo coursePo = courseRepository.findByCourseId(courseId);
    if (null == coursePo) {
      throw new ObjectNotFoundException(SR.getString("COURSE.NOT.FOUND"));
    }

    return coursePo;
  }

  @Override
  public CourseVo get(UUID courseId) {
    return toCourseVo(load(courseId));
  }

  @Override
  public List<CourseVo> getAll() {
    List<CoursePo> courses = courseRepository.findAll();
    return toCourseVos(courses);
  }

  @Override
  public PageResult<CourseVo> query(Integer offset, Integer limit) {
    PageResult<CourseVo> courseVoPagerResult = new PageResult<>();
    List<CoursePo> courses = courseRepository.findPage(offset, limit);
    courseVoPagerResult.setItems(toCourseVos(courses));
    courseVoPagerResult.setCount(courses.size());
    return courseVoPagerResult;
  }

  @Override
  public List<CourseVo> getCoursesByTimeDuration(Date startTime, Date endTime, Week day) {
    List<CoursePo> allCourses = courseRepository.findAllByDay(day);
    List<CoursePo> courses = filterCoursesByTime(allCourses, startTime, endTime);
    return toCourseVos(courses);
  }

  @Override
  public List<CourseVo> getCoursesBySubjectId(UUID subjectId) {
    return toCourseVos(courseRepository.findAllBySubjectId(subjectId));
  }

  @Override
  public List<CourseVo> search(CourseSearchVo courseSearchVo) {
    if (null == courseSearchVo.getStudentId()) {
      throw new TimeTableException(SR.getString("STUDENT.ID.CANNOT.BE.NULL"));
    }
    List<CoursePo> courses =
        getStudentRegisteredCourses(courseSearchVo.getStudentId(), courseSearchVo.getDay());
    List<CoursePo> results =
        filterCoursesByTime(courses, courseSearchVo.getStartTime(), courseSearchVo.getEndTime());
    return toCourseVos(results);
  }

  @Override
  public CourseVo create(CourseCreateVo courseCreateVo) {
    validateTime(courseCreateVo.getStartTime(), courseCreateVo.getEndTime());
    CoursePo coursePo = toCoursePo(courseCreateVo);
    try {
      courseRepository.save(coursePo);
    } catch (Exception e) {
      throw new TimeTableException(e.getMessage());
    }
    return toCourseVo(coursePo);
  }

  @Override
  public void delete(UUID courseId) {
    try {
      load(courseId);
      courseRepository.delete(courseId);
    } catch (ObjectNotFoundException e) {
      throw new ObjectNotFoundException(SR.getString("COURSE.NOT.FOUND"));
    } catch (Exception e) {
      throw new ServerException(SR.getString("FAILED.TO.DELETE.COURSE"));
    }
  }

  @Override
  public void delete(List<UUID> courseIds) {
    for (UUID id : courseIds) {
      try {
        delete(id);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }

  @Override
  public CourseVo update(UUID courseId, CourseUpdateVo courseUpdateVo) {
    CoursePo coursePo = load(courseId);
    updateCoursePo(courseUpdateVo, coursePo);
    try {
      courseRepository.save(coursePo);
    } catch (Exception e) {
      throw new ServerException(e.getMessage());
    }
    return toCourseVo(coursePo);
  }

  /**
   * 根据周几获取学生课程, 不传周几则全部返回
   *
   * @param studentId 学生id
   * @param day 周几
   * @return list of courses
   */
  public List<CoursePo> getStudentRegisteredCourses(Long studentId, Week day) {
    List<CoursePo> registeredCourses = new ArrayList<>();
    List<CoursePo> courses;
    if (null != day) {
      courses = courseRepository.findAllByDay(day);
    } else {
      courses = courseRepository.findAll();
    }
    for (CoursePo coursePo : courses) {
      if (CollectionUtils.isEmpty(coursePo.getRegisteredStudents())) {
        continue;
      }
      if (coursePo.getRegisteredStudents().contains(studentId)) {
        registeredCourses.add(coursePo);
      }
    }

    return registeredCourses;
  }

  /**
   * 筛选学生在某一个时间段内的课程
   *
   * @param sources 学生的所有课程
   * @param startTime 开始时间
   * @param endTime 结束时间
   * @return list of courses
   */
  public List<CoursePo> filterCoursesByTime(List<CoursePo> sources, Date startTime, Date endTime) {
    if (null == startTime || null == endTime) {
      return sources;
    }
    List<CoursePo> res = new ArrayList<>();
    for (CoursePo coursePo : sources) {
      if (between(startTime, endTime, coursePo.getStartTime(), coursePo.getEndTime())) {
        res.add(coursePo);
      }
    }

    return res;
  }
}
