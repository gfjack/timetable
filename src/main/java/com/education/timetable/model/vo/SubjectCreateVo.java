package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建学科vo")
public class SubjectCreateVo {

  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("学科简介")
  private String subjectIntroduction;

  @ApiModelProperty("学科阶段")
  private Integer sprint;
}
