package com.education.timetable.controller;

import com.education.timetable.api.SubjectApi;
import com.education.timetable.model.vo.SubjectCreateVo;
import com.education.timetable.model.vo.SubjectUpdateVo;
import com.education.timetable.model.vo.SubjectVo;
import com.education.timetable.model.vo.page.PagerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api("学科api")
@RestController
@RequestMapping("")
public class SubjectController implements SubjectApi {

  @Override
  @ApiOperation("获取单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}", method = RequestMethod.GET)
  public SubjectVo get(@ApiParam("学科id") @PathVariable("subject_id") UUID subjectId) {
    return null;
  }

  @Override
  @ApiOperation("获取全部学科")
  @RequestMapping(value = "/v1/subjects", method = RequestMethod.GET)
  public List<SubjectVo> getAll() {
    return null;
  }

  @Override
  @ApiOperation("分页查询")
  @RequestMapping(value = "/v1/subjects/actions/query", method = RequestMethod.POST)
  public PagerResult<SubjectVo> query(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
    return null;
  }

  @Override
  @ApiOperation("创建学科")
  @RequestMapping(value = "/v1/subjects", method = RequestMethod.POST)
  public SubjectVo create(@ApiParam("创建学科参数") @RequestBody SubjectCreateVo subjectCreateVo) {
    return null;
  }

  @Override
  @ApiOperation("根据阶段查找学科")
  @RequestMapping(value = "/v1/subjects/actions/search_by_sprint", method = RequestMethod.POST)
  public List<SubjectVo> search(@ApiParam("阶段") @RequestParam("sprint") Integer sprint) {
    return null;
  }

  @Override
  @ApiOperation("删除单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}", method = RequestMethod.DELETE)
  public void delete(@ApiParam("学生id") @PathVariable("subject_id") UUID subjectId) {

  }

  @Override
  @ApiOperation("批量删除学科")
  @RequestMapping(value = "/v1/subjects/actions/delete", method = RequestMethod.DELETE)
  public void delete(@ApiParam("学生id列表") @RequestBody List<Long> studentIds) {

  }

  @Override
  @ApiOperation("更新单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}/actions/update", method = RequestMethod.PUT)
  public SubjectVo update(@ApiParam("学科id") @PathVariable("subject_id") UUID subjectId, @ApiParam("更新vo") @RequestBody SubjectUpdateVo subjectUpdateVo) {
    return null;
  }
}
