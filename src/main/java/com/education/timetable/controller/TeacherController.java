package com.education.timetable.controller;

import com.education.timetable.api.TeacherApi;
import com.education.timetable.model.vo.TeacherCreateVo;
import com.education.timetable.model.vo.TeacherUpdateVo;
import com.education.timetable.model.vo.TeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api("老师api")
@RestController
@RequestMapping("")
public class TeacherController implements TeacherApi {

  @Override
  @ApiOperation("获取单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}", method = RequestMethod.GET)
  public TeacherVo get(@ApiParam("老师id") @PathVariable("teacher_id") Long teacherId) {
    return null;
  }

  @Override
  @ApiOperation("创建老师")
  @RequestMapping(value = "/v1/teachers", method = RequestMethod.POST)
  public TeacherVo create(@ApiParam("创建老师vo") @RequestBody TeacherCreateVo teacherCreateVo) {
    return null;
  }

  @Override
  @ApiOperation("根据任教学科搜索老师")
  @RequestMapping(value = "/v1/teachers/actions/search_by_subjects", method = RequestMethod.POST)
  public List<TeacherVo> searchBySubject(@ApiParam("学科id") @RequestParam("subject_id") UUID subjectId) {
    return null;
  }

  @Override
  @ApiOperation("根据任教课程搜索老师")
  @RequestMapping(value = "/v1/teachers/actions/search_by_courses", method = RequestMethod.POST)
  public TeacherVo searchByCourse(@ApiParam("课程id") @RequestParam("course_id") UUID courseId) {
    return null;
  }

  @Override
  @ApiOperation("获取多个老师")
  @RequestMapping(value = "/v1/teachers", method = RequestMethod.GET)
  public List<TeacherVo> getAll() {
    return null;
  }

  @Override
  @ApiOperation("删除单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}", method = RequestMethod.DELETE)
  public void delete(@ApiParam("老师id") @PathVariable("teacher_id") Long teacherId) {

  }

  @Override
  @ApiOperation("批量删除老师")
  @RequestMapping(value = "/v1/teachers/actions/delete", method = RequestMethod.DELETE)
  public void delete(@ApiParam("老师id列表") @RequestBody List<Long> teacherIds) {

  }

  @Override
  @ApiOperation("更新单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}/actions/update", method = RequestMethod.PUT)
  public TeacherVo update(@ApiParam("老师id") @PathVariable("teacher_id") Long teacherId, @ApiParam("更新vo") @RequestBody TeacherUpdateVo teacherUpdateVo) {
    return null;
  }

}
