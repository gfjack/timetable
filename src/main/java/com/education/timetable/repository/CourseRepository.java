package com.education.timetable.repository;

import com.education.timetable.model.entity.CoursePo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CoursePo, UUID> {
}
