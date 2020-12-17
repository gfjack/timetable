package com.education.timetable.model.vo;

import com.education.timetable.constants.enums.Week;
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
  private Date endTime;

  @ApiModelProperty(value = "日期", example = "周日, 周一, 周二")
  private Week day;
}
