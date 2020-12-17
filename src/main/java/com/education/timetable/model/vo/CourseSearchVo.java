package com.education.timetable.model.vo;

import com.education.timetable.constants.enums.Week;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程搜索vo")
public class CourseSearchVo {

  @ApiModelProperty("学生id")
  private Long studentId;

  @ApiModelProperty("开始时间")
  private Date startTime;

  @ApiModelProperty("结束时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;

  @ApiModelProperty(value = "日期", example = "周日, 周一, 周二")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Week day;
}
