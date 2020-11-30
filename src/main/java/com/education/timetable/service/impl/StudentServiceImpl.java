package com.education.timetable.service.impl;

import com.education.timetable.model.vo.StudentCreateVo;
import com.education.timetable.model.vo.StudentRegisterVo;
import com.education.timetable.model.vo.StudentUpdateVo;
import com.education.timetable.model.vo.StudentVo;
import com.education.timetable.model.vo.StudentWithdrawVo;
import com.education.timetable.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {
  @Override
  public StudentVo createStudent(StudentCreateVo studentCreateVo) {
    return null;
  }

  @Override
  public StudentVo getOne(String studentId) {
    return null;
  }

  @Override
  public List<StudentVo> getAll() {
    return null;
  }

  @Override
  public List<StudentVo> getBy(Map<String, Object> params) {
    return null;
  }

  @Override
  public boolean deleteOne(String studentId) {
    return false;
  }

  @Override
  public StudentVo UpdateOne(StudentUpdateVo studentUpdateVo) {
    return null;
  }

  @Override
  public StudentRegisterVo register(StudentRegisterVo studentRegisterVo) {
    return null;
  }

  @Override
  public StudentWithdrawVo withdraw(StudentWithdrawVo studentWithdrawVo) {
    return null;
  }
}
