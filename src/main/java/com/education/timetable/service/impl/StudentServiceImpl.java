package com.education.timetable.service.impl;

import com.education.timetable.config.StringResources;
import com.education.timetable.converter.StudentConverter;
import com.education.timetable.exception.TimeTableException;
import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.entity.StudentPo;
import com.education.timetable.model.vo.*;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.repository.StudentRepository;
import com.education.timetable.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.StudentConverter.*;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

  @Resource private StudentRepository studentRepository;

  @Resource private CourseRepository courseRepository;

  @Override
  public StudentVo createStudent(StudentCreateVo studentCreateVo) {
    StudentPo studentPo = toStudentPo(studentCreateVo);
    try {
      studentRepository.save(studentPo);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return StudentConverter.toStudentVo(studentPo);
  }

  // todo 如果之后要引入缓存, 最好有一个整体不出现在接口上的加载方法去读取课程达到缓存归一可控性, 类似于load()
  // todo 业务逻辑处理, 可能出现空指针
  @Override
  public StudentVo getOne(Long studentId) {
    StudentPo studentPo = studentRepository.findByStudentId(studentId);
    if (ObjectUtils.isEmpty(studentPo)) {
      // todo 应该给予业务抛出异常处理
    }

    return toStudentVo(studentPo);
  }

  @Override
  public List<StudentVo> getAll() {
    List<StudentPo> studentPos = studentRepository.findAll();
    return toStudentVos(studentPos);
  }

  @Override
  public page.PagerResult<StudentVo> query(Integer offset, Integer limit) {
    page.PagerResult<StudentVo> studentVoPagerResult = new page.PagerResult<>();
    List<StudentPo> studentPos = studentRepository.findPage(offset, limit);
    studentVoPagerResult.setTotal(studentPos.size());
    studentVoPagerResult.setItems(toStudentVos(studentPos));

    return studentVoPagerResult;
  }

  // todo 删除单个如果不存在的情况应该给予异常处理, 一般由服务端控制业务语句, 前端不做业务处理, 前端可直接引用异常信息Unicode编码报错出去
  @Override
  public void deleteOne(Long studentId) {
    try {
      // todo 删除一个一般先加载, 或者通过缓存load()加载减小数据库压力
      getOne(studentId);
      studentRepository.deleteById(studentId);
    } catch (Exception e) {
      log.error(e.getMessage());
      // todo 应该给予业务抛出异常处理
    }
  }

  // todo 删除多个顺应逻辑直接删除可删除的，其他给予业务逻辑异常处理
  @Override
  public void deleteByIds(List<Long> studentIds) {
    for (Long studentId : studentIds) {
      try{
        deleteOne(studentId);
      } catch (Exception e) {
        // todo 应该给予业务异常处理, 但不应该抛出异常
      }
    }
  }

  @Override
  public StudentVo updateOne(Long studentId, StudentUpdateVo studentUpdateVo) {
    StudentPo studentPo = studentRepository.getOne(studentId);
    toStudentPo(studentPo, studentUpdateVo);
    studentRepository.save(studentPo);
    return toStudentVo(studentPo);
  }

  @Override
  public StudentRegisterVo register(Long studentId, UUID courseId) {
    CoursePo coursePo = courseRepository.getOne(courseId);
    StudentRegisterVo studentRegisterVo = toStudentRegisterVo(coursePo, studentId);

    // 检测是否已经注册
    List<Long> registeredStudent = coursePo.getRegisteredStudents();
    if (!registeredStudent.contains(studentId)) {
      registeredStudent.add(studentId);
      coursePo.setRegisteredStudents(registeredStudent);
      courseRepository.save(coursePo);
    } else {
      studentRegisterVo.setSuccess(false);
      throw new TimeTableException(HttpStatus.BAD_REQUEST, StringResources.getString("STUDENT.ALREADY.REGISTERED"));
    }
    studentRegisterVo.setSuccess(true);
    return studentRegisterVo;
  }

  @Override
  public StudentWithdrawVo withdraw(Long studentId, UUID courseId) {
    CoursePo coursePo = courseRepository.getOne(courseId);
    StudentWithdrawVo studentWithdrawVo = toStudentWithdrawVo(coursePo, studentId);

    // 检测是否已经注册
    List<Long> registeredStudent = coursePo.getRegisteredStudents();
    if (!registeredStudent.contains(studentWithdrawVo.getStudentId())) {
      studentWithdrawVo.setSuccess(false);
      throw new TimeTableException(HttpStatus.BAD_REQUEST, StringResources.getString("STUDENT.NOT.REGISTER"));
    } else {
      registeredStudent.remove(studentWithdrawVo.getStudentId());
      coursePo.setRegisteredStudents(registeredStudent);
      courseRepository.save(coursePo);
    }
    studentWithdrawVo.setSuccess(true);
    return studentWithdrawVo;
  }
}
