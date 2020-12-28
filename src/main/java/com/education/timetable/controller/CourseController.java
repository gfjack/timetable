package com.education.timetable.controller;

import com.education.timetable.api.CourseApi;
import com.education.timetable.config.annotions.AdminOnly;
import com.education.timetable.constants.enums.Week;
import com.education.timetable.model.vo.*;
import com.education.timetable.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api(tags = "课程相关接口")
@RestController
@RequestMapping("")
public class CourseController implements CourseApi {

  @Resource private CourseService courseService;

  @Override
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.GET)
  @ApiOperation("获取单个课程")
  public CourseVo get(@ApiParam("课程id") @PathVariable("course_id") UUID courseId) {
    return courseService.get(courseId);
  }

  @Override
  @ApiOperation("获取全部课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
  public List<CourseVo> getAll() {
    return courseService.getAll();
  }

  @Override
  @ApiOperation("分页获取课程")
  @RequestMapping(value = "/v1/courses/actions/query", method = RequestMethod.POST)
  public PageResult<CourseVo> query(
      @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
    return courseService.query(offset, limit);
  }

  @Override
  @ApiOperation("根据时间段搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search_by_time", method = RequestMethod.POST)
  public List<CourseVo> getCoursesByTimeDuration(
      @ApiParam("开始时间") @RequestParam("start_time") Date startTime,
      @ApiParam("结束时间") @RequestParam("end_time") Date endTime,
      @ApiParam("星期日期") @RequestParam("week_day") Week day) {
    return courseService.getCoursesByTimeDuration(startTime, endTime, day);
  }

  @Override
  @ApiOperation("根据学科搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search_by_subject", method = RequestMethod.POST)
  public List<CourseVo> getCoursesBySubjectId(
      @ApiParam("学科id") @RequestParam("subject_id") UUID subjectId) {
    return courseService.getCoursesBySubjectId(subjectId);
  }

  @Override
  @ApiOperation("搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search", method = RequestMethod.POST)
  public List<CourseVo> search(@ApiParam("课程搜索vo") @RequestBody CourseSearchVo courseSearchVo) {
    return courseService.search(courseSearchVo);
  }

  @Override
  @AdminOnly
  @ApiOperation("创建课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.POST)
  public CourseVo create(@ApiParam("课程创建vo") @RequestBody CourseCreateVo courseCreateVo) {
    return courseService.create(courseCreateVo);
  }

  @Override
  @AdminOnly
  @ApiOperation("删除单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.DELETE)
  public void delete(@ApiParam("课程id") @PathVariable("course_id") UUID courseId) {
    courseService.delete(courseId);
  }

  @Override
  @AdminOnly
  @ApiOperation("批量删除课程")
  @RequestMapping(value = "/v1/courses/action/delete", method = RequestMethod.DELETE)
  public void delete(@ApiParam("课程id列表") @RequestBody List<UUID> courseIds) {
    courseService.delete(courseIds);
  }

  @Override
  @AdminOnly
  @ApiOperation("更新单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.PUT)
  public CourseVo update(
      @ApiParam("课程id") @PathVariable("course_id") UUID courseId,
      @ApiParam("更新参数") @RequestBody CourseUpdateVo courseUpdateVo) {
    return courseService.update(courseId, courseUpdateVo);
  }
}
