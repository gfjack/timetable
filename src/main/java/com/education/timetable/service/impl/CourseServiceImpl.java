package com.education.timetable.service.impl;

import com.education.timetable.model.entity.CoursePo;
import com.education.timetable.model.vo.CourseVo;
import com.education.timetable.repository.CourseRepository;
import com.education.timetable.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import static com.education.timetable.converter.CourseConverter.toCourseVo;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseRepository courseRepository;

	/**
	 * 创建某个时间段课程(测试)
	 * @param coursePo 课程 po
	 * @return 课程vo
	 */
	@Override
	public CourseVo create(CoursePo coursePo) {
		CoursePo saveCourse = courseRepository.save(coursePo);
		return toCourseVo(saveCourse);
	}
}
