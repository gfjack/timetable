package com.education.timetable.repository;

import com.education.timetable.model.entity.SubjectPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectPo, UUID> {
}
