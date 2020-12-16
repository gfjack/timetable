package com.education.timetable.service;

import com.education.timetable.model.vo.*;

import java.util.List;
import java.util.UUID;

public interface StudentService {

  /**
   * 创建学生
   * @param studentCreateVo 学生创建vo
   * @return 学生vo
   */
  StudentVo createStudent (StudentCreateVo studentCreateVo);

  /**
   * 获取一个学生
   * @param studentId 学生id
   * @return 学生vo
   */
  StudentVo getOne(Long studentId);

  /**
   * 获取全部学生
   * @return list of students
   */
  List<StudentVo> getAll();

  /**
   * 分页查询学生
   * @param offset offset
   * @param limit limit
   * @return pages of students
   */
  PageResult<StudentVo> query(Integer offset, Integer limit);

  /**
   * 根据学生id删除学生信息
   * @param studentId 学生id
   * */
  void deleteOne(Long studentId);

  /**
   * 批量删除
   * @param studentIds 学生id
   * */
  void deleteByIds(List<Long> studentIds);

  /**
   * 更新学生
   * @param studentId 学生id
   * @param studentUpdateVo 学生更新vo
   * @return 学生vo
   */
  StudentVo updateOne(Long studentId,StudentUpdateVo studentUpdateVo);

  /**
   * 学生报名
   * @param studentId 学生id
   * @param courseId 待报名课程
   * @return 学生报名情况vo
   */
  StudentRegisterVo register(Long studentId, UUID courseId);

  /**
   * 撤销学生报名
   * @param studentId 学生id
   * @param courseId 待撤销课程id
   * @return 学生撤销报名vo
   */
  StudentWithdrawVo withdraw(Long studentId, UUID courseId);

}
