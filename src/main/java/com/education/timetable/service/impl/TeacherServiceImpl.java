package com.education.timetable.service.impl;

import com.education.timetable.model.entity.TeacherPo;
import com.education.timetable.model.vo.TeacherVo;
import com.education.timetable.repository.TeacherRepository;
import com.education.timetable.service.TeacherService;
import org.springframework.stereotype.Service;

import static com.education.timetable.converter.TeacherConverter.*;


import javax.annotation.Resource;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherRepository teacherRepository;
    @Override
    public List<TeacherVo> getAll() {
        List<TeacherPo> teacherPos = teacherRepository.findAll();
        return toTeacherVos(teacherPos);
    }

}
