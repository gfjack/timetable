package com.education.timetable.repository;

import com.education.timetable.model.entity.StudentPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentPo, Long> {
}
