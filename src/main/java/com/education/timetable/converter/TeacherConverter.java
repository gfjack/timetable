package com.education.timetable.converter;

import com.education.timetable.model.entity.TeacherPo;
import com.education.timetable.model.vo.TeacherVo;

import java.util.ArrayList;
import java.util.List;

public class TeacherConverter {

  public static TeacherVo toTeacherVo(TeacherPo teacherPo) {
    TeacherVo teacherVo = new TeacherVo();
    // todo po/vo 之间相互转换

    return teacherVo;
  }

  public static List<TeacherVo> toTeacherVos(List<TeacherPo> teacherPos) {
    List<TeacherVo> teacherVos = new ArrayList<>();
    for (TeacherPo teacherPo : teacherPos) {
      teacherVos.add(toTeacherVo(teacherPo));
    }

    return teacherVos;
  }
}
