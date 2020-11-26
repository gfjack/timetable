package com.education.timetable.api;

import com.education.timetable.model.vo.CourseCreateVo;
import com.education.timetable.model.vo.CourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Api("课程api")
public interface CourseApi {

  @ApiOperation("获取单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}", method = RequestMethod.GET)
  CourseVo get(@PathVariable("course_id") UUID courseId);

  @ApiOperation("获取多个课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
  List<CourseVo> getAll();

  @ApiOperation("创建课程")
  @RequestMapping(value = "/v1/courses", method = RequestMethod.POST)
  CourseVo create(@RequestBody CourseCreateVo courseCreateVo);

  @ApiOperation("删除单个课程")
  @RequestMapping(value = "/v1/courses/{course_id}/action/delete", method = RequestMethod.DELETE)
  void delete(@PathVariable("course_id") UUID courseId);

  @ApiOperation("更新单个课程")
  // todo 重新定义 updateVo
  @RequestMapping(value = "/v1/courses/{course_id}/action/update", method = RequestMethod.PUT)
  CourseVo update(@PathVariable("course_id") UUID courseId);

}
