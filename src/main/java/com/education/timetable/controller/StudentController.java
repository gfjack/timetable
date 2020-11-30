package com.education.timetable.controller;

import com.education.timetable.api.StudentApi;
import com.education.timetable.model.vo.*;
import com.education.timetable.model.vo.page.PagerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "学生相关接口")
@RestController
@RequestMapping("")
public class StudentController implements StudentApi {

  @Override
  @ApiOperation("创建学生")
  @RequestMapping(value = "/v1/students", method = RequestMethod.POST)
  public StudentVo create(@ApiParam("创建学生参数") @RequestBody StudentCreateVo studentCreateVo) {
    return null;
  }

  @Override
  @ApiOperation("获取单个学生")
  @RequestMapping(value = "/v1/students/{student_id}", method = RequestMethod.GET)
  public StudentVo get(@ApiParam("学生id") @PathVariable("student_id") Long studentId) {
    return null;
  }

  @Override
  @ApiOperation("获取全部学生")
  @RequestMapping(value = "/v1/students", method = RequestMethod.GET)
  public List<StudentVo> getAll() {
    return null;
  }

  @Override
  @ApiOperation("分页搜索学生")
  @RequestMapping(value = "/v1/students/actions/query", method = RequestMethod.POST)
  public PagerResult<StudentVo> query(
      @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
    return null;
  }

  @Override
  @ApiOperation("删除单个学生")
  @RequestMapping(value = "/v1/students/{student_id}", method = RequestMethod.DELETE)
  public void delete(@ApiParam("学生id") @PathVariable("student_id") Long studentId) {}

  @Override
  @ApiOperation("批量删除学生")
  @RequestMapping(value = "/v1/students/actions/delete", method = RequestMethod.DELETE)
  public void delete(@ApiParam("学生id列表") @RequestBody List<Long> studentIds) {}

  @Override
  @ApiOperation("更新单个学生")
  @RequestMapping(value = "/v1/students/{student_id}/actions/update", method = RequestMethod.PUT)
  public StudentVo update(
      @ApiParam("学生id") @PathVariable("student_id") Long studentId,
      @ApiParam("更新参数") @RequestBody StudentUpdateVo studentUpdateVo) {
    return null;
  }

  @Override
  @ApiOperation("报名课程")
  @RequestMapping(
      value = "/v1/students/{student_id}/courses/{course_id}/action/register",
      method = RequestMethod.POST)
  public StudentRegisterVo register(
      @ApiParam("学生id") @PathVariable("student_id") Long studentId,
      @ApiParam("课程id") @PathVariable("course_id") UUID courseId) {
    return null;
  }

  @Override
  @ApiOperation("撤销报名课程 ")
  @RequestMapping(
      value = "/v1/students/{student_id}/courses/{course_id}/action/withdraw",
      method = RequestMethod.PUT)
  public StudentWithdrawVo withdraw(
      @ApiParam("学生id") @PathVariable("student_id") Long studentId,
      @ApiParam("课程id") @PathVariable("course_id") UUID courseId) {
    return null;
  }
}
