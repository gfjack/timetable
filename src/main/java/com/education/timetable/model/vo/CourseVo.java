package com.education.timetable.model.vo;

import com.education.timetable.constants.enums.Week;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@ApiModel("课程返回vo")
public class CourseVo implements Serializable {

  @ApiModelProperty("课程id")
  private UUID courseId;

  @ApiModelProperty("课程名称")
  private String courseName;

  @ApiModelProperty("课程简介")
  private String courseIntroduction;

  // todo 拼装
  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("老师id")
  private Long teacherId;

  @ApiModelProperty("参与学生")
  private List<Long> registeredStudents;

  @ApiModelProperty("开始时间")
  private Date startTime;

  @ApiModelProperty("结束时间")
  private Date endTime;

  @ApiModelProperty(value = "日期", example = "周日, 周一, 周二")
  private Week day;
}
