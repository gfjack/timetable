package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;

public class SubjectSearchVo {

  @ApiModelProperty("阶段")
  @NonNull
  private Integer sprint;
}
