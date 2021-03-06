package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@ApiModel("返回学科vo")
public class SubjectVo implements Serializable {
  @ApiModelProperty("学科id")
  private UUID subjectId;

  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("学科简介")
  private String subjectIntroduction;

  @ApiModelProperty("学科阶段")
  private Integer sprint;
}
