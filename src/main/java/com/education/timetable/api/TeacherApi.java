package com.education.timetable.api;

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
public interface TeacherApi {

  @ApiOperation("获取单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}", method = RequestMethod.GET)
  TeacherVo get(@ApiParam("老师id") @PathVariable("teacher_id") Long teacherId);

  @ApiOperation("创建老师")
  @RequestMapping(value = "/v1/teachers", method = RequestMethod.POST)
  TeacherVo create(@ApiParam("创建老师vo") @RequestBody TeacherCreateVo teacherCreateVo);

  // todo 分页

  @ApiOperation("根据任教学科搜索老师")
  @RequestMapping(value = "/v1/teachers/actions/search_by_subjects", method = RequestMethod.POST)
  List<TeacherVo> searchBySubject(@ApiParam("学科id") @RequestParam("subject_id") UUID subjectId);

  @ApiOperation("根据任教课程搜索老师")
  @RequestMapping(value = "/v1/teachers/actions/search_by_courses", method = RequestMethod.POST)
  TeacherVo searchByCourse(@ApiParam("课程id") @RequestParam("course_id") UUID courseId);

  @ApiOperation("获取多个老师")
  @RequestMapping(value = "/v1/teachers", method = RequestMethod.GET)
  List<TeacherVo> getAll();

  @ApiOperation("删除单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}", method = RequestMethod.DELETE)
  void delete(@ApiParam("老师id") @PathVariable("teacher_id") Long teacherId);

  @ApiOperation("批量删除老师")
  @RequestMapping(value = "/v1/teachers/actions/delete", method = RequestMethod.DELETE)
  void delete(@ApiParam("老师id列表") @RequestBody List<Long> teacherIds);

  @ApiOperation("更新单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}/actions/update", method = RequestMethod.PUT)
  TeacherVo update(@ApiParam("老师id") @PathVariable("teacher_id") Long teacherId, @ApiParam("更新vo") @RequestBody TeacherUpdateVo teacherUpdateVo);

}
