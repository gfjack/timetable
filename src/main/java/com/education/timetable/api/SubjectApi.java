package com.education.timetable.api;

import com.education.timetable.model.vo.SubjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Api("学科api")
public interface SubjectApi {

  @ApiOperation("获取单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}", method = RequestMethod.GET)
  SubjectVo get(@PathVariable("subject_id") UUID subjectId);

  @ApiOperation("获取多个学科")
  @RequestMapping(value = "/v1/subjects", method = RequestMethod.GET)
  List<SubjectVo> getAll();

  @ApiOperation("删除单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}/actions/delete", method = RequestMethod.GET)
  void delete(@PathVariable("subject_id") UUID subjectId);

  @ApiOperation("更新单个学科")
  // todo 重新定义 updateVo
  @RequestMapping(value = "/v1/subjects/{subject_id}/actions/update", method = RequestMethod.PUT)
  SubjectVo update(@PathVariable("subject_id") UUID subjectId);

}
