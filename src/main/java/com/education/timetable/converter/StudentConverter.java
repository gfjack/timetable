package com.education.timetable.converter;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.entity.StudentPo;
import com.education.timetable.model.vo.*;
import com.education.timetable.utils.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {

  public static StudentPo toStudentPo(StudentVo studentVo){
    StudentPo studentPo = new StudentPo();
    studentPo.setStudentId(studentVo.getStudentId());
    studentPo.setStudentInfo(studentVo.getStudentInfo());
    studentPo.setParentContactInfo(studentVo.getParentContactInfo());
    studentPo.setStudentContactInfo(studentVo.getStudentContactInfo());
    studentPo.setParentName(studentVo.getParentName());
    studentPo.setStudentName(studentVo.getStudentName());
    studentPo.setGradeLevel(studentVo.getGradeLevel());
    studentPo.setSchoolName(studentVo.getSchoolName());
    return studentPo;

  }

  public static StudentPo toStudentPo(StudentUpdateVo studentVo){
    StudentPo studentPo = new StudentPo();
    studentPo.setStudentInfo(studentVo.getStudentInfo());
    studentPo.setParentContactInfo(studentVo.getParentContactInfo());
    studentPo.setStudentContactInfo(studentVo.getStudentContactInfo());
    studentPo.setGradeLevel(studentVo.getGradeLevel());
    studentPo.setSchoolName(studentVo.getSchoolName());
    return studentPo;

  }

  public static StudentPo toStudentPo(StudentCreateVo studentVo){
    StudentPo studentPo = new StudentPo();
    studentPo.setStudentId(IdGenerator.generateStudentId(studentVo.getStudentName(), studentVo.getParentContactInfo()));
    studentPo.setStudentInfo(studentVo.getStudentInfo());
    studentPo.setParentContactInfo(studentVo.getParentContactInfo());
    studentPo.setStudentContactInfo(studentVo.getStudentContactInfo());
    studentPo.setParentName(studentVo.getParentName());
    studentPo.setStudentName(studentVo.getStudentName());
    studentPo.setGradeLevel(studentVo.getGradeLevel());
    studentPo.setSchoolName(studentVo.getSchoolName());
    return studentPo;

  }

  public static StudentPo toStudentPo(StudentPo studentPo, StudentUpdateVo studentUpdateVo){
    studentPo.setGradeLevel(studentUpdateVo.getGradeLevel());
    studentPo.setParentContactInfo(studentUpdateVo.getParentContactInfo());
    studentPo.setSchoolName(studentUpdateVo.getSchoolName());
    studentPo.setStudentContactInfo(studentUpdateVo.getStudentContactInfo());
    studentPo.setStudentInfo(studentUpdateVo.getStudentInfo());

    return studentPo;
  }

  public static StudentVo toStudentVo(StudentPo studentPo){
    StudentVo studentVo = new StudentVo();
    studentVo.setGradeLevel(studentPo.getGradeLevel());
    studentVo.setParentContactInfo(studentPo.getParentContactInfo());
    studentVo.setParentName(studentPo.getParentName());
    studentVo.setSchoolName(studentPo.getSchoolName());
    studentVo.setStudentContactInfo(studentPo.getStudentContactInfo());
    studentVo.setStudentId(studentPo.getStudentId());
    studentVo.setStudentInfo(studentPo.getStudentInfo());
    studentVo.setStudentName(studentPo.getStudentName());
    return studentVo;
  }

  public static List<StudentVo> toStudentVos(List<StudentPo> studentPos){
    List<StudentVo> studentVos = new ArrayList<>();
    for (StudentPo studentPo:studentPos) {
      studentVos.add(toStudentVo(studentPo));
    }
    return studentVos;
  }

  public static StudentRegisterVo toStudentRegisterVo(CoursePo coursePo, Long studentId) {
    StudentRegisterVo studentRegisterVo = new StudentRegisterVo();
    studentRegisterVo.setSuccess(false);
    studentRegisterVo.setCourseId(coursePo.getCourseId());
    studentRegisterVo.setCourseName(coursePo.getCourseName());
    studentRegisterVo.setEndTime(coursePo.getEndTime());
    studentRegisterVo.setStartTime(coursePo.getStartTime());
    studentRegisterVo.setStudentId(studentId);

    return studentRegisterVo;
  }

  public static StudentWithdrawVo toStudentWithdrawVo(CoursePo coursePo, Long studentId) {
    StudentWithdrawVo studentWithdrawVo = new StudentWithdrawVo();
    studentWithdrawVo.setSuccess(false);
    studentWithdrawVo.setCourseId(coursePo.getCourseId());
    studentWithdrawVo.setCourseName(coursePo.getCourseName());
    studentWithdrawVo.setStudentId(studentId);

    return studentWithdrawVo;

  }


}
