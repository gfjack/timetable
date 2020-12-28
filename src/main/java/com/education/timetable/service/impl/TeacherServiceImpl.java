package com.education.timetable.service.impl;

import com.education.timetable.config.StringResources;
import com.education.timetable.exception.ObjectNotFoundException;
import com.education.timetable.exception.ServerException;
import com.education.timetable.exception.TimeTableException;
import com.education.timetable.model.entity.TeacherPo;
import com.education.timetable.model.vo.PageResult;
import com.education.timetable.model.vo.TeacherCreateVo;
import com.education.timetable.model.vo.TeacherUpdateVo;
import com.education.timetable.model.vo.TeacherVo;
import com.education.timetable.repository.TeacherRepository;
import com.education.timetable.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.TeacherConverter.*;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

  @Resource private TeacherRepository teacherRepository;

  private TeacherPo load(Long teacherId) {
    TeacherPo teacherPo = teacherRepository.findOne(teacherId);
    if (ObjectUtils.isEmpty(teacherPo)) {
      throw new ObjectNotFoundException(StringResources.getString("TEACHER.NOT.FOUND"));
    }

    return teacherPo;
  }

  public TeacherVo get(Long teacherId) {
    return toTeacherVo(load(teacherId));
  }

  public TeacherVo create(TeacherCreateVo teacherCreateVo) {
    TeacherPo teacherPo = toTeacherPo(teacherCreateVo);
    try {
      teacherRepository.save(teacherPo);
    } catch (Exception e) {
      throw new TimeTableException(e.getMessage());
    }
    return toTeacherVo(teacherPo);
  }

  public PageResult<TeacherVo> query(Integer offset, Integer limit) {
    return null;
  }

  public List<TeacherVo> searchBySubject(UUID subjectId) {
    return toTeacherVos(teacherRepository.findBySubjectId(subjectId));
  }

  @Override
  public List<TeacherVo> getAll() {
    List<TeacherPo> teacherPos = teacherRepository.findAll();
    return toTeacherVos(teacherPos);
  }


  public void delete(Long teacherId) {
    try {
      load(teacherId);
      teacherRepository.delete(teacherId);
    } catch (ObjectNotFoundException e) {
      throw new ObjectNotFoundException(StringResources.getString("TEACHER.NOT.FOUND"));
    } catch (Exception e) {
      throw new ServerException(StringResources.getString("FAILED.TO.DELETE.TEACHER"));
    }
  }

  public void delete(List<Long> teacherIds) {
    for (Long teacherId : teacherIds) {
      try {
        delete(teacherId);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }

  public TeacherVo update(Long teacherId, TeacherUpdateVo teacherUpdateVo) {
    TeacherPo teacherPo = load(teacherId);
    updateTeacher(teacherPo, teacherUpdateVo);
    teacherRepository.save(teacherPo);
    return toTeacherVo(teacherPo);
  }
}
