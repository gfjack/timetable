package com.education.timetable.service.impl;

import com.education.timetable.model.entity.TeacherPo;
import com.education.timetable.model.vo.PageResult;
import com.education.timetable.model.vo.TeacherCreateVo;
import com.education.timetable.model.vo.TeacherUpdateVo;
import com.education.timetable.model.vo.TeacherVo;
import com.education.timetable.repository.TeacherRepository;
import com.education.timetable.service.TeacherService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.education.timetable.converter.TeacherConverter.toTeacherVo;
import static com.education.timetable.converter.TeacherConverter.toTeacherVos;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    // todo 可以引入缓存集中化
    private TeacherVo load(Long teacherId) {
        TeacherPo teacherPo = teacherRepository.findByTeacherId(teacherId);
        if (ObjectUtils.isEmpty(teacherPo)) {
            // todo 抛出业务异常处理
        }

        return toTeacherVo(teacherPo);
    }

    @Override
    public TeacherVo get(Long teacherId) {
        return load(teacherId);
    }

    @Override
    public TeacherVo create(TeacherCreateVo teacherCreateVo) {
        return null;
    }

    @Override
    public PageResult<TeacherVo> query(Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<TeacherVo> searchBySubject(UUID subjectId) {
        return null;
    }

    @Override
    public List<TeacherVo> getAll() {
        List<TeacherPo> teacherPos = teacherRepository.findAll();
        return toTeacherVos(teacherPos);
    }

    // todo 删除单个如果不存在的情况应该给予异常处理, 一般由服务端控制业务语句, 前端不做业务处理, 前端可直接引用异常信息Unicode编码报错出去
    @Override
    public void delete(Long teacherId) {
        try {
            load(teacherId);
            teacherRepository.deleteById(teacherId);
        } catch (Exception e) {
            // todo 抛出业务异常处理
        }
    }

    // todo 删除多个顺应逻辑直接删除可删除的，其他给予业务逻辑异常处理
    @Override
    public void delete(List<Long> teacherIds) {
        for (Long teacherId : teacherIds) {
            try{
                delete(teacherId);
            } catch (Exception e) {
                // todo 不抛出异常, 直接处理业务异常, 流程直接走完
            }
        }
    }

    @Override
    public TeacherVo update(Long teacherId, TeacherUpdateVo teacherUpdateVo) {
        return null;
    }
}
