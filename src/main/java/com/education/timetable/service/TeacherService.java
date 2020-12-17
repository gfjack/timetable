package com.education.timetable.service;

import com.education.timetable.model.vo.PageResult;
import com.education.timetable.model.vo.TeacherCreateVo;
import com.education.timetable.model.vo.TeacherUpdateVo;
import com.education.timetable.model.vo.TeacherVo;

import java.util.List;
import java.util.UUID;

public interface TeacherService {

  /**
   * 获取一个老师
   *
   * @param teacherId 老师id
   * @return 老师vo
   */
  TeacherVo get(Long teacherId);

  /**
   * 创建老师
   *
   * @param teacherCreateVo 老师创建vo
   * @return 老师vo
   */
  TeacherVo create(TeacherCreateVo teacherCreateVo);

  /**
   * 分页查询老师
   *
   * @param offset offset
   * @param limit limit
   * @return pages of teachers
   */
  PageResult<TeacherVo> query(Integer offset, Integer limit);

  /**
   * 根据任教学科搜索老师
   *
   * @param subjectId 学科id
   * @return list of teachers
   */
  List<TeacherVo> searchBySubject(UUID subjectId);

  /**
   * 获取所有老师
   *
   * @return list of teachers
   */
  List<TeacherVo> getAll();

  /**
   * 删除一个老师
   *
   * @param teacherId 老师id
   */
  void delete(Long teacherId);

  /**
   * 批量删除老师
   *
   * @param teacherIds 老师列表
   */
  void delete(List<Long> teacherIds);

  /**
   * 更新老师
   *
   * @param teacherId 老师id
   * @param teacherUpdateVo 老师更新vo
   * @return 老师vo
   */
  TeacherVo update(Long teacherId, TeacherUpdateVo teacherUpdateVo);
}
