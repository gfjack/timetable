package com.education.timetable.service.impl;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.CourseVo;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.education.timetable.converter.CourseConverter.toCourseVo;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseRepository courseRepository;

	@Override
	public List<CourseVo> getAll() {
		List<CourseVo> res = new ArrayList<>();
		List<CoursePo> courses = courseRepository.findAll();
		for (CoursePo course : courses) {
			res.add(toCourseVo(course));
		}
		return res;
	}
}
