package com.education.timetable.service.impl;

import com.education.timetable.config.SR;
import com.education.timetable.converter.StudentConverter;
import com.education.timetable.exception.ObjectNotFoundException;
import com.education.timetable.exception.ServerException;
import com.education.timetable.exception.TimeTableException;
import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.entity.StudentPo;
import com.education.timetable.model.vo.*;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.repository.StudentRepository;
import com.education.timetable.service.StudentService;
import lombok.extern.slf4j.Slf4j;
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

  private StudentPo load(Long studentId) {
    StudentPo studentPo = studentRepository.findOne(studentId);
    if (null == studentPo) {
      throw new ObjectNotFoundException(SR.getString("STUDENT.NOT.FOUND"));
    }

    return studentPo;
  }

  @Override
  public StudentVo createStudent(StudentCreateVo studentCreateVo) {
    StudentPo studentPo = toStudentPo(studentCreateVo);
    try {
      studentRepository.save(studentPo);
    } catch (Exception e) {
      throw new TimeTableException(e.getMessage());
    }
    return StudentConverter.toStudentVo(studentPo);
  }

  @Override
  public StudentVo getOne(Long studentId) {
    return toStudentVo(load(studentId));
  }

  @Override
  public List<StudentVo> getAll() {
    List<StudentPo> studentPos = studentRepository.findAll();
    return toStudentVos(studentPos);
  }

  @Override
  public PageResult<StudentVo> query(Integer offset, Integer limit) {
    PageResult<StudentVo> studentVoPagerResult = new PageResult<>();
    List<StudentPo> studentPos = studentRepository.findPage(offset, limit);
    studentVoPagerResult.setCount(studentPos.size());
    studentVoPagerResult.setItems(toStudentVos(studentPos));

    return studentVoPagerResult;
  }

  @Override
  public void deleteOne(Long studentId) {
    try {
      load(studentId);
      getOne(studentId);
      studentRepository.delete(studentId);
    } catch (ObjectNotFoundException e) {
      throw new ObjectNotFoundException(SR.getString("STUDENT.NOT.FOUND"));
    } catch (Exception e) {
      throw new ServerException(SR.getString("FAILED.TO.DELETE.STUDENT"));
    }
  }

  @Override
  public void deleteByIds(List<Long> studentIds) {
    for (Long studentId : studentIds) {
      try {
        deleteOne(studentId);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }

  @Override
  public StudentVo updateOne(Long studentId, StudentUpdateVo studentUpdateVo) {
    StudentPo studentPo = studentRepository.getOne(studentId);
    updateStudentPo(studentPo, studentUpdateVo);
    try{
      studentRepository.save(studentPo);
    } catch (Exception e) {
      throw new ServerException(e.getMessage());
    }
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
      throw new TimeTableException(SR.getString("STUDENT.ALREADY.REGISTERED"));
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
      throw new TimeTableException(SR.getString("STUDENT.NOT.REGISTER"));
    } else {
      registeredStudent.remove(studentWithdrawVo.getStudentId());
      coursePo.setRegisteredStudents(registeredStudent);
      courseRepository.save(coursePo);
    }
    studentWithdrawVo.setSuccess(true);
    return studentWithdrawVo;
  }
}
