package com.education.timetable.converter;

import com.education.timetable.model.entity.TeacherPo;
import com.education.timetable.model.vo.TeacherCreateVo;
import com.education.timetable.model.vo.TeacherVo;

import java.util.ArrayList;
import java.util.List;

public class TeacherConverter {


    public static TeacherVo toTeacherVo(TeacherPo teacherPo){
        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setTeacherId(teacherPo.getTeacherId());
        teacherVo.setContact(teacherPo.getContact());
        teacherVo.setCourseIds(teacherPo.getCourseIds());
        teacherVo.setTeacherInfo(teacherPo.getTeacherInfo());
        teacherVo.setTeacherName(teacherPo.getTeacherName());
        teacherVo.setSubjectIds(teacherPo.getSubjectIds());
        return teacherVo;
    }

    public static List<TeacherVo> toTeacherVos(List<TeacherPo> teacherPos){
        List<TeacherVo> teacherVos = new ArrayList<>();
        for (TeacherPo teacherPo:teacherPos) {
            teacherVos.add(toTeacherVo(teacherPo));
        }
        return teacherVos;
    }

    public static TeacherPo toTeacherPo(TeacherCreateVo teacherVo) {
        TeacherPo teacherPo = new TeacherPo();
        teacherPo.setTeacherInfo(teacherVo.getTeacherInfo());
        teacherPo.setTeacherName(teacherVo.getTeacherName());
        teacherPo.setContact(teacherVo.getContact());
        teacherPo.setCourseIds(teacherVo.getCourseIds());
        teacherPo.setSubjectIds(teacherVo.getSubjectIds());
        return teacherPo;
    }

}

