package com.education.timetable.service.impl;

import com.education.timetable.config.StringResources;
import com.education.timetable.exception.ObjectNotFoundException;
import com.education.timetable.exception.ServerException;
import com.education.timetable.model.entity.SubjectPo;
import com.education.timetable.model.vo.PageResult;
import com.education.timetable.model.vo.SubjectCreateVo;
import com.education.timetable.model.vo.SubjectUpdateVo;
import com.education.timetable.model.vo.SubjectVo;
import com.education.timetable.repository.SubjectRepository;
import com.education.timetable.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.SubjectConverter.*;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

  @Resource private SubjectRepository subjectRepository;

  private SubjectPo load(UUID subjectId) {
    SubjectPo subjectPo = subjectRepository.findBySubjectId(subjectId);
    if (ObjectUtils.isEmpty(subjectPo)) {
      throw new ObjectNotFoundException(StringResources.getString("SUBJECT.NOT.FOUND"));
    }

    return subjectPo;
  }

  @Override
  public SubjectVo get(UUID subjectId) {
    return toSubjectVo(load(subjectId));
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

  @Override
  public void delete(UUID subjectId) {
    try {
      load(subjectId);
      subjectRepository.delete(subjectId);
    } catch (ObjectNotFoundException e) {
      throw new ObjectNotFoundException(StringResources.getString("SUBJECT.NOT.FOUND"));
    } catch (Exception e) {
      throw new ServerException(StringResources.getString("FAILED.TO.DELETE.SUBJECT"));
    }
  }

  @Override
  public void delete(List<UUID> subjectIds) {
    for (UUID subjectId : subjectIds) {
      try {
        delete(subjectId);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }

  @Override
  public SubjectVo update(UUID subjectId, SubjectUpdateVo subjectUpdateVo) {
    SubjectPo subjectPo = load(subjectId);
    updateSubjectPo(subjectPo, subjectUpdateVo);
    subjectRepository.save(subjectPo);
    return toSubjectVo(subjectPo);
  }
}
