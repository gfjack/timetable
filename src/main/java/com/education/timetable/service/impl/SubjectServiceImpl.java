package com.education.timetable.service.impl;

import com.education.timetable.model.entity.SubjectPo;
import com.education.timetable.model.vo.PageResult;
import com.education.timetable.model.vo.SubjectCreateVo;
import com.education.timetable.model.vo.SubjectUpdateVo;
import com.education.timetable.model.vo.SubjectVo;
import com.education.timetable.repository.SubjectRepository;
import com.education.timetable.service.SubjectService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.SubjectConverter.toSubjectVo;
import static com.education.timetable.converter.SubjectConverter.toSubjectVos;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Resource private SubjectRepository subjectRepository;

  // todo 可以引入缓存集中化
  private SubjectVo load(UUID subjectId) {
    SubjectPo subjectPo = subjectRepository.findBySubjectId(subjectId);
    if (ObjectUtils.isEmpty(subjectPo)) {
      // todo 抛出业务异常处理
    }

    return toSubjectVo(subjectPo);
  }

  @Override
  public SubjectVo get(UUID subjectId) {
    return load(subjectId);
  }

  @Override
  public List<SubjectVo> getAll() {
    List<SubjectPo> subjectPos = subjectRepository.findAll();
    return toSubjectVos(subjectPos);
  }

  @Override
  public PageResult<SubjectVo> query(Integer offset, Integer limit) {
    return null;
  }

  @Override
  public SubjectVo create(SubjectCreateVo subjectCreateVo) {
    return null;
  }

  @Override
  public List<SubjectVo> search(Integer sprint) {
    return null;
  }

  // todo 删除单个如果不存在的情况应该给予异常处理, 一般由服务端控制业务语句, 前端不做业务处理, 前端可直接引用异常信息Unicode编码报错出去
  @Override
  public void delete(UUID subjectId) {
    try {
      load(subjectId);
      subjectRepository.deleteById(subjectId);
    } catch (Exception e) {
      // todo 抛出业务异常处理
    }
  }

  // todo 删除多个顺应逻辑直接删除可删除的，其他给予业务逻辑异常处理
  @Override
  public void delete(List<UUID> subjectIds) {
    for (UUID subjectId : subjectIds) {
      try {
        delete(subjectId);
      } catch (Exception e) {
        // todo 不抛出异常, 直接处理业务异常, 流程直接走完
      }
    }
  }

  @Override
  public SubjectVo update(UUID subjectId, SubjectUpdateVo subjectUpdateVo) {
    return null;
  }
}
