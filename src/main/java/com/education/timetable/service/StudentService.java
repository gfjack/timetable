package com.education.timetable.service;

import com.education.timetable.model.entity.StudentPo;
import com.education.timetable.model.vo.StudentCreateVo;
import com.education.timetable.model.vo.StudentRegisterVo;
import com.education.timetable.model.vo.StudentUpdateVo;
import com.education.timetable.model.vo.StudentVo;
import com.education.timetable.model.vo.StudentWithdrawVo;

import java.util.List;
import java.util.Map;

public interface StudentService {

  StudentVo createStudent (StudentCreateVo studentCreateVo);

  StudentVo getOne(String studentId);

  List<StudentVo> getAll();

  List<StudentVo> getBy(Map<String, Object> params);

  boolean deleteOne(String studentId);

  StudentVo UpdateOne(StudentUpdateVo studentUpdateVo);

  StudentRegisterVo register(StudentRegisterVo studentRegisterVo);

  StudentWithdrawVo withdraw(StudentWithdrawVo studentWithdrawVo);

}
