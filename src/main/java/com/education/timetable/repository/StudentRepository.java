package com.education.timetable.repository;

import com.education.timetable.model.entity.StudentPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentPo, Long> {

  @Query(value = "SELECT * from t_student LIMIT ?1 ?2", nativeQuery = true)
  List<StudentPo> findPage(Integer offset, Integer limit);

}
