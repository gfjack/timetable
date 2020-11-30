package com.education.timetable.api;

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

// TODO: 11/30/2020 王鸿封
@Api("学科api")
public interface SubjectApi {

  @ApiOperation("获取单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}", method = RequestMethod.GET)
  SubjectVo get(@ApiParam("学科id") @PathVariable("subject_id") UUID subjectId);

  @ApiOperation("获取全部学科")
  @RequestMapping(value = "/v1/subjects", method = RequestMethod.GET)
  List<SubjectVo> getAll();

  @ApiOperation("分页查询")
  @RequestMapping(value = "/v1/subjects/actions/query", method = RequestMethod.POST)
  PagerResult<SubjectVo> query(
      @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

  @ApiOperation("创建学科")
  @RequestMapping(value = "/v1/subjects", method = RequestMethod.POST)
  SubjectVo create(@ApiParam("创建学科参数") @RequestBody SubjectCreateVo subjectCreateVo);

  @ApiOperation("根据阶段查找学科")
  @RequestMapping(value = "/v1/subjects/actions/search_by_sprint", method = RequestMethod.POST)
  List<SubjectVo> search(@ApiParam("阶段") @RequestParam("sprint") Integer sprint);

  @ApiOperation("删除单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}", method = RequestMethod.DELETE)
  void delete(@ApiParam("学生id") @PathVariable("subject_id") UUID subjectId);

  @ApiOperation("批量删除学科")
  @RequestMapping(value = "/v1/subjects/actions/delete", method = RequestMethod.DELETE)
  void delete(@ApiParam("学生id列表") @RequestBody List<Long> studentIds);

  @ApiOperation("更新单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}/actions/update", method = RequestMethod.PUT)
  SubjectVo update(
      @ApiParam("学科id") @PathVariable("subject_id") UUID subjectId,
      @ApiParam("更新vo") @RequestBody SubjectUpdateVo subjectUpdateVo);
}
