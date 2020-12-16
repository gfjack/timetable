package com.education.timetable.service;

import com.education.timetable.model.vo.PageResult;
import com.education.timetable.model.vo.SubjectCreateVo;
import com.education.timetable.model.vo.SubjectUpdateVo;
import com.education.timetable.model.vo.SubjectVo;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    /**
     * 获取一个学科
     * @param subjectId 学科id
     * @return 学科vo
     */
    SubjectVo get(UUID subjectId);

    /**
     * 获取全部学科
     * @return list of subjects
     */
    List<SubjectVo> getAll();

    /**
     * 分页查询学科
     * @param offset offset
     * @param limit limit
     * @return pages of subjects
     */
    PageResult<SubjectVo> query(Integer offset, Integer limit);

    /**
     * 创建学科
     * @param subjectCreateVo 创建学科vo
     * @return 学科vo
     */
    SubjectVo create(SubjectCreateVo subjectCreateVo);

    /**
     * 根据阶段来查找学科
     * @param sprint 阶段编码
     * @return list of subjects
     */
    List<SubjectVo> search(Integer sprint);

    /**
     * 删除一个学科
     * @param subjectId 学科id
     */
    void delete(UUID subjectId);

    /**
     * 批量删除学科
     * @param subjectIds 学科列表
     */
    void delete(List<UUID> subjectIds);

    /**
     * 更新学科
     * @param subjectId 学科id
     * @param subjectUpdateVo 更新vo
     * @return 学科vo
     */
    SubjectVo update(UUID subjectId, SubjectUpdateVo subjectUpdateVo);
}
