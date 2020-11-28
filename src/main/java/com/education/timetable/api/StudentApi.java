package com.education.timetable.api;

import com.education.timetable.model.vo.StudentCreateVo;
import com.education.timetable.model.vo.StudentUpdateVo;
import com.education.timetable.model.vo.StudentVo;
import com.education.timetable.model.vo.page.PagerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("学生api")
public interface StudentApi {

  @ApiOperation("创建学生")
  @RequestMapping(value = "/v1/students", method = RequestMethod.POST)
  StudentVo create(@ApiParam("创建学生参数") @RequestBody StudentCreateVo studentCreateVo);

  @ApiOperation("获取单个学生")
  @RequestMapping(value = "/v1/students/{student_id}", method = RequestMethod.GET)
  StudentVo get(@ApiParam("学生id") @PathVariable("student_id") Long studentId);

  @ApiOperation("获取全部学生")
  @RequestMapping(value = "/v1/students", method = RequestMethod.GET)
  List<StudentVo> getAll();

  @ApiOperation("分页搜索学生")
  @RequestMapping(value = "/v1/students/actions/query", method = RequestMethod.POST)
  PagerResult<StudentVo> query(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

//  @ApiOperation("参数搜索学生")
//  @RequestMapping(value = "/v1/students/actions/search", method = RequestMethod.POST)
//  List<StudentVo> search(@ApiParam("搜索参数") @RequestBody StudentSearchVo studentSearchVo);

  @ApiOperation("删除单个学生")
  @RequestMapping(value = "/v1/students/{student_id}", method = RequestMethod.DELETE)
  void delete(@ApiParam("学生id") @PathVariable("student_id") Long studentId);

  @ApiOperation("批量删除学生")
  @RequestMapping(value = "/v1/students/actions/delete", method = RequestMethod.DELETE)
  void delete(@ApiParam("学生id列表") @RequestBody List<Long> studentIds);

  @ApiOperation("更新单个学生")
  @RequestMapping(value = "/v1/students/{student_id}/actions/update", method = RequestMethod.PUT)
  StudentVo update(@ApiParam("学生id") @PathVariable("student_id") Long studentId, @ApiParam("更新参数") @RequestBody StudentUpdateVo studentUpdateVo);

}
