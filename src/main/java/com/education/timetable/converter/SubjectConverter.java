package com.education.timetable.converter;

import com.education.timetable.model.entity.SubjectPo;
import com.education.timetable.model.vo.SubjectVo;

import java.util.ArrayList;
import java.util.List;

public class SubjectConverter {

  public static SubjectVo toSubjectVo(SubjectPo subjectPo) {
    SubjectVo subjectVo = new SubjectVo();
    // todo po/vo 之间转换数据

    return subjectVo;
  }

  public static List<SubjectVo> toSubjectVos(List<SubjectPo> subjectPos) {
    List<SubjectVo> subjectVos = new ArrayList<>();
    for (SubjectPo subjectPo : subjectPos) {
      subjectVos.add(toSubjectVo(subjectPo));
    }

    return subjectVos;
  }
}
