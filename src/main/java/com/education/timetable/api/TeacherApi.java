package com.education.timetable.api;

import com.education.timetable.model.vo.TeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api("老师api")
public interface TeacherApi {

  @ApiOperation("获取单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}", method = RequestMethod.GET)
  TeacherVo get(@PathVariable("teacher_id") Long teacherId);

  @ApiOperation("获取多个老师")
  @RequestMapping(value = "/v1/teachers", method = RequestMethod.GET)
  List<TeacherVo> get();

  @ApiOperation("删除单个老师")
  @RequestMapping(value = "/v1/teachers/{teacher_id}/actions/delete", method = RequestMethod.DELETE)
  void delete(@PathVariable("teacher_id") Long teacherId);

  @ApiOperation("更新单个老师")
  // todo 重新定义 updateVo
  @RequestMapping(value = "/v1/teachers/{teacher_id}/actions/update", method = RequestMethod.PUT)
  TeacherVo update(@PathVariable("teacher_id") Long teacherId);

}
