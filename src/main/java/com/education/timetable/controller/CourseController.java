package com.education.timetable.controller;

import com.education.timetable.api.CourseApi;
import com.education.timetable.model.vo.CourseCreateVo;
import com.education.timetable.model.vo.CourseSearchVo;
import com.education.timetable.model.vo.CourseUpdateVo;
import com.education.timetable.model.vo.CourseVo;
import com.education.timetable.model.vo.page.PagerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api("课程api")
@RestController
@RequestMapping("")
public class CourseController implements CourseApi {

  @Override
  @ApiOperation("获取单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.GET)
  public CourseVo get(@ApiParam("课程id") @PathVariable("course_id") UUID courseId) {
    return null;
  }

  @Override
  @ApiOperation("获取多个课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
  public List<CourseVo> getAll() {
    return null;
  }

  @Override
  @ApiOperation("分页获取课程")
  @RequestMapping(value = "/v1/courses/actions/query", method = RequestMethod.POST)
  public PagerResult<CourseVo> query(
      @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
    return null;
  }

  @Override
  @ApiOperation("根据时间段搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search_by_time", method = RequestMethod.POST)
  public List<CourseVo> getCoursesByTimeDuration(
      @ApiParam("开始时间") @RequestParam("start_time") Date startTime,
      @ApiParam("开始时间") @RequestParam("end_time") Date endTime) {
    return null;
  }

  @Override
  @ApiOperation("根据学科搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search_by_subject", method = RequestMethod.POST)
  public List<CourseVo> getCoursesBySubjectId(
      @ApiParam("学科id") @RequestParam("subject_id") UUID subjectId) {
    return null;
  }

  @Override
  @ApiOperation("搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search", method = RequestMethod.POST)
  public List<CourseVo> search(@ApiParam("课程搜索vo") @RequestBody CourseSearchVo courseSearchVo) {
    return null;
  }

  @Override
  @ApiOperation("创建课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.POST)
  public CourseVo create(@ApiParam("课程创建vo") @RequestBody CourseCreateVo courseCreateVo) {
    return null;
  }

  @Override
  @ApiOperation("删除单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.DELETE)
  public void delete(@ApiParam("课程id") @PathVariable("course_id") UUID courseId) {}

  @Override
  @ApiOperation("批量课程")
  @RequestMapping(value = "/v1/courses/action/delete", method = RequestMethod.DELETE)
  public void delete(@ApiParam("课程id列表") @RequestBody List<Long> courseIds) {}

  @Override
  @ApiOperation("更新单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.PUT)
  public CourseVo update(
      @ApiParam("课程id") @PathVariable("course_id") UUID courseId,
      @ApiParam("更新参数") @RequestBody CourseUpdateVo courseUpdateVo) {
    return null;
  }
}
