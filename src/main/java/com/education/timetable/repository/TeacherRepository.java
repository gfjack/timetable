package com.education.timetable.repository;

import com.education.timetable.model.entity.TeacherPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TeacherRepository extends JpaRepository<TeacherPo, Long> {
    @Query(value = "SELECT * FROM t_teacher LIMIT ?1, ?2", nativeQuery = true)
    List<TeacherPo> findPage(Integer offset, Integer limit);

}
