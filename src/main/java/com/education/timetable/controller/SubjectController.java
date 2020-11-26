package com.education.timetable.controller;

import com.education.timetable.api.SubjectApi;
import com.education.timetable.model.vo.SubjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Api("学科api")
@RestController
@RequestMapping("")
public class SubjectController implements SubjectApi {

  @ApiOperation("获取单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}", method = RequestMethod.GET)
  @Override
  public SubjectVo get(@PathVariable("subject_id") UUID subjectId) {
    return null;
  }

  @ApiOperation("获取多个学科")
  @RequestMapping(value = "/v1/subjects", method = RequestMethod.GET)
  @Override
  public List<SubjectVo> getAll() {
    return null;
  }

  @ApiOperation("删除单个学科")
  @RequestMapping(value = "/v1/subjects/{subject_id}/actions/delete", method = RequestMethod.GET)
  @Override
  public void delete(@PathVariable("subject_id") UUID subjectId) {

  }

  @ApiOperation("更新单个学科")
  // todo 重新定义 updateVo
  @RequestMapping(value = "/v1/subjects/{subject_id}/actions/update", method = RequestMethod.PUT)
  @Override
  public SubjectVo update(@PathVariable("subject_id") UUID subjectId) {
    return null;
  }

}
