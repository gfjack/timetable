package com.education.timetable.service;

import com.education.timetable.model.vo.*;

import java.util.List;
import java.util.Map;

public interface StudentService {

  StudentVo createStudent (StudentCreateVo studentCreateVo);

  StudentVo getOne(String studentId);

  List<StudentVo> getAll();

  List<StudentVo> getBy(Map<String, Object> params);

  boolean deleteOne(String studentId);

  StudentVo updateOne(StudentUpdateVo studentUpdateVo);

  StudentRegisterVo register(StudentRegisterVo studentRegisterVo);

  StudentWithdrawVo withdraw(StudentWithdrawVo studentWithdrawVo);

}
