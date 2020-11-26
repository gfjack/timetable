package com.education.timetable.controller;

import com.education.timetable.api.StudentApi;
import com.education.timetable.model.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("学生api")
@RestController
@RequestMapping("")
public class StudentController implements StudentApi {

  @ApiOperation("获取单个学生")
  @RequestMapping(value = "/v1/students/{student_id}", method = RequestMethod.GET)
  @Override
  public StudentVo get(@PathVariable("student_id") Long studentId) {
    return null;
  }

  @ApiOperation("获取多个学生")
  @RequestMapping(value = "/v1/students", method = RequestMethod.GET)
  @Override
  public List<StudentVo> getAll() {
    return null;
  }

  @ApiOperation("删除单个学生")
  @RequestMapping(value = "/v1/students/{student_id}/actions/delete")
  @Override
  public void delete(@PathVariable("student_id") Long studentId) {

  }

  @ApiOperation("更新单个学生")
  // todo 重新定义 updateVo
  @RequestMapping(value = "/v1/students/{student_id}/actions/update", method = RequestMethod.PUT)
  @Override
  public StudentVo update(@PathVariable("student_id") Long studentId) {
    return null;
  }

}
