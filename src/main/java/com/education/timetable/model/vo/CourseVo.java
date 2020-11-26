package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CourseVo {

  @ApiModelProperty("课程id")
  private UUID courseId;

  @ApiModelProperty("课程名称")
  private String courseName;

  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("课程人数")
  private Integer courseNumOfStudents;

  @ApiModelProperty("开始时间")
  private Date startTime;

  @ApiModelProperty("结束时间")
  private Date endTime;

}
