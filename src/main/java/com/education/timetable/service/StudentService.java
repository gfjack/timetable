package com.education.timetable.service;

import com.education.timetable.model.vo.*;

import java.util.List;
import java.util.UUID;

public interface StudentService {

  /**
   * 创建学生信息
   * @param studentCreateVo
   * */
  StudentVo createStudent (StudentCreateVo studentCreateVo);

  /**
   * 根据学生id取学生信息
   * @param studentId
   * */
  StudentVo getOne(Long studentId);

  /**
   * 获取全部学生信息
   * */
  List<StudentVo> getAll();

  /**
   * 分页查找
   * */
  page.PagerResult<StudentVo> query(Integer offset, Integer limit);

  /**
   * 根据学生id删除学生信息
   * @param studentId
   * */
  void deleteOne(Long studentId);

  /**
   * 批量删除
   * @param studentIds
   * */
  void deleteByIds(List<Long> studentIds);

  /**
   * 更新学生信息
   * @param studentId
   * @param studentUpdateVo
   * */
  StudentVo updateOne(Long studentId,StudentUpdateVo studentUpdateVo);

  /**
   * 学生报名
   * @param studentId
   * @param courseId
   * */
  StudentRegisterVo register(Long studentId, UUID courseId);

  /**
   *  学生退课
   * @param studentId
   * @param courseId
   * */
  StudentWithdrawVo withdraw(Long studentId, UUID courseId);

}
