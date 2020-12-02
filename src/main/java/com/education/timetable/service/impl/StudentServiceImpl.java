package com.education.timetable.service.impl;

import com.education.timetable.converter.StudentConverter;
import com.education.timetable.exception.TimeTableException;
import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.entity.StudentPo;
import com.education.timetable.model.vo.*;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.repository.StudentRepository;
import com.education.timetable.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.StudentConverter.*;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

  @Resource
   private StudentRepository studentRepository;

  @Resource
  private CourseRepository courseRepository;

  @Override
  public StudentVo createStudent(StudentCreateVo studentCreateVo) {
    StudentPo studentPo = toStudentPo(studentCreateVo);
    try {
      studentRepository.save(studentPo);
    } catch (Exception e){
      log.error(e.getMessage());
    }
    return StudentConverter.toStudentVo(studentPo);
  }

  @Override
  public StudentVo getOne(Long studentId) {
    StudentPo studentPo = studentRepository.getOne(studentId);
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
    List<StudentPo> studentPos = studentRepository.findPage(offset,limit);
    studentVoPagerResult.setTotal(studentPos.size());
    studentVoPagerResult.setItems(toStudentVos(studentPos));

    return studentVoPagerResult;
  }

  @Override
  public Boolean deleteOne(Long studentId) {
    try {
      studentRepository.deleteById(studentId);
      return true;
    }catch (Exception e){
      log.error(e.getMessage());
      return false;
    }
  }

  @Override
  public Boolean deleteByIds(List<Long> studentIds){
    Boolean res = true;
    for (Long studentId:studentIds)
      res = deleteOne(studentId) && res;
    return res;
  }

  @Override
  public StudentVo updateOne(Long studentId,StudentUpdateVo studentUpdateVo) {
    StudentPo studentPo = studentRepository.getOne(studentId);
    toStudentPo(studentPo, studentUpdateVo);
    studentRepository.save(studentPo);
    return toStudentVo(studentPo);
  }

  @Override
  public StudentRegisterVo register(Long studentId, UUID courseId) {
    CoursePo coursePo = courseRepository.getOne(courseId);
    StudentRegisterVo studentRegisterVo = new StudentRegisterVo();
    try {
      studentRegisterVo.setSuccess(false);
      studentRegisterVo.setCourseId(coursePo.getCourseId());
      studentRegisterVo.setCourseName(coursePo.getCourseName());
      studentRegisterVo.setEndTime(coursePo.getEndTime());
      studentRegisterVo.setStartTime(coursePo.getStartTime());
      studentRegisterVo.setStudentId(studentId);
    } catch (Exception e){
      log.error(e.getMessage());
    }
    List<Long> registeredStudent = coursePo.getRegisteredStudents();
    if(!registeredStudent.contains(studentId)){
      registeredStudent.add(studentId);
      coursePo.setRegisteredStudents(registeredStudent);
      courseRepository.save(coursePo);
    }else{
      studentRegisterVo.setSuccess(false);
      throw new TimeTableException(HttpStatus.BAD_REQUEST,"already registered");
    }
    studentRegisterVo.setSuccess(true);
    return studentRegisterVo;
  }

  @Override
  public StudentWithdrawVo withdraw(Long studentId, UUID courseId) {
    CoursePo coursePo = courseRepository.getOne(courseId);

    StudentWithdrawVo studentWithdrawVo = new StudentWithdrawVo();
    try {
      studentWithdrawVo.setSuccess(false);
      studentWithdrawVo.setCourseId(coursePo.getCourseId());
      studentWithdrawVo.setCourseName(coursePo.getCourseName());
      studentWithdrawVo.setStudentId(studentId);
    } catch (Exception e){
      log.error(e.getMessage());
    }

    List<Long> registeredStudent = coursePo.getRegisteredStudents();
    if(!registeredStudent.contains(studentWithdrawVo.getStudentId())){
      studentWithdrawVo.setSuccess(false);
      throw new TimeTableException(HttpStatus.BAD_REQUEST,"student not registered yet");
    }else{
      registeredStudent.remove(studentWithdrawVo.getStudentId());
      coursePo.setRegisteredStudents(registeredStudent);
      courseRepository.save(coursePo);
    }
    studentWithdrawVo.setSuccess(true);
    return studentWithdrawVo;
  }
}
