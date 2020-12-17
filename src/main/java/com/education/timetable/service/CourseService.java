package com.education.timetable.service;

import com.education.timetable.constants.enums.Week;
import com.education.timetable.model.vo.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CourseService {

  /**
   * 获取某个课程
   *
   * @param courseId 课程id
   * @return coursePo
   */
  CourseVo get(UUID courseId);

  /**
   * 获取全部课程
   *
   * @return 获取全部课程
   */
  List<CourseVo> getAll();

  /**
   * 分页获取课程
   *
   * @param offset offset
   * @param limit limit
   * @return pager
   */
  PageResult<CourseVo> query(Integer offset, Integer limit);

  /**
   * 根据日期和时间段获取课程
   *
   * @param startTime 开始时间
   * @param endTime 结束时间
   * @param day 周几
   * @return list of courses
   */
  List<CourseVo> getCoursesByTimeDuration(Date startTime, Date endTime, Week day);

  /**
   * 根据学科Id获取课程
   *
   * @param subjectId 学科id
   * @return list of courses
   */
  List<CourseVo> getCoursesBySubjectId(UUID subjectId);

  /**
   * 根据参数搜索课程
   *
   * @param courseSearchVo search vo
   * @return list of courses
   */
  List<CourseVo> search(CourseSearchVo courseSearchVo);

  /**
   * 创建课程
   *
   * @param courseCreateVo create vo
   * @return created vo
   */
  CourseVo create(CourseCreateVo courseCreateVo);

  /**
   * 删除课程
   *
   * @param courseId 课程id
   */
  void delete(UUID courseId);

  /**
   * 批量删除课程
   *
   * @param courseIds 课程ids
   */
  void delete(List<UUID> courseIds);

  /**
   * 课程更新
   *
   * @param courseId 课程id
   * @param courseUpdateVo update vo
   * @return course
   */
  CourseVo update(UUID courseId, CourseUpdateVo courseUpdateVo);
}
