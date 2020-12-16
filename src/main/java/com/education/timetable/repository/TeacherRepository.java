package com.education.timetable.repository;

import com.education.timetable.model.entity.TeacherPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherPo, Long> {

    TeacherPo findByTeacherId(Long teacherId);
}
