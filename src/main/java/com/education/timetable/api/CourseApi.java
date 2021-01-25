package com.education.timetable.api;

import com.education.timetable.constants.enums.Week;
import com.education.timetable.model.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api("课程api")
public interface CourseApi {

  @ApiOperation("获取单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.GET)
  CourseVo get(@ApiParam("课程id") @PathVariable("course_id") UUID courseId);

  @ApiOperation("获取多个课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
  List<CourseVo> getAll();

  @ApiOperation("分页获取课程")
  @RequestMapping(value = "/v1/courses/actions/query", method = RequestMethod.POST)
  PageResult<CourseVo> query(
      @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

  @ApiOperation("根据时间段搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search_by_time", method = RequestMethod.POST)
  List<CourseVo> getCoursesByTimeDuration(
      @ApiParam("开始时间") @RequestParam("start_time") Date startTime,
      @ApiParam("开始时间") @RequestParam("end_time") Date endTime,
      @ApiParam("星期日期") @RequestParam("week_day") Week day);

  @ApiOperation("根据学科搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search_by_subject", method = RequestMethod.POST)
  List<CourseVo> getCoursesBySubjectId(
      @ApiParam("学科id") @RequestParam("subject_id") UUID subjectId);

  @ApiOperation("搜索课程")
  @RequestMapping(value = "/v1/courses/actions/search", method = RequestMethod.POST)
  List<CourseVo> search(@ApiParam("课程搜索vo") @RequestBody CourseSearchVo courseSearchVo);

  @ApiOperation("创建课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.POST)
  CourseVo create(@ApiParam("课程创建vo") @RequestBody CourseCreateVo courseCreateVo);

  @ApiOperation("删除单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.DELETE)
  void delete(@ApiParam("课程id") @PathVariable("course_id") UUID courseId);

  @ApiOperation("批量课程")
  @RequestMapping(value = "/v1/courses/action/delete", method = RequestMethod.DELETE)
  void delete(@ApiParam("课程id列表") @RequestBody List<UUID> courseIds);

  @ApiOperation("更新单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.PUT)
  CourseVo update(
      @ApiParam("课程id") @PathVariable("course_id") UUID courseId,
      @ApiParam("更新参数") @RequestBody CourseUpdateVo courseUpdateVo);
}
