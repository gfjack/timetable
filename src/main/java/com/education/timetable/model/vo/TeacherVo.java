package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@ApiModel("返回老师vo")
public class TeacherVo implements Serializable {

  @ApiModelProperty("教师id")
  private Long teacherId;

  @ApiModelProperty("教师姓名")
  private String teacherName;

  @ApiModelProperty("联系方式")
  private String contact;

  @ApiModelProperty("老师简介")
  private String teacherInfo;

  @ApiModelProperty("任教学科")
  private Long subjectIds;

  @ApiModelProperty("任教课程")
  private List<UUID> courseIds;
}
