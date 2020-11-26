package com.education.timetable.service.impl;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.CourseCreateVo;
import com.education.timetable.model.vo.CourseVo;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseRepository courseRepository;

	@Override
	public CourseVo create(CourseCreateVo courseCreateVo) {
		CoursePo coursePo = new CoursePo();
		BeanUtils.copyProperties(courseCreateVo, coursePo);
		coursePo.setRegisteredStudents(courseCreateVo.getRegisteredStudents());
		coursePo.setCourseNumOfStudents(courseCreateVo.getCourseNumOfStudents());
		coursePo.setCourseId(UUID.randomUUID());
		coursePo.setSubjectId(UUID.randomUUID());
		coursePo.setStartTime(new Date());
		coursePo.setEndTime(new Date());
		coursePo.setCourseName("测试课程名称");
		coursePo.setSubjectName("测试学科名称");
		courseRepository.save(coursePo);
		return null;
	}
}
