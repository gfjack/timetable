package com.education.timetable.controller;

import com.education.timetable.api.CourseApi;
import com.education.timetable.model.vo.CourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Api("课程api")
@RestController
@RequestMapping("")
public class CourseController implements CourseApi {

  @ApiOperation("获取单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.GET)
  @Override
  public CourseVo get(@PathVariable("course_id") UUID courseId) {
    return null;
  }

  @ApiOperation("获取多个课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
  @Override
  public List<CourseVo> getAll() {
    return null;
  }

  @ApiOperation("创建课程")
  @RequestMapping(value = "/v1/courses/{course_id}/action/add", method = RequestMethod.POST)
  @Override
  public CourseVo create(@PathVariable("course_id") UUID courseId) {
    return null;
  }

  @ApiOperation("删除单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}/action/delete", method = RequestMethod.DELETE)
  @Override
  public void delete(@PathVariable("course_id") UUID courseId) {

  }

  @ApiOperation("更新单个课程")
  // todo 重新定义 updateVo
  @RequestMapping(value = "/v1/courses/{course_id}/action/update", method = RequestMethod.PUT)
  @Override
  public CourseVo update(@PathVariable("course_id") UUID courseId) {
    return null;
  }

}
