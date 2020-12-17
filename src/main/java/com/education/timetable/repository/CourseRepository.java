package com.education.timetable.repository;

import com.education.timetable.constants.enums.Week;
import com.education.timetable.model.entity.CoursePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CoursePo, UUID> {

  @Query(value = "SELECT * FROM t_course LIMIT ?1, ?2", nativeQuery = true)
  List<CoursePo> findPage(Integer offset, Integer limit);

  List<CoursePo> findAllBySubjectId(UUID subjectId);

  List<CoursePo> findAllByDay(Week day);

  CoursePo findByCourseId(UUID courseId);
}
