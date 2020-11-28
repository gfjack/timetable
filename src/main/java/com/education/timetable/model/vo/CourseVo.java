package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class CourseVo {

  @ApiModelProperty("课程id")
  private UUID courseId;

  @ApiModelProperty("课程名称")
  private String courseName;

  // todo 拼装
  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("参与学生")
  private List<Long> registeredStudents;

  @ApiModelProperty("开始时间")
  private Date startTime;

  @ApiModelProperty("结束时间")
  private Date endTime;

}
